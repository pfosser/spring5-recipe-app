package it.paofos.spring5recipeapp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.paofos.spring5recipeapp.domain.Category;
import it.paofos.spring5recipeapp.domain.UnitOfMeasure;
import it.paofos.spring5recipeapp.repositories.CategoryRepository;
import it.paofos.spring5recipeapp.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		
		Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Cup");

		System.out.println("Cat Id is: " + categoryOptional.get().getId());
		System.out.println("UOM Id is: " + unitOfMeasureOptional.get().getId());

		return "index";
	}
}
