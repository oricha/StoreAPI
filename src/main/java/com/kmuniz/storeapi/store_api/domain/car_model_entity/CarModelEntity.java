package com.kmuniz.storeapi.store_api.domain.car_model_entity;

import com.kmuniz.storeapi.store_api.domain.car_maker_entity.CarMakerEntity;
import com.kmuniz.storeapi.store_api.domain.car_version_entity.CarVersionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "CarModelEntities")
@EntityListeners(AuditingEntityListener.class)
public class CarModelEntity {

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

    @Column
    private String name;

    @Column
    private String carMaker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_models_id")
    private CarMakerEntity carModels;

    @OneToMany(mappedBy = "carVersion")
    private Set<CarVersionEntity> carModel;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

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

    public String getCarMaker() {
        return carMaker;
    }

    public void setCarMaker(final String carMaker) {
        this.carMaker = carMaker;
    }

    public CarMakerEntity getCarModels() {
        return carModels;
    }

    public void setCarModels(final CarMakerEntity carModels) {
        this.carModels = carModels;
    }

    public Set<CarVersionEntity> getCarModel() {
        return carModel;
    }

    public void setCarModel(final Set<CarVersionEntity> carModel) {
        this.carModel = carModel;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
