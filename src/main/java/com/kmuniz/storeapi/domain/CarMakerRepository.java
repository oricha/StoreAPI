package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarMakerEntity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface CarMakerRepository extends JpaRepository<CarMakerEntity, Integer> {

    Optional<CarMakerEntity> findByName(String name);

    @Override
    @NonNull
    List<CarMakerEntity> findAll();

    Optional<CarMakerEntity> findByNameIgnoreCase(String name);
}
