package com.kmuniz.storeapi.store_api.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CarVersionDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    @Size(max = 255)
    private String version;

    @NotNull
    private Long carMaker;

    @NotNull
    private Long carModel;

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

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public Long getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(final Long carMaker) {
        this.carMaker = carMaker;
    }

    public Long getCarModel() {
        return carModel;
    }

    public void setCarModel(final Long carModel) {
        this.carModel = carModel;
    }

}
