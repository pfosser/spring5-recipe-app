package it.paofos.spring5recipeapp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import it.paofos.spring5recipeapp.domain.Recipe;
import it.paofos.spring5recipeapp.services.RecipeService;

class IndexControllerTest {
	
	IndexController indexController;
	
	@Mock
	Model model;

	@Mock
	RecipeService recipeService;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.openMocks(this);

		indexController = new IndexController(recipeService);
	}

	@Test
	void testGetIndexPage() {
		Recipe recipe = new Recipe();
		Set<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipesData);

		assertEquals("index", indexController.getIndexPage(model));
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(eq("recipes"), anySet());
	}

}
