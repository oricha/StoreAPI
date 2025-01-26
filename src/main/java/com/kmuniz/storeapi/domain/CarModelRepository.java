package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import com.kmuniz.storeapi.domain.entity.CarModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModelEntity, Integer> {

    List<CarModelEntity> findByModel(String model);

    List<CarModelEntity> findByCarMaker(CarMakerEntity carMaker);

}
