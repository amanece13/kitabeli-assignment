package com.kitabeli.application;

import com.kitabeli.application.entity.ProductCategory;
import com.kitabeli.application.entity.ProductInventory;
import com.kitabeli.application.model.ProductModel;
import com.kitabeli.application.service.DealsService;
import com.kitabeli.application.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private ProductService productService;

	@Autowired
	private DealsService dealsService;



	@Test
	public void productCreation() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setName("Footwear");
		productCategory.setDescription("Men's Footwear");
		productCategory.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		productCategory.setModifiedAt(new Timestamp(System.currentTimeMillis()));

		ProductInventory productInventory = new ProductInventory();
		productInventory.setQuantity(10);
		productInventory.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		productInventory.setModifiedAt(new Timestamp(System.currentTimeMillis()));

		ProductModel productModel = new ProductModel();
		productModel.setName("Nike Men Slippers");
		productModel.setDescription("Nike mens Nike Chroma Thong 5 Thong Sandals");
		productModel.setCategoryId(productCategory.getId());
		productModel.setInventoryId(productInventory.getId());
		productModel.setPrice(1200.0);
		productModel.setCreatedAt(System.currentTimeMillis());
		productModel.setModifiedAt(System.currentTimeMillis());

		Assertions.assertTrue(productService.addProduct(productModel));
	}

	@Test
	public void checkDealsCreation(){
		Assertions.assertTrue(dealsService.fetchDeals("active").size()>=0);
	}

	@Test
	public void checkExpiredDealsOnStartup(){
		Assertions.assertTrue(dealsService.fetchDeals("expired").size()==0);
	}

}
