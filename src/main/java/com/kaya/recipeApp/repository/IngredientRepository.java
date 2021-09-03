package com.kaya.recipeApp.repository;

import com.kaya.recipeApp.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
}
