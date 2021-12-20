package it.paofos.spring5recipeapp.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import it.paofos.spring5recipeapp.commands.CategoryCommand;
import it.paofos.spring5recipeapp.domain.Category;
import lombok.Synchronized;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	@Synchronized
	@Nullable
	@Override
	public CategoryCommand convert(Category source) {
		if (source == null) {
			return null;
		}

		final CategoryCommand categoryCommand = new CategoryCommand();

		categoryCommand.setId(source.getId());
		categoryCommand.setDescription(source.getDescription());

		return categoryCommand;
	}
}
