package com.kmuniz.storeapi.store_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CarMakerDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

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

}
