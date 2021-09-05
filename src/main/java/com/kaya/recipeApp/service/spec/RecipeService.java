package com.kaya.recipeApp.service.spec;

import com.kaya.recipeApp.domain.dto.RecipeModel;

import java.util.List;

public interface RecipeService {
    void createRecipe(RecipeModel recipeModel);

    RecipeModel updateRecipe(RecipeModel recipeModel);

    void deleteRecipe(String title);

    RecipeModel getRecipeByTitle(String title);

    List<RecipeModel> getRecipes();
}