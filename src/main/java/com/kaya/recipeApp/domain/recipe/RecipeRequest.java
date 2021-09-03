package com.kaya.recipeApp.domain.recipe;

import com.kaya.recipeApp.domain.items.ItemModel;
import lombok.Data;

import java.util.Set;

@Data
public class RecipeRequest {
    Set<ItemModel> items;
    private String instructions;
    private String title;
}
