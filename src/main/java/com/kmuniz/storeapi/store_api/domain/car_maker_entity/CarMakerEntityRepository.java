package com.kmuniz.storeapi.store_api.domain.car_maker_entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarMakerEntityRepository extends JpaRepository<CarMakerEntity, Long> {
    Optional<CarMakerEntity> findByNameIgnoreCase(String brandName);
}
