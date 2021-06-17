package com.kitabeli.application.controller;

import com.kitabeli.application.model.ProductModel;
import com.kitabeli.application.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> fetchAllProducts(){
        log.info("Received a request to fetch all the products ");
        return new ResponseEntity(productService.fetchAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> fetchAProduct(@PathVariable("id") Long id){
        log.info("Received a request to fetch all product with id {} ", id);
        return new ResponseEntity(productService.findProductById(id),HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity addProducts(@RequestBody List<ProductModel> productList){
        log.info("Received a request to add multiple products");
        productService.addProducts(productList);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody ProductModel productModel){
        log.info("Received a request to add a single product");
        productService.addProduct(productModel);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
