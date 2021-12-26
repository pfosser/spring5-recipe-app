package it.paofos.spring5recipeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import it.paofos.spring5recipeapp.commands.IngredientCommand;
import it.paofos.spring5recipeapp.converters.IngredientToIngredientCommand;
import it.paofos.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import it.paofos.spring5recipeapp.domain.Ingredient;
import it.paofos.spring5recipeapp.domain.Recipe;
import it.paofos.spring5recipeapp.repositories.RecipeRepository;

class IngredientServiceImplTest {

	private final IngredientToIngredientCommand ingredientToIngredientCommand;

	@Mock
	RecipeRepository recipeRepository;

	IngredientService ingredientService;

	// init converters
	public IngredientServiceImplTest() {
		this.ingredientToIngredientCommand = new IngredientToIngredientCommand(
				new UnitOfMeasureToUnitOfMeasureCommand());
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		ingredientService = new IngredientServiceImpl(ingredientToIngredientCommand, recipeRepository);
	}

	@Test
	void testFindByRecipeIdAndIngredientIdHappyPath() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);

		Ingredient ingredient1 = new Ingredient();
		ingredient1.setId(1L);

		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(2L);

		Ingredient ingredient3 = new Ingredient();
		ingredient3.setId(3L);

		recipe.addIngredient(ingredient1);
		recipe.addIngredient(ingredient2);
		recipe.addIngredient(ingredient3);
		Optional<Recipe> recipeOptional = Optional.of(recipe);

		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

		// then
		IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

		// when
		assertEquals(Long.valueOf(3L), ingredientCommand.getId());
		assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
		verify(recipeRepository, times(1)).findById(anyLong());
	}

}
