package com.core.DTO.Response;

import com.core.DTO.Models.Ingredient;

import java.util.List;

public class FoodResponseDTO {
    private String name;
    private Double totalCalories;
    private List<IngredientResponseDTO> ingredients;
    private Ingredient moreCaloricIngredient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Double totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<IngredientResponseDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientResponseDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getMoreCaloricIngredient() {
        return moreCaloricIngredient;
    }

    public void setMoreCaloricIngredient(Ingredient moreCaloricIngredient) {
        this.moreCaloricIngredient = moreCaloricIngredient;
    }
}
