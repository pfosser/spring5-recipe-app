package it.paofos.spring5recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;

import it.paofos.spring5recipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

}
