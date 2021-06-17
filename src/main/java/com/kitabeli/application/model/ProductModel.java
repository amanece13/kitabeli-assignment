package com.kitabeli.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "description",
        "category_id",
        "inventory_id",
        "price",
        "created_at",
        "modified_at",
        "deleted_at"
})
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductModel {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("inventory_id")
    private Long inventoryId;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("modified_at")
    private Long modifiedAt;
}
