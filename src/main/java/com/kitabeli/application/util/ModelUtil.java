package com.kitabeli.application.util;

import com.kitabeli.application.entity.Deal;
import com.kitabeli.application.entity.ExpiredDeals;
import com.kitabeli.application.entity.Product;
import com.kitabeli.application.model.DealModel;
import com.kitabeli.application.model.ProductModel;
import com.kitabeli.application.respository.ProductCategoryRepository;
import com.kitabeli.application.respository.ProductInventoryRepository;
import com.kitabeli.application.respository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ModelUtil {

    private static ProductRepository productRepository;
    private static ProductCategoryRepository productCategoryRepository;
    private static ProductInventoryRepository productInventoryRepository;

    @Autowired
    public ModelUtil (ProductRepository prodRepo,ProductCategoryRepository productCategoryRepo,
                      ProductInventoryRepository productInventoryRepo ){
        productRepository = prodRepo;
        productCategoryRepository = productCategoryRepo;
        productInventoryRepository = productInventoryRepo;
    }

    //method to fetch Product from ProductModel
    public static Product getproduct(ProductModel productModel){

        log.info("Fetching product from ProductModel");
        Product product = Product.builder()
                .name(productModel.getName())
                .description(productModel.getDescription())
                .price(productModel.getPrice())
                .created_at(new Timestamp(productModel.getCreatedAt()))
                .modified_at(new Timestamp(System.currentTimeMillis()))
                .build();
        return product;
    }

    //method to fetch List of Product from List of ProductModel
    public static List<Product> getproductList(List<ProductModel> products){

        log.info("Fetching List of Product from List of ProductModel");
        return products.stream().map(
                product -> new Product(
                        product.getName(),
                        product.getDescription(),
                        productCategoryRepository.getById(product.getCategoryId()),
                        productInventoryRepository.getById(product.getInventoryId()),
                        product.getPrice(),
                        new Timestamp(System.currentTimeMillis()),
                        new Timestamp(System.currentTimeMillis())))
                .collect(Collectors.toList());
    }

    //method to fetch ProductModel from Product
    public static ProductModel getproductModel(Product product){

        log.info("Fetching ProductModel from Product");
        ProductModel productModel = ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .categoryId(product.getProductCategory().getId())
                .inventoryId(product.getProductInventory().getId())
                .price(product.getPrice())
                .createdAt(product.getCreated_at().getTime())
                .modifiedAt(product.getModified_at().getTime())
                .build();
        return productModel;
    }

    //method to fetch List of ProductModel from List of Product
    public static List<ProductModel> getproductModelList(List<Product> products){

        log.info("Fetching List of ProductModel from List of Product");
        return products.stream().map(
                product -> new ProductModel(product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getProductCategory().getId(),
                        product.getProductInventory().getId(),
                        product.getPrice(),
                        product.getCreated_at().getTime(),
                        product.getModified_at().getTime()))
                .collect(Collectors.toList());
    }

    //method to fetch List of Deal from List of DealModel
    public static List<Deal> getDealFromDealModelList(List<DealModel> dealModelList){


        log.info("Fetching List of Deal from List of DealModel");
        return dealModelList.stream().map(dealModel -> new Deal(
                productRepository.findById(dealModel.getProduct_id()).get(),
                dealModel.getName(),
                dealModel.getDescription(),
                dealModel.getDiscount(),
                new Timestamp(dealModel.getStartTime()),
                new Timestamp(dealModel.getEndTime())))
                .collect(Collectors.toList());
    }

    //method to fetch List of DealModel from List of Deal
    public static List<DealModel> getDealModelFromDeal(List<Deal> deals){

        log.info("Fetching List of DealModel from List of Deal");
        return deals.stream().map(deal -> new DealModel(deal.getId(),
                deal.getProduct().getId(),
                deal.getName(),
                deal.getDescription(),
                deal.getDiscount(),
                deal.getStartTime().getTime(),
                deal.getEndTime().getTime()))
                .collect(Collectors.toList());
    }

    //method to fetch List of DealModel from List of ExpiredDeal
    public static List<DealModel> getDealModelFromExpiredDeals(List<ExpiredDeals> expiredDeals){

        log.info("Fetching List of DealModel from List of ExpiredDeal");
        return expiredDeals.stream().map(deal -> new DealModel(deal.getId(),
                deal.getProduct().getId(),
                deal.getName(),
                deal.getDescription(),
                deal.getDiscount(),
                deal.getStartTime().getTime(),
                deal.getEndTime().getTime()))
                .collect(Collectors.toList());
    }

    //method to fetch List of ExpiredDeal from List of Deal
    public static List<ExpiredDeals> getExpiredDealsFromDeals(List<Deal> deals){

        log.info("Fetching List of ExpiredDeal from List of Deal");
        return deals.stream().map(deal -> new ExpiredDeals(deal.getId(),
                deal.getProduct(),
                deal.getName(),
                deal.getDescription(),
                deal.getDiscount(),
                deal.getStartTime(),
                deal.getEndTime(),
                new Timestamp(System.currentTimeMillis())))
                .collect(Collectors.toList());
    }
}
