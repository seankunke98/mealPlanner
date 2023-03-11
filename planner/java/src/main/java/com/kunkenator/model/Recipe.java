package com.kunkenator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {

    @JsonProperty("id")
    private int recipeId;
    private String title;
    @JsonProperty("sourceUrl")
    private String source;
    private double pricePerServing;
    private boolean dairyFree;
    private boolean vegan;
    private boolean glutenFree;
    private boolean vegetarian;
    private String instructions;
    private int readyInMinutes;
    private String image;
    private int servings;

    public Recipe(int recipeId, String title, String source, double pricePerServing, boolean dairyFree, boolean vegan, boolean glutenFree, boolean vegetarian, String instructions, int readyInMinutes, String image, int servings) {
        this.recipeId = recipeId;
        this.title = title;
        this.source = source;
        this.pricePerServing = pricePerServing;
        this.dairyFree = dairyFree;
        this.vegan = vegan;
        this.glutenFree = glutenFree;
        this.vegetarian = vegetarian;
        this.instructions = instructions;
        this.readyInMinutes = readyInMinutes;
        this.image = image;
        this.servings = servings;
    }

    public Recipe() {
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getPricePerServing() {
        return pricePerServing;
    }

    public void setPricePerServing(double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }

    public boolean isDairyFree() {
        return dairyFree;
    }

    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", pricePerServing=" + pricePerServing +
                ", dairyFree=" + dairyFree +
                ", vegan=" + vegan +
                ", glutenFree=" + glutenFree +
                ", vegetarian=" + vegetarian +
                ", instructions='" + instructions + '\'' +
                ", readyInMinutes=" + readyInMinutes +
                ", image='" + image + '\'' +
                ", servings=" + servings +
                '}';
    }
}
