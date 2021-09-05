package com.kaya.recipeApp.controller;

import com.kaya.recipeApp.domain.dto.RecipeModel;
import com.kaya.recipeApp.service.spec.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recipe")
@RequiredArgsConstructor
@Tag(name = "recipe", description = "Recipe Operations")
public class RecipeController {
    private final RecipeService recipeService;

    @Operation(summary = "Create recipe", description = "Creates a recipe with given recipe model")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createRecipe(@RequestBody RecipeModel recipeModel) {
        recipeService.createRecipe(recipeModel);
    }

    @Operation(summary = "Update recipe", description = "Updates a recipe with given recipe model")
    @PutMapping
    public RecipeModel updateRecipe(@RequestBody RecipeModel recipeModel) {
        return recipeService.updateRecipe(recipeModel);
    }

    @Operation(summary = "Delete recipe", description = "Deletes a recipe with given title")
    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRecipe(@RequestParam String title) {
        recipeService.deleteRecipe(title);
    }

    @Operation(summary = "Get recipe by title", description = "Fetches a recipe with the given title")
    @GetMapping
    public RecipeModel getRecipeByTitle(
            @RequestParam String title) {
        return recipeService.getRecipeByTitle(title);
    }

    @Operation(summary = "Get all recipes", description = "Fetches all recipes")
    @GetMapping("all")
    public List<RecipeModel> getRecipes() {
        return recipeService.getRecipes();
    }


}
