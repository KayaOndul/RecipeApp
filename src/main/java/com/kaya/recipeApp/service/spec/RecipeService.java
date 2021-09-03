package com.kaya.recipeApp.service.spec;

import com.kaya.recipeApp.domain.recipe.RecipeRequest;
import com.kaya.recipeApp.domain.recipe.RecipeModel;
import com.kaya.recipeApp.domain.recipe.UpdateRecipeRequest;

public interface RecipeService {
    void createRecipe(RecipeRequest recipeRequest);
    RecipeModel updateRecipe(UpdateRecipeRequest updateRecipeRequest);
    void deleteRecipe(String title);
}