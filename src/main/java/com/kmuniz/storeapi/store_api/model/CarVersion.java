package com.kmuniz.storeapi.store_api.model;

import jakarta.validation.constraints.Size;


public class CarVersion {

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String version;

    @Size(max = 255)
    private String carModel;

    @Size(max = 255)
    private String carMaker;

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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(final String carModel) {
        this.carModel = carModel;
    }

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(final String carMaker) {
        this.carMaker = carMaker;
    }

}
