package com.kmuniz.storeapi.store_api.model;

import jakarta.validation.constraints.Size;


public class CarModel {

    @Size(max = 255)
    private String name;

    @Size(max = 255)
    private String carMaker;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(final String carMaker) {
        this.carMaker = carMaker;
    }

}
