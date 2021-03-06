package it.paofos.spring5recipeapp.services;

import java.util.Set;

import it.paofos.spring5recipeapp.commands.RecipeCommand;
import it.paofos.spring5recipeapp.domain.Recipe;

public interface RecipeService {

	Set<Recipe> getRecipes();

	Recipe findById(Long id);

	RecipeCommand findCommandById(Long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);
	
	void deleteById(Long idToDelete);
}
