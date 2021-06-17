package com.kitabeli.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DealModel {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("product_id")
    private Long product_id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("discount")
    private Integer discount;

    @JsonProperty("startTime")
    private Long startTime;

    @JsonProperty("endTime")
    private Long endTime;

    @JsonProperty("deletedAt")
    private Long deletedAt;

    public DealModel(Long id, Long product_id, String name, String description, Integer discount, Long startTime, Long endTime) {
        this.id = id;
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DealModel(Long product_id, String name, String description, Integer discount, Long startTime, Long endTime) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.discount = discount;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
