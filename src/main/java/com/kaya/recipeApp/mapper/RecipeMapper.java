package com.kaya.recipeApp.mapper;

import com.kaya.recipeApp.domain.recipe.RecipeModel;
import com.kaya.recipeApp.entity.Recipe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeModel convertToRecipeModel(Recipe recipe);
}
