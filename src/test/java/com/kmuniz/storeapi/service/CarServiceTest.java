package com.kmuniz.storeapi.service;

import com.kmuniz.storeapi.domain.CarMakerRepository;
import com.kmuniz.storeapi.domain.CarModelRepository;
import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import com.kmuniz.storeapi.domain.entity.CarModelEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarMakerRepository carMakerRepository;

    @Mock
    private CarModelRepository carModelRepository;

    @Test
    public void testGetAllCarBrands() {
        // Mock data
        List<CarMakerEntity> carMakerEntities = new ArrayList<>();
        carMakerEntities.add(new CarMakerEntity("Toyota"));
        carMakerEntities.add(new CarMakerEntity("Honda"));

        // Mock repository behavior
        when(carMakerRepository.findAll()).thenReturn(carMakerEntities);

        // Call service method
        List<CarMakerEntity> result = carService.getAllCarBrands();

        // Verify results
        assertEquals(carMakerEntities, result);
        verify(carMakerRepository, times(1)).findAll();
    }

    @Test
    public void testGetCarModelsByBrand() {
        // Mock data
        CarMakerEntity carMaker = new CarMakerEntity("Toyota");
        List<CarModelEntity> carModelEntities = new ArrayList<>();
        carModelEntities.add(new CarModelEntity(carMaker, "Camry"));
        carModelEntities.add(new CarModelEntity(carMaker, "Corolla"));

        // Mock repository behavior
        when(carMakerRepository.findByName("Toyota")).thenReturn(Optional.ofNullable(carMaker));
        when(carModelRepository.findByCarMaker(carMaker)).thenReturn(carModelEntities);

        // Call service method
        List<CarModelEntity> result = carService.getCarModelsByBrand("Toyota");

        // Verify results
        assertEquals(carModelEntities, result);
        verify(carModelRepository, times(1)).findByCarMaker(carMaker);
    }

    @Test
    public void testGetAllCarModels() {
        // Mock data
        List<CarModelEntity> carModels = new ArrayList<>();
        carModels.add(new CarModelEntity(new CarMakerEntity("Toyota"), "Camry"));
        carModels.add(new CarModelEntity(new CarMakerEntity("Honda"), "Civic"));

        // Mock repository behavior
        when(carModelRepository.findAll()).thenReturn(carModels);

        // Call service method
        List<CarModelEntity> result = carService.getAllCarModels();

        // Verify results
        assertEquals(carModels, result);
        verify(carModelRepository, times(1)).findAll();
    }

    @Test
    public void testSaveCarModel() {
        // Mock data
        CarModelEntity carModel = new CarModelEntity(new CarMakerEntity("Toyota"), "Camry");

        // Mock repository behavior
        when(carModelRepository.save(carModel)).thenReturn(carModel);

        // Call service method
        CarModelEntity result = carService.saveCarModel(carModel);

        // Verify results
        assertEquals(carModel, result);
        verify(carModelRepository, times(1)).save(carModel);
    }

    @Test
    public void testSaveCarMaker() {
        // Mock data
        CarMakerEntity carMakerEntity = new CarMakerEntity("Toyota");

        // Mock repository behavior
        when(carMakerRepository.save(carMakerEntity)).thenReturn(carMakerEntity);

        // Call service method
        CarMakerEntity result = carService.saveCarMaker(carMakerEntity);

        // Verify results
        assertEquals(carMakerEntity, result);
        verify(carMakerRepository, times(1)).save(carMakerEntity);
    }
}