package com.kitabeli.application.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Entity(name = "product_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInventory {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "modified_at")
    private Timestamp modified_at;

}

