package com.kmuniz.storeapi.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CarModel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarMakerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;

    public CarMakerEntity(String name) {
        this.name = name;
    }
}
