package it.paofos.spring5recipeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import it.paofos.spring5recipeapp.domain.Recipe;
import it.paofos.spring5recipeapp.repositories.RecipeRepository;

class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);

		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	void testGetRecipeById() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);
		
		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
		
		Recipe recipeReturned = recipeService.findById(1L);
		
		assertNotNull(recipeReturned, "Null recipe returned");
		verify(recipeRepository, times(1)).findById(anyLong());
		verify(recipeRepository, never()).findAll();
	}

	@Test
	void testGetRecipes() {
		Recipe recipe = new Recipe();
		Set<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);

		when(recipeRepository.findAll()).thenReturn(recipesData);

		Set<Recipe> recipes = recipeService.getRecipes();

		assertEquals(1, recipes.size());
		verify(recipeRepository, times(1)).findAll();
	}

}
