package com.kitabeli.application.service;

import com.kitabeli.application.entity.Product;
import com.kitabeli.application.model.ProductModel;

import java.util.List;

public interface ProductService {

    public List<ProductModel> fetchAllProducts();

    public ProductModel findProductById(Long id);

    public void addProducts(List<ProductModel> productList);

    public boolean addProduct(ProductModel product);

    public void removeProduct(Long productId);
}
