package com.kaya.recipeApp.service.impl;

import com.kaya.recipeApp.data.Recipe;
import com.kaya.recipeApp.domain.Ingredient;
import com.kaya.recipeApp.domain.dto.RecipeModel;
import com.kaya.recipeApp.domain.error.ErrorCode;
import com.kaya.recipeApp.enums.Unit;
import com.kaya.recipeApp.enums.VegetarianType;
import com.kaya.recipeApp.exception.ApiException;
import com.kaya.recipeApp.mapper.RecipeMapper;
import com.kaya.recipeApp.repository.RecipeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {
    @Mock
    private RecipeMapper recipeMapper;

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeServiceImpl recipeService;

    static Ingredient ingredient1;
    static Ingredient ingredient2;
    static Ingredient ingredient3;

    @BeforeAll
    static void init() {
        ingredient1 = Ingredient.builder()
                .name("Spaghetti")
                .amount(400)
                .unit(Unit.GRAM)
                .build();

        ingredient2 = Ingredient.builder()
                .name("Tomato")
                .amount(300)
                .unit(Unit.GRAM)
                .build();
        ingredient3 = Ingredient.builder()
                .name("Olive oil")
                .amount(100)
                .unit(Unit.GRAM)
                .build();
    }


    @Test
    void shouldCallMapperAndRepositoryMethodsInOrderInCreateOperation() {
        //        GIVEN
        Recipe recipe = new Recipe();
        recipe.setVegetarianType(VegetarianType.YES);
        recipe.setInstructions("This is an instruction");
        recipe.setForPerson(4);
        recipe.setIngredients(Set.of(ingredient1, ingredient2, ingredient3));
        recipe.setTitle("Spaghetti with Tomato Sauce");
        recipe.setCreatedDate(LocalDateTime.now());

        when(recipeMapper.toRecipe(any())).thenReturn(recipe);

        //        WHEN
        recipeService.createRecipe(new RecipeModel());


        //        THEN
        InOrder inorder = Mockito.inOrder(recipeMapper, recipeRepository);

        inorder.verify(recipeMapper, times(1)).toRecipe(any());
        inorder.verify(recipeRepository, times(1)).save(any());
    }

    @Test
    void shouldThrowExceptionIfRecipeNotFoundInUpdateOperation() {
        //        GIVEN
        when(recipeRepository.findByTitle(any())).thenReturn(Optional.empty());

        //        WHEN
        var actual = assertThrows(ApiException.class, () -> recipeService.updateRecipe(new RecipeModel()));

        //        THEN
        assertEquals(ErrorCode.RECIPE_NOT_FOUND, actual.getErrorCode());

    }

    @Test
    void shouldCallRepositoryAndMapperMethodsInOrderInUpdateOpertion() {
        //        GIVEN
        Recipe recipe = new Recipe();
        recipe.setVegetarianType(VegetarianType.NO);
        recipe.setInstructions("This is an instruction");
        recipe.setForPerson(4);
        recipe.setIngredients(Set.of(ingredient1, ingredient2, ingredient3));
        recipe.setTitle("Spaghetti with Tomato Sauce");
        recipe.setCreatedDate(LocalDateTime.now());

        when(recipeRepository.findByTitle(any())).thenReturn(Optional.of(recipe));
        when(recipeRepository.save(any())).thenReturn(recipe);
        when(recipeMapper.toRecipeModel(any())).thenReturn(new RecipeModel());

        //        WHEN
        var actual = recipeService.updateRecipe(new RecipeModel());

        //        THEN
        InOrder inorder = Mockito.inOrder(recipeMapper, recipeRepository);

        inorder.verify(recipeRepository, times(1)).findByTitle(any());
        inorder.verify(recipeMapper, times(1)).updateRecipeFromRecipeModel(any(), any());
        inorder.verify(recipeRepository, times(1)).save(any());
        inorder.verify(recipeMapper, times(1)).toRecipeModel(any());
    }

    @Test
    void shouldCallDeleteInDeleteOperation() {
        //        GIVEN
        when(recipeRepository.deleteByTitle(any())).thenReturn(1);

        //        WHEN
        recipeService.deleteRecipe(any());

        //        THEN
        verify(recipeRepository, times(1)).deleteByTitle(any());
    }

    @Test
    void shouldThrowExceptionIfNoItemsDeletedInDeleteOperation() {
        //        GIVEN

        when(recipeRepository.deleteByTitle(any())).thenReturn(0);

        //        WHEN
        var actual = assertThrows(ApiException.class, () -> recipeService.deleteRecipe(any()));

        //        THEN
        assertEquals(ErrorCode.RECIPE_NOT_FOUND, actual.getErrorCode());
    }

    @Test
    void shouldThrowExceptionIfNoItemsFoundInGetByATitle() {
        //        GIVEN

        when(recipeRepository.findByTitle(any())).thenReturn(Optional.empty());

        //        WHEN
        var actual = assertThrows(ApiException.class, () -> recipeService.getRecipeByTitle(any()));

        //        THEN
        assertEquals(ErrorCode.RECIPE_NOT_FOUND, actual.getErrorCode());
    }

    @Test
    void shouldCallRepositoryAndMapperMethodsInOrderInGetByTitle() {
        //        GIVEN
        Recipe recipe = new Recipe();
        recipe.setVegetarianType(VegetarianType.NO);
        recipe.setInstructions("This is an instruction");
        recipe.setForPerson(4);
        recipe.setIngredients(Set.of(ingredient1, ingredient2, ingredient3));
        recipe.setTitle("Spaghetti with Tomato Sauce");
        recipe.setCreatedDate(LocalDateTime.now());

        when(recipeRepository.findByTitle(any())).thenReturn(Optional.of(recipe));
        when(recipeMapper.toRecipeModel(any())).thenReturn(new RecipeModel());

        //        WHEN
        var actual = recipeService.getRecipeByTitle(any());

        //        THEN
        InOrder inorder = Mockito.inOrder(recipeMapper, recipeRepository);

        inorder.verify(recipeRepository, times(1)).findByTitle(any());
        inorder.verify(recipeMapper, times(1)).toRecipeModel(any());
    }

    @Test
    void shouldCallRepositoryAndMapperMethodsInOrderInGetAllRecipes() {
        //        GIVEN
        Recipe recipe1 = new Recipe();
        recipe1.setVegetarianType(VegetarianType.NO);
        recipe1.setInstructions("This is an instruction");
        recipe1.setForPerson(4);
        recipe1.setIngredients(Set.of(ingredient1, ingredient2, ingredient3));
        recipe1.setTitle("Spaghetti with Tomato Sauce");
        recipe1.setCreatedDate(LocalDateTime.now());

        Recipe recipe2 = new Recipe();
        recipe2.setVegetarianType(VegetarianType.NO);
        recipe2.setInstructions("This is an instruction");
        recipe2.setForPerson(4);
        recipe2.setIngredients(Set.of(ingredient1));
        recipe2.setTitle("Plain spaghetti");
        recipe2.setCreatedDate(LocalDateTime.now());

        when(recipeRepository.findAll()).thenReturn(List.of(recipe1,recipe2));
        when(recipeMapper.toRecipeModel(any())).thenReturn(new RecipeModel());

        //        WHEN
        var actual = recipeService.getRecipes();

        //        THEN
        InOrder inorder = Mockito.inOrder(recipeMapper, recipeRepository);

        inorder.verify(recipeRepository, times(1)).findAll();
        inorder.verify(recipeMapper, times(2)).toRecipeModel(any());
    }
}