package com.kaya.recipeApp.mapper;

import com.kaya.recipeApp.data.Recipe;
import com.kaya.recipeApp.domain.dto.RecipeModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    default RecipeModel toRecipeModel(Recipe recipe){
        RecipeModel recipeModel=new RecipeModel();
        recipeModel.setIngredients(recipe.getIngredients());
        recipeModel.setInstructions(recipe.getInstructions());
        recipeModel.setTitle(recipe.getTitle());
        recipeModel.setForPerson(recipe.getForPerson());
        recipeModel.setVegetarianType(recipe.getVegetarianType());
        recipeModel.setCreatedDate(recipe.getCreatedDate());
        return recipeModel;
    }

    default Recipe toRecipe(RecipeModel recipeModel){
        Recipe recipe=new Recipe();
        recipe.setIngredients(recipeModel.getIngredients());
        recipe.setInstructions(recipeModel.getInstructions());
        recipe.setTitle(recipeModel.getTitle());
        recipe.setForPerson(recipeModel.getForPerson());
        recipe.setVegetarianType(recipeModel.getVegetarianType());
        return recipe;
    }

    default void updateRecipeFromRecipeModel(RecipeModel recipeModel,  Recipe recipe){
        recipe.setIngredients(recipeModel.getIngredients());
        recipe.setTitle(recipeModel.getTitle());
        recipe.setInstructions(recipeModel.getInstructions());
        recipe.setForPerson(recipeModel.getForPerson());
        recipe.setVegetarianType(recipeModel.getVegetarianType());
    }
}
