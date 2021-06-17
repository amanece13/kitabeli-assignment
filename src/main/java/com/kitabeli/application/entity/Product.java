package com.kitabeli.application.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Entity(name = "product")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ToString.Exclude
    private ProductCategory productCategory;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    @ToString.Exclude
    private ProductInventory productInventory;

    @Column(name = "price")
    private Double price;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "modified_at")
    private Timestamp modified_at;

    public Product(String name, String description, ProductCategory productCategory, ProductInventory productInventory, Double price, Timestamp created_at, Timestamp modified_at) {
        this.name = name;
        this.description = description;
        this.productCategory = productCategory;
        this.productInventory = productInventory;
        this.price = price;
        this.created_at = created_at;
        this.modified_at = modified_at;
    }
}
