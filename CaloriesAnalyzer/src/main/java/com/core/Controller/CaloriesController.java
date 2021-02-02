package com.core.Controller;

import com.core.DTO.Request.FoodRequestDTO;
import com.core.DTO.Response.FoodResponseDTO;
import com.core.Service.CaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CaloriesController {

    private CaloriesService service;

    @Autowired
    public CaloriesController(CaloriesService service) {
        this.service = service;
    }

    @PostMapping("/api/food")
    public FoodResponseDTO getCaloriesCalculation(@RequestBody FoodRequestDTO food){
        return service.calculate(food);
    }

    @PostMapping("/api/foods")
    public List<FoodResponseDTO> getSeveralCaloriesCalculation(@RequestBody List<FoodRequestDTO> foods){
        List<FoodResponseDTO> response = new ArrayList<>();
        for (FoodRequestDTO f : foods){
            response.add(service.calculate(f));
        }
        return response;
    }
}
