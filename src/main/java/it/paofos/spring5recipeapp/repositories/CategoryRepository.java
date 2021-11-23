package it.paofos.spring5recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import it.paofos.spring5recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
