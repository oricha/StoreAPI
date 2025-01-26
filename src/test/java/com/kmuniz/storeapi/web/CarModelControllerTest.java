package com.kmuniz.storeapi.web;


import com.kmuniz.storeapi.domain.entity.CarMakerEntity;
import com.kmuniz.storeapi.domain.entity.CarModelEntity;
import com.kmuniz.storeapi.domain.entity.CarVersionEntity;
import com.kmuniz.storeapi.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CarModelController.class)
public class CarModelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    public void testGetAllCarBrands() throws Exception {
        // Mock data
        List<CarMakerEntity> mockBrands = List.of(
                new CarMakerEntity() {{ setId(1L); setName("Toyota"); }},
                new CarMakerEntity() {{ setId(2L); setName("Honda"); }}
        );

        // Mock service behavior
        when(carService.getAllCarBrands()).thenReturn(mockBrands);

        // Perform GET request and verify response
        mockMvc.perform(get("/api/car/brands")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Toyota"))
                .andExpect(jsonPath("$[1].name").value("Honda"));
    }

    @Test
    public void testGetAllCarModels() throws Exception {
        // Mock data
        List<CarModelEntity> mockModels = List.of(
                new CarModelEntity() {{ setId(1L); setName("Camry"); }},
                new CarModelEntity() {{ setId(2L); setName("Civic"); }}
        );

        // Mock service behavior
        when(carService.getAllCarModels()).thenReturn(mockModels);

        // Perform GET request and verify response
        mockMvc.perform(get("/api/car/models")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Camry"))
                .andExpect(jsonPath("$[1].name").value("Civic"));
    }

    @Test
    public void testGetCarModelsByBrand() throws Exception {
        // Mock data
        List<CarModelEntity> mockModels = List.of(
                new CarModelEntity() {{ setId(1L); setName("Camry"); }},
                new CarModelEntity() {{ setId(2L); setName("Corolla"); }}
        );

        // Mock service behavior
        when(carService.getCarModelsByBrand("Toyota")).thenReturn(mockModels);

        // Perform GET request and verify response
        mockMvc.perform(get("/api/car/brands/Toyota/models")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Camry"))
                .andExpect(jsonPath("$[1].name").value("Corolla"));
    }

    @Test
    public void testGetCarVersionsByModel() throws Exception {
        // Mock data
        List<CarVersionEntity> mockVersions = List.of(
                new CarVersionEntity() {{ setId(1L); setName("Camry LE"); }},
                new CarVersionEntity() {{ setId(2L); setName("Camry SE"); }}
        );

        // Mock service behavior
        when(carService.getCarVersionByModel("Camry")).thenReturn(mockVersions);

        // Perform GET request and verify response
        mockMvc.perform(get("/api/car/models/Camry/versions")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Camry LE"))
                .andExpect(jsonPath("$[1].name").value("Camry SE"));
    }
}