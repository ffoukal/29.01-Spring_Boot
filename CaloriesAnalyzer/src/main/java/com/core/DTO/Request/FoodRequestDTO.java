package com.core.DTO.Request;

import java.util.List;

public class FoodRequestDTO {

    private String name;
    private List<IngredientRequestDTO> ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IngredientRequestDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientRequestDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
