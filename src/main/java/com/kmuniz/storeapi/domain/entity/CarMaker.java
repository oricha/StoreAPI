package com.kmuniz.storeapi.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CarModel")
@AllArgsConstructor
@NoArgsConstructor
public class CarMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;

    public CarMaker(String name) {
        this.name = name;
    }
}
