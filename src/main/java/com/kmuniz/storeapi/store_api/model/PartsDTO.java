package com.kmuniz.storeapi.store_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class PartsDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    private String description;

    private Double price;

    private Long categoryId;

    private Long brandId;

    @Size(max = 255)
    private String model;

    @Size(max = 255)
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public Long getCategory() {
        return categoryId;
    }

    public void setCategory(final Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(final Long brand) {
        this.brandId = brandId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(final String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
