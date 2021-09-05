package com.kaya.recipeApp.repository;

import com.kaya.recipeApp.data.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    Optional<Recipe> findByTitle(String title);

    int deleteByTitle(String title);
}
