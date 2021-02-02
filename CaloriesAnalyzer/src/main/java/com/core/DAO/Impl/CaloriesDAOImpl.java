package com.core.DAO.Impl;

import com.core.DAO.CaloriesDAO;
import com.core.DTO.Models.Ingredient;
import com.core.DTO.Request.IngredientRequestDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Comparator;
import java.util.List;

@Repository
public class CaloriesDAOImpl implements CaloriesDAO {

    @Override
    public Ingredient getIngredientByName(String name) {
        return readJSON().stream()
                .filter(ingredient -> ingredient.getName().compareTo(name) == 0)
                .findFirst()
                .get();
    }

    @Override
    public Ingredient getMoreCaloricIngredient(List<IngredientRequestDTO> ingredients){
        Comparator<Ingredient> c1 = (Ingredient i1, Ingredient i2) -> (int) (i1.getCalories() - i2.getCalories());
        Ingredient max =  ingredients.stream()
                .map(ingredient -> getIngredientByName(ingredient.getName()))
                .max(c1)
                .get();
        return max;
    }



    public static List<Ingredient> readJSON() {
        try{
            File file = ResourceUtils.getFile("classpath:static/food.json");
            ObjectMapper mapper = new ObjectMapper();
            List<Ingredient> ingredients = mapper.readValue(file, new TypeReference<List<Ingredient>>() {});
            return ingredients;
        } catch(Exception e){
            throw new RuntimeException("Error reading or processing the JSON file");
        }
    }
}
