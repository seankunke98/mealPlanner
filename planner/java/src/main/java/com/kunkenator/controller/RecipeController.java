package com.kunkenator.controller;

import com.kunkenator.model.Recipe;
import com.kunkenator.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/random")
    public List<Recipe> getRandomRecipes() {
        return recipeService.getRandomRecipes();
    }

    @GetMapping("/{id}/details")
    public Recipe getRecipeInfoById(@PathVariable("id") int recipeId) {
        return recipeService.getRecipeById(recipeId);
    }
}
