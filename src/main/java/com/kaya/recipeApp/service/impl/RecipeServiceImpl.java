package com.kaya.recipeApp.service.impl;

import com.kaya.recipeApp.data.Recipe;
import com.kaya.recipeApp.domain.dto.RecipeModel;
import com.kaya.recipeApp.domain.error.ErrorCode;
import com.kaya.recipeApp.exception.ApiException;
import com.kaya.recipeApp.mapper.RecipeMapper;
import com.kaya.recipeApp.repository.RecipeRepository;
import com.kaya.recipeApp.service.spec.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableMongoRepositories(basePackages = "com.kaya.recipeApp.repository")
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    @Override
    @Transactional
    public void createRecipe(RecipeModel recipeModel) {
        final Recipe recipe = recipeMapper.toRecipe(recipeModel);
        recipeRepository.save(recipe);
    }

    @Override
    public RecipeModel updateRecipe(RecipeModel recipeModel) {
        Recipe recipeToUpdate = recipeRepository.findByTitle(recipeModel.getTitle()).orElseThrow(()->new ApiException(ErrorCode.RECIPE_NOT_FOUND));
        recipeMapper.updateRecipeFromRecipeModel(recipeModel, recipeToUpdate);

        final Recipe recipeSaved = recipeRepository.save(recipeToUpdate);
        return recipeMapper.toRecipeModel(recipeSaved);
    }

    @Override
    public void deleteRecipe(String title) {
       int deleteCount= recipeRepository.deleteByTitle(title);
       if(deleteCount==0){
           throw new ApiException(ErrorCode.RECIPE_NOT_FOUND);
       }
    }

    @Override
    public RecipeModel getRecipeByTitle(String title) {
        Recipe recipe = recipeRepository.findByTitle(title).orElseThrow(()->new ApiException(ErrorCode.RECIPE_NOT_FOUND));
        return recipeMapper.toRecipeModel(recipe);
    }

    @Override
    public List<RecipeModel> getRecipes() {
        return recipeRepository.findAll().stream().map(recipeMapper::toRecipeModel).collect(Collectors.toList());
    }
}
