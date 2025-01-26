package com.kmuniz.storeapi.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car_version")
public class CarVersionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name; // New name field added

    @NotNull
    private String version;

    @ManyToOne
    @JoinColumn(name = "car_maker_id", nullable = false)
    private CarMakerEntity carMakerEntity;

    @ManyToOne
    @JoinColumn(name = "car_model_id", nullable = false)
    private CarModelEntity carModelEntity;
}
