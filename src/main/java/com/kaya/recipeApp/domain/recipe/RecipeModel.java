package com.kaya.recipeApp.domain.recipe;

import com.kaya.recipeApp.domain.items.ItemModel;
import lombok.Data;

import java.util.Set;

@Data
public class RecipeModel {
    private Set<ItemModel> items;
    private String title;
    private String id;
    private String instructions;
}
