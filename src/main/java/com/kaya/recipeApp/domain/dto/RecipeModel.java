package com.kaya.recipeApp.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.recipeApp.domain.Ingredient;
import com.kaya.recipeApp.enums.VegetarianType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class RecipeModel {
    private Set<Ingredient> ingredients;

    private String title;

    private String instructions;

    @JsonProperty("for_person")
    private Integer forPerson;

    @JsonProperty("vegetarian")
    private VegetarianType vegetarianType;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private LocalDateTime createdDate;
}
