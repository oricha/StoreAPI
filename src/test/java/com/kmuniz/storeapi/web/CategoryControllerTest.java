package com.kmuniz.storeapi.web;


import com.kmuniz.storeapi.domain.entity.Category;
import com.kmuniz.storeapi.service.CategoryService;
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

@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void testGetAllCategories() throws Exception {
        // Mock data
        List<Category> mockCategories = List.of(
                new Category() {{
                    setId(1L);
                    setName("Air conditioning-heating system/radiators");
                    setIcon("icon-air-conditioning");
                    setPartCount(797);
                }},
                new Category() {{
                    setId(2L);
                    setName("Brake system");
                    setIcon("icon-brake-system");
                    setPartCount(230);
                }}
        );

        // Mock service behavior
        when(categoryService.getAllCategories()).thenReturn(mockCategories);

        // Perform GET request and verify response
        mockMvc.perform(get("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Air conditioning-heating system/radiators"))
                .andExpect(jsonPath("$[0].partCount").value(797))
                .andExpect(jsonPath("$[1].name").value("Brake system"))
                .andExpect(jsonPath("$[1].partCount").value(230));
    }
}