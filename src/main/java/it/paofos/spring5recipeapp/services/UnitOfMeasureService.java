package it.paofos.spring5recipeapp.services;

import java.util.Set;

import it.paofos.spring5recipeapp.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

	Set<UnitOfMeasureCommand> listAllUoms();
}
