package com.core.Service.Impl;

import com.core.DAO.CaloriesDAO;
import com.core.DTO.Request.FoodRequestDTO;
import com.core.DTO.Request.IngredientRequestDTO;
import com.core.DTO.Response.IngredientResponseDTO;
import com.core.DTO.Response.FoodResponseDTO;
import com.core.Service.CaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriesServicesImpl implements CaloriesService {

    private CaloriesDAO repository;

    @Autowired
    public CaloriesServicesImpl(CaloriesDAO repository) {
        this.repository = repository;
    }

    @Override
    public FoodResponseDTO calculate(FoodRequestDTO food) {
        List<IngredientResponseDTO> ingredients = new ArrayList<>();
        Double totalCalories = 0.0;

        for(IngredientRequestDTO ingredient : food.getIngredients()){
            Double calories = repository.getIngredientByName(ingredient.getName()).getCalories() * (ingredient.getWeight()/100);
            totalCalories += calories;
            IngredientResponseDTO ingrResp = new IngredientResponseDTO();
            ingrResp.setName(ingredient.getName());
            ingrResp.setCalories(calories);
            ingredients.add(ingrResp);
        }

        FoodResponseDTO response = new FoodResponseDTO();
        response.setIngredients(ingredients);
        response.setName(food.getName());
        response.setTotalCalories(totalCalories);
        response.setMoreCaloricIngredient(repository.getMoreCaloricIngredient(food.getIngredients()));

        return response;
    }
}
