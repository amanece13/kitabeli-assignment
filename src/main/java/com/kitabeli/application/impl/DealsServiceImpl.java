package com.kitabeli.application.impl;

import com.kitabeli.application.config.DealsConfig;
import com.kitabeli.application.entity.Deal;
import com.kitabeli.application.entity.ExpiredDeals;
import com.kitabeli.application.entity.Product;
import com.kitabeli.application.model.DealModel;
import com.kitabeli.application.respository.DealsRepository;
import com.kitabeli.application.respository.ExpiredDealsRepository;
import com.kitabeli.application.respository.ProductRepository;
import com.kitabeli.application.service.DealsService;
import com.kitabeli.application.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DealsServiceImpl implements DealsService {

    @Autowired
    private DealsRepository dealsRepository;

    @Autowired
    private ExpiredDealsRepository expiredDealsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DealsConfig dealsConfig;

    private static List<Product> products = Collections.emptyList();
    private static List<DealModel> dealModels = Collections.emptyList();
    private static List<Deal> newActiveDeals = Collections.emptyList();
    private static List<Deal> aboutToExpire = Collections.emptyList();
    private static List<ExpiredDeals> expiringDeals = Collections.emptyList();


    private static List<Product> pickNRandom(List<Product> lst, int n) {
        List<Product> copy = new ArrayList<Product>(lst);
        Collections.shuffle(copy);
        return n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n);
    }

    @Override
    public List<DealModel> fetchDeals(String status) {
        if (status.equalsIgnoreCase("active")) {
//            refreshDeals();
            List<Deal> activeDeals = dealsRepository.findAll();
            return ModelUtil.getDealModelFromDeal(activeDeals);
        } else {
            List<ExpiredDeals> activeDeals = expiredDealsRepository.findAll();
            return ModelUtil.getDealModelFromExpiredDeals(activeDeals);
        }
    }

    @Override
    public void refreshDeals() {

        //case 1: when the deals are created for the first time
        List<ExpiredDeals> existingExpiredDeals = expiredDealsRepository.findAll();
        List<Deal> availableDeals = dealsRepository.findAll();

        if (existingExpiredDeals.size() == 0 && availableDeals.size() == 0) {

            products = productRepository.findAll();
            dealModels = processDiscount(products);
            newActiveDeals = ModelUtil.getDealFromDealModelList(dealModels);
            dealsRepository.saveAll(newActiveDeals);

        }
        //case 2: when the deals are refreshed for the first time
        else if (existingExpiredDeals.size() == 0 && availableDeals.size() != 0) {
            //fetch unique product ids from products table that have not been included in any deal yet
            products = (List<Product>) productRepository.findAllUnusedProductsUsingActiveDeals();
            expireAndProcessNewDeals(products);


        }
        //case 3: when we already have expired deals
        else {
            //fetch unique product ids from products table that are not in expired deals table
            products = (List<Product>) productRepository.findAllUnusedProductsUsingExpiredDeals();
            expireAndProcessNewDeals(products);
        }
    }

    private void expireAndProcessNewDeals(List<Product> products) {
        //create new deals with discount
        dealModels = processDiscount(products);

        //deals which are about to expire
        aboutToExpire = dealsRepository.findAll();

        //convert the expired deals to persist them
        expiringDeals = ModelUtil.getExpiredDealsFromDeals(aboutToExpire);
        expiredDealsRepository.saveAll(expiringDeals);

        //remove all existing active deals
        dealsRepository.deleteAll();

        //save new active deals
        newActiveDeals = ModelUtil.getDealFromDealModelList(dealModels);
        dealsRepository.saveAll(newActiveDeals);
    }

    private int getRandomDiscount() {
        int min = dealsConfig.getMinDiscount();
        int max = dealsConfig.getMaxDiscount();
        return (int) ((Math.random() * (max - min)) + min);
    }

    private List<DealModel> processDiscount(List<Product> products) {
        List<Product> shuffledList = pickNRandom(products, dealsConfig.getMinDeals());


        //filter list items with inventory more than 0
        shuffledList.stream().filter(m ->
                m.getProductInventory().getQuantity() > 0)
                .collect(toList());

        //add discount on them
        return shuffledList.stream().map(
                product -> new DealModel(product.getId(),
                        product.getName(),
                        product.getDescription(),
                        getRandomDiscount(),
                        System.currentTimeMillis(),
                        System.currentTimeMillis() + dealsConfig.getDealExpireTime()))
                .collect(toList());
    }
}
