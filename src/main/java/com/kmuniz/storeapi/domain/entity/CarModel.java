package com.kmuniz.storeapi.domain.entity;

import com.kmuniz.storeapi.domain.entity.CarMaker;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "CarModel")
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String model;

    @ManyToOne
    @JoinColumn(name = "car_maker_id")
    private CarMaker carMaker;
}
