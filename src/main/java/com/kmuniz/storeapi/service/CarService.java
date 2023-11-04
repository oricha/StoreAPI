package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.entity.CarMaker;
import com.kmuniz.storeapi.domain.CarMakerRepository;
import com.kmuniz.storeapi.domain.entity.CarModel;
import com.kmuniz.storeapi.domain.CarModelRepository;
import com.kmuniz.storeapi.domain.entity.CarVersion;
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

    public List<CarMaker> getAllCarBrands() {
        return carMakerRepository.findAll();
    }

    public List<CarModel> getCarModelsByBrand(String carName) {
        CarMaker carMaker = carMakerRepository.findByName(carName);
        return (List<CarModel>) carModelRepository.findByCarMaker(carMaker);
    }

    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }

    public CarModel saveCarModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    public CarMaker saveCarMaker(CarMaker carMaker) {
        return carMakerRepository.save(carMaker);
    }

    public List<CarVersion> getCarVersionByModel(String model) {
        return null;
    }
}
