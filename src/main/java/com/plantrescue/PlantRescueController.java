package com.plantrescue;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantRescueController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of("status", "Running");
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "healthy");
    }

    @GetMapping("/plant-care")
    public Map<String, String> plantCare() {
        return Map.of(
            "plant", "Tomato",
            "disease", "Early Blight",
            "recommendation", "Remove affected leaves and avoid overhead watering"
        );
    }
}
