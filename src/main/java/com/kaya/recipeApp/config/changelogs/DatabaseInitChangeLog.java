package com.kaya.recipeApp.config.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.kaya.recipeApp.data.Recipe;
import com.kaya.recipeApp.domain.Ingredient;
import com.kaya.recipeApp.enums.Unit;
import com.kaya.recipeApp.enums.VegetarianType;
import com.kaya.recipeApp.repository.RecipeRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@ChangeLog(order = "001")
public class DatabaseInitChangeLog {

    @ChangeSet(order = "001", id = "init recipes", author = "kayaondul")
    public void initRecipes(RecipeRepository recipeRepository) {
        Ingredient ingredient1 = Ingredient.builder()
                .name("Spaghetti")
                .amount(400)
                .unit(Unit.GRAM)
                .build();

        Ingredient ingredient2 = Ingredient.builder()
                .name("Tomato")
                .amount(300)
                .unit(Unit.GRAM)
                .build();
        Ingredient ingredient3 = Ingredient.builder()
                .name("Olive oil")
                .amount(100)
                .unit(Unit.GRAM)
                .build();

        Recipe recipe = new Recipe();
        recipe.setVegetarianType(VegetarianType.YES);
        recipe.setInstructions("This is an instruction");
        recipe.setForPerson(4);
        recipe.setIngredients(Set.of(ingredient1, ingredient2, ingredient3));
        recipe.setTitle("Spaghetti with Tomato Sauce");
        recipe.setCreatedDate(LocalDateTime.now());


        Ingredient ingredient4 = Ingredient.builder()
                .name("Chicken Wings")
                .amount(1000)
                .unit(Unit.GRAM)
                .build();

        Ingredient ingredient5 = Ingredient.builder()
                .name("Hot Sauce")
                .amount(50)
                .unit(Unit.GRAM)
                .build();
        Ingredient ingredient6 = Ingredient.builder()
                .name("Vegetable oil")
                .amount(700)
                .unit(Unit.MILLILITER)
                .build();

        Recipe recipe2 = new Recipe();
        recipe2.setVegetarianType(VegetarianType.NO);
        recipe2.setInstructions("This is an instruction");
        recipe2.setForPerson(4);
        recipe2.setIngredients(Set.of(ingredient4, ingredient5, ingredient6));
        recipe2.setTitle("Hot Chicken Wings");
        recipe2.setCreatedDate(LocalDateTime.now());

        recipeRepository.saveAll(List.of(recipe, recipe2));
    }


}
