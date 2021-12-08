package it.paofos.spring5recipeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
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
