package com.kitabeli.application.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@Entity(name = "deals")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "start_time")
    @CreationTimestamp
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "deleted_at")
    private Timestamp deleted_at;

}
