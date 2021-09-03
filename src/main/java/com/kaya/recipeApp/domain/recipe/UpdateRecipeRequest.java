package com.kaya.recipeApp.domain.recipe;

import com.kaya.recipeApp.domain.items.ItemModel;
import lombok.Data;

import java.util.Set;

@Data
public class UpdateRecipeRequest extends RecipeRequest{
    private Long id;
}
