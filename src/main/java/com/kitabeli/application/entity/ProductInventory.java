package com.kitabeli.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Entity(name = "product_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @OneToOne(mappedBy = "productInventory")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp created_at;

    @Column(name = "modified_at")
    @UpdateTimestamp
    private Timestamp modified_at;

    @Column(name = "deleted_at")
    private Timestamp deleted_at;
}

