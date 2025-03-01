package com.kmuniz.storeapi.store_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;


@Entity
public class CarMaker {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "carMaker")
    private Set<CarModel> carMakerCarModels;

    @OneToMany(mappedBy = "carMaker")
    private Set<CarVersion> carMakerCarVersions;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<CarModel> getCarMakerCarModels() {
        return carMakerCarModels;
    }

    public void setCarMakerCarModels(final Set<CarModel> carMakerCarModels) {
        this.carMakerCarModels = carMakerCarModels;
    }

    public Set<CarVersion> getCarMakerCarVersions() {
        return carMakerCarVersions;
    }

    public void setCarMakerCarVersions(final Set<CarVersion> carMakerCarVersions) {
        this.carMakerCarVersions = carMakerCarVersions;
    }

}
