package it.paofos.spring5recipeapp.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.paofos.spring5recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

	Optional<Category> findByDescription(String description);
}
