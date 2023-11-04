package com.kmuniz.storeapi.domain;

import com.kmuniz.storeapi.domain.entity.CarMaker;
import com.kmuniz.storeapi.domain.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

    List<CarModel> findByModel(String model);

    List<CarModel> findByCarMaker(CarMaker carMaker);
}
