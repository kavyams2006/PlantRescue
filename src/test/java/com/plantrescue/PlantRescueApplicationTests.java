package com.plantrescue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PlantRescueApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHome() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("Running"));
    }

    @Test
    void testHealth() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("healthy"));
    }

    @Test
    void testPlantCare() throws Exception {
        mockMvc.perform(get("/plant-care"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.plant").value("Tomato"))
                .andExpect(jsonPath("$.disease").value("Early Blight"));
    }
}
