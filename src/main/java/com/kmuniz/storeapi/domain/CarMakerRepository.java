package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarMakerRepository extends JpaRepository<CarMakerEntity, Integer> {

    CarMakerEntity findByName(String name);

    List<CarMakerEntity> findAll();
}
