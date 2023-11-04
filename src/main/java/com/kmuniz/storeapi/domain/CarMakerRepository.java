package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarMakerRepository extends JpaRepository<CarMakerEntity, Integer> {

    CarMakerEntity findByName(String name);
}
