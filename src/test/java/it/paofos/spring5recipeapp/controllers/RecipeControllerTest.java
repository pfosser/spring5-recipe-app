package it.paofos.spring5recipeapp.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import it.paofos.spring5recipeapp.commands.RecipeCommand;
import it.paofos.spring5recipeapp.domain.Recipe;
import it.paofos.spring5recipeapp.exceptions.NotFoundException;
import it.paofos.spring5recipeapp.services.RecipeService;

class RecipeControllerTest {

	@Mock
	RecipeService recipeService;

	RecipeController controller;

	MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		controller = new RecipeController(recipeService);

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	void testGetRecipeById() throws Exception {

		Recipe recipe = new Recipe();
		recipe.setId(1L);

		when(recipeService.findById(anyLong())).thenReturn(recipe);

		mockMvc.perform(get("/recipe/1/show"))//
				.andExpect(status().isOk())//
				.andExpect(view().name("recipe/show"))//
				.andExpect(model().attributeExists("recipe"));
	}

	@Test
	void getRecipeNotFound() throws Exception {

		when(recipeService.findById(anyLong())).thenThrow(NotFoundException.class);

		mockMvc.perform(get("/recipe/1/show"))//
				.andExpect(status().isNotFound())//
				.andExpect(view().name("404error"));
	}

	@Test
	public void testGetNewRecipeForm() throws Exception {

		mockMvc.perform(get("/recipe/new"))//
				.andExpect(status().isOk())//
				.andExpect(view().name("recipe/recipeForm"))//
				.andExpect(model().attributeExists("recipe"));
	}

	@Test
	public void testPostNewRecipeForm() throws Exception {
		RecipeCommand command = new RecipeCommand();
		command.setId(2L);

		when(recipeService.saveRecipeCommand(any())).thenReturn(command);

		mockMvc.perform(post("/recipe").contentType(MediaType.APPLICATION_FORM_URLENCODED))//
				.andExpect(status().is3xxRedirection())//
				.andExpect(view().name("redirect:/recipe/2/show"));
	}

	@Test
	public void testGetUpdateView() throws Exception {
		RecipeCommand command = new RecipeCommand();
		command.setId(2L);

		when(recipeService.findCommandById(anyLong())).thenReturn(command);

		mockMvc.perform(get("/recipe/1/update"))//
				.andExpect(status().isOk())//
				.andExpect(view().name("recipe/recipeForm")).andExpect(model().attributeExists("recipe"));
	}

	@Test
	public void testDeleteAction() throws Exception {
		mockMvc.perform(get("/recipe/1/delete"))//
				.andExpect(status().is3xxRedirection())//
				.andExpect(view().name("redirect:/"));

		verify(recipeService, times(1)).deleteById(anyLong());
	}
}
