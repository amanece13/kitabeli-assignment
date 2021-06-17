package com.kitabeli.application.respository;

import com.kitabeli.application.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM product p WHERE p.id NOT IN (SELECT e.product.id from expired_deals e) ")
    Collection<Product> findAllUnusedProductsUsingExpiredDeals();

    @Query("SELECT p FROM product p WHERE p.id NOT IN (SELECT e.product.id from deals e) ")
    Collection<Product> findAllUnusedProductsUsingActiveDeals();
}
