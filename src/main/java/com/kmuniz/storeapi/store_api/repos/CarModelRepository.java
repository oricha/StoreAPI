package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findFirstByCarMaker(CarMaker carMaker);

    List<CarModel> findByCarMakerId(Long carMakerId);

    Optional<CarModel> findByNameContainingIgnoreCase(String name);

    Optional<CarModel> findByName(String name);

}
