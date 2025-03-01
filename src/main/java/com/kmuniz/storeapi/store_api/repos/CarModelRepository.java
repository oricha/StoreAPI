package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarModelRepository extends JpaRepository<CarModel, Long> {

    CarModel findFirstByCarMaker(CarMaker carMaker);

}
