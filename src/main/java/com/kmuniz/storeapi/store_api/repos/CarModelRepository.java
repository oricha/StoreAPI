package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;

import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.util.List;


public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findFirstByCarMaker(CarMaker carMaker);

    List<CarModel> findByCarMakerId(Long carMakerId);

}
