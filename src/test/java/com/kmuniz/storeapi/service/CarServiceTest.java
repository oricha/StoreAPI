package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.CarMakerRepository;
import com.kmuniz.storeapi.domain.CarModelRepository;
import com.kmuniz.storeapi.domain.entity.CarMaker;
import com.kmuniz.storeapi.domain.entity.CarModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

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
        List<CarMaker> carMakers = new ArrayList<>();
        carMakers.add(new CarMaker("Toyota"));
        carMakers.add(new CarMaker("Honda"));

        // Mock the behavior of carMakerRepository.findAll()
        Mockito.when(carMakerRepository.findAll()).thenReturn(carMakers);

        List<CarMaker> result = carService.getAllCarBrands();

        // Verify that the result matches the mocked data
        assertEquals(carMakers, result);
    }

    @Test
    public void testGetCarModelsByBrand() {

        // Create a list of car models for testing
        List<CarModel> carModels = new ArrayList<>();
        carModels.add(new CarModel(carMakerIdToyota, "Camry"));
        carModels.add(new CarModel(carMakerIdHonda, "Toyota"));

        // Mock the behavior of carModelRepository.findByBrandName()
        Mockito.when(carModelRepository.findByCarMakerId(carMakerIdToyota)).thenReturn(carModels);

        List<CarModel> result = carService.getCarModelsByBrand(carMakerIdToyota);

        // Verify that the result matches the mocked data
        assertEquals(carModels, result);
    }

    @Test
    public void testGetAllCarModels() {
        // Create a list of car models for testing
        List<CarModel> carModels = new ArrayList<>();
        carModels.add(new CarModel(carMakerIdToyota, "Camry"));
        carModels.add(new CarModel(carMakerIdHonda, "Civic"));

        // Mock the behavior of carModelRepository.findAll()
        Mockito.when(carModelRepository.findAll()).thenReturn(carModels);

        List<CarModel> result = carService.getAllCarModels();

        // Verify that the result matches the mocked data
        assertEquals(carModels, result);
    }

    @Test
    public void testSaveCarModel() {
        // Create a car model for testing
        CarModel carModel = new CarModel(carMakerIdToyota, "Camry");

        // Mock the behavior of carModelRepository.save()
        Mockito.when(carModelRepository.save(carModel)).thenReturn(carModel);

        CarModel result = carService.saveCarModel(carModel);

        // Verify that the result matches the input car model
        assertEquals(carModel, result);
    }

    @Test
    public void testSaveCarMaker() {
        // Create a car maker for testing
        CarMaker carMaker = new CarMaker("Toyota");

        // Mock the behavior of carMakerRepository.save()
        Mockito.when(carMakerRepository.save(carMaker)).thenReturn(carMaker);

        CarMaker result = carService.saveCarMaker(carMaker);

        // Verify that the result matches the input car maker
        assertEquals(carMaker, result);
    }
}
