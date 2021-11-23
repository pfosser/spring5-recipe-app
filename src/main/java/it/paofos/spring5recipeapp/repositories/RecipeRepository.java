package it.paofos.spring5recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import it.paofos.spring5recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
