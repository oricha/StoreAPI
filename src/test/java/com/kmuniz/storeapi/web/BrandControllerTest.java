package com.kmuniz.storeapi.web;

import com.kmuniz.storeapi.domain.entity.Brand;
import com.kmuniz.storeapi.service.BrandController;
import com.kmuniz.storeapi.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BrandController.class)
public class BrandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BrandService brandService;

    @Test
    public void testGetAllBrands() throws Exception {
        // Mock data
        List<Brand> mockBrands = Arrays.asList(
                new Brand() {{ setId(1L); setName("Hyundai"); }},
                new Brand() {{ setId(2L); setName("Toyota"); }},
                new Brand() {{ setId(3L); setName("Volkswagen"); }}
        );

        // Mock the service response
        when(brandService.getAllBrands()).thenReturn(mockBrands);

        // Perform the GET request and validate the response
        mockMvc.perform(get("/brands")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Hyundai"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Toyota"))
                .andExpect(jsonPath("$[2].id").value(3))
                .andExpect(jsonPath("$[2].name").value("Volkswagen"));
    }
}