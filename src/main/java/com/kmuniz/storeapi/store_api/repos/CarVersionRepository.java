package com.kmuniz.storeapi.store_api.repos;

import com.kmuniz.storeapi.store_api.domain.CarMaker;
import com.kmuniz.storeapi.store_api.domain.CarModel;
import com.kmuniz.storeapi.store_api.domain.CarVersion;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarVersionRepository extends JpaRepository<CarVersion, Long> {

    CarVersion findFirstByCarMaker(CarMaker carMaker);

    CarVersion findFirstByCarModel(CarModel carModel);

}
