package com.core.DTO.Models;

public class Ingredient {
    private String name;
    private Double calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getCalories();
    }
}
