package com.kmuniz.storeapi.store_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.util.Set;


@Entity
public class CarModel {

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_maker_id", nullable = false)
    private CarMaker carMaker;

    @OneToMany(mappedBy = "carModel")
    private Set<CarVersion> carModelCarVersions;

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

    public CarMaker getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(final CarMaker carMaker) {
        this.carMaker = carMaker;
    }

    public Set<CarVersion> getCarModelCarVersions() {
        return carModelCarVersions;
    }

    public void setCarModelCarVersions(final Set<CarVersion> carModelCarVersions) {
        this.carModelCarVersions = carModelCarVersions;
    }

}
