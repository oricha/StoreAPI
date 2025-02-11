package com.kmuniz.storeapi.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "car_model")
public class CarModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "car_maker_id", nullable = false)
    private CarMakerEntity carMaker;

    public CarModelEntity(CarMakerEntity carMaker, String name) {
        this.carMaker = carMaker;
        this.name = name;
    }
}