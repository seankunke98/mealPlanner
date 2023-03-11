package com.kunkenator.services;

import com.kunkenator.model.Recipe;
import com.kunkenator.model.RecipeGeneral;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RecipeService {
    private final String API_BASE_URL = "https://api.spoonacular.com/recipes/random?apiKey=c598fe2ac809453ea84199be1e461b72&number=100";
    private final RestTemplate restTemplate = new RestTemplate();

    public List<Recipe> getRandomRecipes() {
        Recipe[] recipes;
        RecipeGeneral recipeGeneral = restTemplate.getForObject(API_BASE_URL, RecipeGeneral.class);
        assert recipeGeneral != null;
        System.out.println(recipeGeneral);
        recipes = recipeGeneral.getRecipes();
        return Arrays.asList(recipes);
    }

    public Recipe getRecipeById(int id) {
        Recipe recipe = restTemplate.getForObject("https://api.spoonacular.com/recipes/" + id + "/information?apiKey=c598fe2ac809453ea84199be1e461b72", Recipe.class);
        assert recipe != null;
        return recipe;
    }
}
