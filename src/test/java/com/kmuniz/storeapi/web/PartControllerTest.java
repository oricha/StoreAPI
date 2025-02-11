package com.kmuniz.storeapi.web;

import com.kmuniz.storeapi.domain.entity.Part;
import com.kmuniz.storeapi.service.PartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@WebMvcTest(PartController.class)
public class PartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PartService partService;

    @Test
    public void testSearchPartsByName() throws Exception {
        // Mock data
        List<Part> mockParts = List.of(
                new Part() {{
                    setId(1L);
                    setName("Brake Pad");
                    setDescription("High-quality brake pad.");
                    setPrice(49.99);
                    setCategory("Brakes");
                    setBrand("Toyota");
                    setModel("Corolla");
                    setImageUrl("https://example.com/brake-pad.jpg");
                }},
                new Part() {{
                    setId(2L);
                    setName("Oil Filter");
                    setDescription("Premium oil filter.");
                    setPrice(19.99);
                    setCategory("Filters");
                    setBrand("Honda");
                    setModel("Civic");
                    setImageUrl("https://example.com/oil-filter.jpg");
                }}
        );

        // Mock service behavior
        when(partService.searchPartsByName("Brake")).thenReturn(mockParts);

        // Perform GET request and verify response
        mockMvc.perform(get("/api/parts/search-by-name")
                        .param("name", "Brake")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Brake Pad"))
                .andExpect(jsonPath("$[1].name").value("Oil Filter"));
    }
}