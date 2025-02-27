package com.kmuniz.storeapi.store_api.domain.car_model_entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmuniz.storeapi.store_api.domain.car_maker_entity.CarMakerEntity;

import java.util.List;

public interface CarModelEntityRepository extends JpaRepository<CarModelEntity, Long> {
    List<CarModelEntity> findByCarMaker(CarMakerEntity carMaker);
}
