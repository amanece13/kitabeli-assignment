package com.kitabeli.application.impl;

import com.kitabeli.application.entity.Product;
import com.kitabeli.application.exception.InvalidInputException;
import com.kitabeli.application.exception.ProductNotFoundException;
import com.kitabeli.application.model.ProductModel;
import com.kitabeli.application.respository.ProductCategoryRepository;
import com.kitabeli.application.respository.ProductInventoryRepository;
import com.kitabeli.application.respository.ProductRepository;
import com.kitabeli.application.service.ProductService;
import com.kitabeli.application.util.InputValidator;
import com.kitabeli.application.util.ModelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductInventoryRepository productInventoryRepository;

    @Override
    public List<ProductModel> fetchAllProducts() {
        List<Product> productList = productRepository.findAll();
        log.info("Fetched all the products {}" ,productList);
        return ModelUtil.getproductModelList(productList);
    }

    @Override
    public ProductModel findProductById(Long id) {
        Product  product = null;
        try{
            product = productRepository.getById(id);
            log.info("Fetched product with id {}" ,id);
        }
        catch (Exception e){
            throw new ProductNotFoundException(System.currentTimeMillis(),
                    HttpStatus.BAD_REQUEST,
                    "Category id does not exist",
                    false);
        }
        return ModelUtil.getproductModel(product);
    }

    @Override
    public void addProducts(List<ProductModel> productList) {
        productRepository.saveAll(ModelUtil.getproductList(productList));
        log.info("Saved all the products received {}" ,productList);
    }

    @Override
    public void addProduct(ProductModel productModel) {

        String checkValidity = InputValidator.validate(productModel);
        if(!checkValidity.isEmpty()){
            throw new InvalidInputException(System.currentTimeMillis(),
                    HttpStatus.BAD_REQUEST,
                    checkValidity,
                    false);
        }
        Product  product = ModelUtil.getproduct(productModel);

        try{
            product.setProductCategory(productCategoryRepository.getById(productModel.getCategoryId()));
        }
        catch (Exception e){
            throw new InvalidInputException(System.currentTimeMillis(),
                    HttpStatus.BAD_REQUEST,
                    "Category id does not exist",
                    false);
        }
        try{
            product.setProductInventory(productInventoryRepository.getById(productModel.getInventoryId()));

        }catch (Exception e){
            throw new InvalidInputException(System.currentTimeMillis(),
                    HttpStatus.BAD_REQUEST,
                    "Inventory id does not exist",
                    false);
        }
        productRepository.save(product);
        log.info("Saved the product received {}", productModel);
    }

    @Override
    public void removeProduct(Long productId) {
        Product product = productRepository.getById(productId);
        productRepository.delete(product);
        log.info("Removed the product with id {}", productId);
    }
}
