package com.kitabeli.application.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Entity(name = "deals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deal {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ToString.Exclude
    private Product product;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    public Deal(Product product, String name, String description, Integer discount, Timestamp startTime, Timestamp
            endTime) {
        this.product = product;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
