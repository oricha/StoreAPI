package com.kmuniz.storeapi.domain.entity;

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
public class CarVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String version;

    @ManyToOne
    @JoinColumn(name = "car_maker_id")
    private CarMakerEntity carMakerEntity;

    @ManyToOne
    @JoinColumn(name = "car_model_id")
    private CarModelEntity carModelEntity;
}
