package com.kmuniz.storeapi.domain.entity;

import com.kmuniz.storeapi.domain.entity.CarMaker;
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
public class CarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String model;

    private Integer carMaker;

}
