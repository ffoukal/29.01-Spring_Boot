package com.core.Service;

import com.core.DTO.Request.FoodRequestDTO;
import com.core.DTO.Response.FoodResponseDTO;

public interface CaloriesService {
    FoodResponseDTO calculate(FoodRequestDTO food);
}
