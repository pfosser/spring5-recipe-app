package it.paofos.spring5recipeapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import it.paofos.spring5recipeapp.commands.UnitOfMeasureCommand;
import it.paofos.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import it.paofos.spring5recipeapp.domain.UnitOfMeasure;
import it.paofos.spring5recipeapp.repositories.UnitOfMeasureRepository;

class UnitOfMeasureServiceImplTest {

	UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
	UnitOfMeasureService service;

	@Mock
	UnitOfMeasureRepository unitOfMeasureRepository;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);

		service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);

	}

	@Test
	void testListAllUoms() {
		// given
		Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
		UnitOfMeasure uom1 = new UnitOfMeasure();
		uom1.setId(1L);
		unitOfMeasures.add(uom1);

		UnitOfMeasure uom2 = new UnitOfMeasure();
		uom2.setId(2L);
		unitOfMeasures.add(uom2);

		when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

		// when
		Set<UnitOfMeasureCommand> commands = service.listAllUoms();

		// then
		assertEquals(2, commands.size());
		verify(unitOfMeasureRepository, times(1)).findAll();
	}

}
