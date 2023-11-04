package com.kmuniz.storeapi.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CarModel")
@AllArgsConstructor
@NoArgsConstructor
public class CarModelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String model;
    @ManyToOne
    @JoinColumn(name = "car_maker_id")
    private CarMakerEntity carMaker;

    public CarModelEntity(String model, CarMakerEntity carMaker) {
        this.model = model;
        this.carMaker = carMaker;
    }
}
