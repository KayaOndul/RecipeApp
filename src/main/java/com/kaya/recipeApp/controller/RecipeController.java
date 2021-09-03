package com.kaya.recipeApp.controller;

import com.kaya.recipeApp.service.spec.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredient")
@RequiredArgsConstructor
public class RecipeController {
    private final RecipeService recipeService;
}
