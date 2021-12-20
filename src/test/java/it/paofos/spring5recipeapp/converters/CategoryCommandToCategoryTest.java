package it.paofos.spring5recipeapp.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.paofos.spring5recipeapp.commands.CategoryCommand;
import it.paofos.spring5recipeapp.domain.Category;

public class CategoryCommandToCategoryTest {

	public static final Long ID_VALUE = 1L;
	public static final String DESCRIPTION = "description";
	CategoryCommandToCategory conveter;

	@BeforeEach
	public void setUp() throws Exception {
		conveter = new CategoryCommandToCategory();
	}

	@Test
	public void testNullObject() throws Exception {
		assertNull(conveter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(conveter.convert(new CategoryCommand()));
	}

	@Test
	public void convert() throws Exception {
		// given
		CategoryCommand categoryCommand = new CategoryCommand();
		categoryCommand.setId(ID_VALUE);
		categoryCommand.setDescription(DESCRIPTION);

		// when
		Category category = conveter.convert(categoryCommand);

		// then
		assertEquals(ID_VALUE, category.getId());
		assertEquals(DESCRIPTION, category.getDescription());
	}

}