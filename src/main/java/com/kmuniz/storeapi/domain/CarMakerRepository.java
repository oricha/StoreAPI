package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarMakerRepository extends JpaRepository<CarMakerEntity, Integer> {

    Optional<CarMakerEntity>  findByName(String name);

    List<CarMakerEntity> findAll();

    Optional<CarMakerEntity> findByNameIgnoreCase(String name);
}
