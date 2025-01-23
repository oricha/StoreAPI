package com.kmuniz.storeapi.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "CarModel")
@Getter
@Setter
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

    public CarModelEntity(CarMakerEntity carMakerEntity, String model) {
        this.carMaker = carMakerEntity;
        this.model = model;
    }
}
