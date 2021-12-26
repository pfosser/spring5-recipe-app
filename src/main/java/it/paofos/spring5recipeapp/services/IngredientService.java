package it.paofos.spring5recipeapp.services;

import it.paofos.spring5recipeapp.commands.IngredientCommand;

public interface IngredientService {

	IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}
