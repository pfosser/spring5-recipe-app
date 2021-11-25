package it.paofos.spring5recipeapp.services;

import java.util.Set;

import it.paofos.spring5recipeapp.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();
}
