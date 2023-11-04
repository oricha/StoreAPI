package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import com.kmuniz.storeapi.domain.CarMakerRepository;
import com.kmuniz.storeapi.domain.entity.CarModelEntity;
import com.kmuniz.storeapi.domain.CarModelRepository;
import com.kmuniz.storeapi.domain.entity.CarVersionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarMakerRepository carMakerRepository;
    private final CarModelRepository carModelRepository;

    public CarService(CarMakerRepository carMakerRepository, CarModelRepository carModelRepository) {
        this.carMakerRepository = carMakerRepository;
        this.carModelRepository = carModelRepository;
    }

    public List<CarMakerEntity> getAllCarBrands() {
        return carMakerRepository.findAll();
    }

    public List<CarModelEntity> getCarModelsByBrand(String carName) {
        CarMakerEntity carMakerEntity = carMakerRepository.findByName(carName);
        return (List<CarModelEntity>) carModelRepository.findByCarMaker(carMakerEntity);
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
