package com.kitabeli.application.impl;

import com.kitabeli.application.entity.Product;
import com.kitabeli.application.exception.InvalidInputException;
import com.kitabeli.application.model.ProductModel;
import com.kitabeli.application.respository.ProductCategoryRepository;
import com.kitabeli.application.respository.ProductInventoryRepository;
import com.kitabeli.application.respository.ProductRepository;
import com.kitabeli.application.service.ProductService;
import com.kitabeli.application.util.InputValidator;
import com.kitabeli.application.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.util.List;

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
        return ModelUtil.getproductModelList(productList);
    }

    @Override
    public ProductModel findProductById(Long id) {
        Product  product = productRepository.getById(id);
        return ModelUtil.getproductModel(product);
    }

    @Override
    public void addProducts(List<ProductModel> productList) {

    }

    @Override
    public void addProduct(ProductModel productModel) {

        String checkValidity = InputValidator.validate(productModel);
        if(!checkValidity.isEmpty()){
            throw new InvalidInputException(System.currentTimeMillis(),
                    HttpStatus.BAD_REQUEST,
                    "Please check your input again.",
                    checkValidity,
                    false);
        }
        Product  product = ModelUtil.getproduct(productModel);
        product.setProductCategory(productCategoryRepository.getById(productModel.getCategoryId()));
        product.setProductInventory(productInventoryRepository.getById(productModel.getId()));
        productRepository.save(product);
    }

    @Override
    public void removeProduct(Long productId) {
        Product product = productRepository.getById(productId);
        productRepository.delete(product);
    }
}
