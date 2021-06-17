package com.kitabeli.application.util;

import com.kitabeli.application.entity.Product;
import com.kitabeli.application.model.ProductModel;

import java.util.List;
import java.util.stream.Collectors;

public class ModelUtil {

    public static Product getproduct(ProductModel productModel){
        Product product = Product.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .description(productModel.getDescription())
                .price(productModel.getPrice())
                .build();
        return product;
    }

    public static ProductModel getproductModel(Product product){
        ProductModel productModel = ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .categoryId(product.getProductCategory().getId())
                .inventoryId(product.getProductInventory().getId())
                .price(product.getPrice())
                .createdAt(product.getCreated_at().getTime())
                .modifiedAt(product.getModified_at().getTime())
                .deletedAt(product.getDeleted_at().getTime())
                .build();
        return productModel;
    }

    public static List<ProductModel> getproductModelList(List<Product> products){

        return products.stream().map(
                product -> new ProductModel(product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getProductCategory().getId(),
                        product.getProductInventory().getId(),
                        product.getPrice(),
                        product.getCreated_at().getTime(),
                        product.getModified_at().getTime(),
                        product.getDeleted_at().getTime()))
                .collect(Collectors.toList());
    }
}
