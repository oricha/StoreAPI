package com.kmuniz.storeapi.service;


import com.kmuniz.storeapi.domain.CarMakerRepository;
import com.kmuniz.storeapi.domain.CarModelRepository;
import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import com.kmuniz.storeapi.domain.entity.CarModelEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarMakerRepository carMakerRepository;

    @Mock
    private CarModelRepository carModelRepository;

    private final Integer carMakerIdToyota = 144;
    private final Integer carMakerIdHonda = 58;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllCarBrands() {
        // Create a list of car makers for testing
        List<CarMakerEntity> carMakerEntities = new ArrayList<>();
        carMakerEntities.add(new CarMakerEntity("Toyota"));
        carMakerEntities.add(new CarMakerEntity("Honda"));
        // Mock the behavior of carMakerRepository.findAll()
        Mockito.when(carMakerRepository.findAll()).thenReturn(carMakerEntities);

        List<CarMakerEntity> result = carService.getAllCarBrands();

        // Verify that the result matches the mocked data
        assertEquals(carMakerEntities, result);
    }


    @Test
    public void testGetCarModelsByBrand() {

        // Create a list of car models for testing
        List<CarModelEntity> carModelEntities = new ArrayList<>();
        carModelEntities.add(new CarModelEntity(new CarMakerEntity("Toyota"), "Camry"));
        carModelEntities.add(new CarModelEntity(new CarMakerEntity("Toyota"), "Corolla"));

        // Mock the behavior of carModelRepository.findByBrandName()
        Mockito.when(carModelRepository.findByCarMaker(new CarMakerEntity("Toyota"))).thenReturn(carModelEntities);

        List<CarModelEntity> result = carService.getCarModelsByBrand("Toyota");

        // Verify that the result matches the mocked data
        assertEquals(carModelEntities, result);
    }

//    @Test
//    public void testGetAllCarModels() {
//        // Create a list of car models for testing
//        List<CarModel> carModels = new ArrayList<>();
//        carModels.add(new CarModel(carMakerIdToyota, "Camry"));
//        carModels.add(new CarModel(carMakerIdHonda, "Civic"));
//
//        // Mock the behavior of carModelRepository.findAll()
//        Mockito.when(carModelRepository.findAll()).thenReturn(carModels);
//
//        List<CarModel> result = carService.getAllCarModels();
//
//        // Verify that the result matches the mocked data
//        assertEquals(carModels, result);
//    }

//    @Test
//    public void testSaveCarModel() {
//        // Create a car model for testing
//        CarModel carModel = new CarModel(carMakerIdToyota, "Camry");
//
//        // Mock the behavior of carModelRepository.save()
//        Mockito.when(carModelRepository.save(carModel)).thenReturn(carModel);
//
//        CarModel result = carService.saveCarModel(carModel);
//
//        // Verify that the result matches the input car model
//        assertEquals(carModel, result);
//    }

    @Test
    public void testSaveCarMaker() {
        // Create a car maker for testing
//        CarMakerEntity carMakerEntity = new CarMakerEntity("Toyota");
//
//        // Mock the behavior of carMakerRepository.save()
//        Mockito.when(carMakerRepository.save(carMakerEntity)).thenReturn(carMakerEntity);
//
//        CarMakerEntity result = carService.saveCarMaker(carMakerEntity);
//
//        // Verify that the result matches the input car maker
//        assertEquals(carMakerEntity, result);
    }
}
