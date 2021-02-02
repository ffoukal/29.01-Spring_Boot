package com.core.DAO;

import com.core.DTO.Models.Ingredient;
import com.core.DTO.Request.IngredientRequestDTO;

import java.util.List;

public interface CaloriesDAO {
    Ingredient getIngredientByName(String name);
    Ingredient getMoreCaloricIngredient(List<IngredientRequestDTO> ingredients);
}
