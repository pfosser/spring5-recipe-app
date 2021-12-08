package it.paofos.spring5recipeapp.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
	
	Category category;
	
	@BeforeEach
	void setUp() {
		category = new Category();
	}

	@Test
	void testGetId() {
		final Long idValue = 4L;

		category.setId(idValue);

		assertEquals(idValue, category.getId());
	}

	@Test
	void testGetDescription() {
	}

	@Test
	void testGetRecipes() {
	}

}
