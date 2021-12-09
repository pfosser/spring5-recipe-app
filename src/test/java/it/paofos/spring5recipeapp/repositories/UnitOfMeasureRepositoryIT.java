package it.paofos.spring5recipeapp.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import it.paofos.spring5recipeapp.domain.UnitOfMeasure;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
	@Test
	void findByDescription() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}

	@Test
	void findByDescriptionCup() {

		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		
		assertEquals("Cup", uomOptional.get().getDescription());
	}

}
