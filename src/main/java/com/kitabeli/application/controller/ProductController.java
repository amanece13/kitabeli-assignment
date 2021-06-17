package com.kitabeli.application.controller;

import com.kitabeli.application.entity.Product;
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
        return new ResponseEntity(productService.fetchAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductModel> fetchAProduct(@PathVariable("id") Long id){
        return new ResponseEntity(productService.findProductById(id),HttpStatus.OK);
    }

    /*@PostMapping("/products")
    public ResponseEntity addProducts(@RequestBody List<Product> productList){

    }*/

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody ProductModel productModel){
            productService.addProduct(productModel);
        return new ResponseEntity(HttpStatus.OK);
    }
}
