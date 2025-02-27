package com.kmuniz.storeapi.store_api.service;


import com.kmuniz.storeapi.store_api.domain.car_maker_entity.CarMakerEntity;
import com.kmuniz.storeapi.store_api.domain.car_maker_entity.CarMakerEntityRepository;
import com.kmuniz.storeapi.store_api.domain.car_model_entity.CarModelEntity;
import com.kmuniz.storeapi.store_api.domain.car_model_entity.CarModelEntityRepository;
import com.kmuniz.storeapi.store_api.domain.car_version_entity.CarVersionEntity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarMakerEntityRepository carMakerRepository;
    private final CarModelEntityRepository carModelRepository;

    public CarService(CarMakerEntityRepository carMakerRepository, CarModelEntityRepository carModelRepository) {
        this.carMakerRepository = carMakerRepository;
        this.carModelRepository = carModelRepository;
    }

    public List<CarMakerEntity> getAllCarBrands() {
        return carMakerRepository.findAll();
    }

    public List<CarModelEntity> getCarModelsByBrand(String brandName) {
        CarMakerEntity carMaker = carMakerRepository.findByNameIgnoreCase(brandName)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found: " + brandName));
        return carModelRepository.findByCarMaker(carMaker);
    }

    public List<CarModelEntity> getAllCarModels() {
        return carModelRepository.findAll();
    }

    public CarModelEntity saveCarModel(CarModelEntity carModelEntity) {
        return carModelRepository.save(carModelEntity);
    }

    public CarMakerEntity saveCarMaker(CarMakerEntity carMakerEntity) {
        return carMakerRepository.save(carMakerEntity);
    }

    public List<CarVersionEntity> getCarVersionByModel(String model) {
        return null;
    }
}