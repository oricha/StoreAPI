package com.kmuniz.storeapi.store_api.model;

import jakarta.validation.constraints.Size;


public class Part1 {

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String description;

    private Double price;

    @Size(max = 255)
    private String category;

    @Size(max = 255)
    private String brand;

    @Size(max = 255)
    private String model;

    @Size(max = 255)
    private String imageUrl;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(final String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
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
