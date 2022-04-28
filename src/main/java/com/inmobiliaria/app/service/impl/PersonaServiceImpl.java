package com.inmobiliaria.app.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.inmobiliaria.app.dao.impl.personasDAOImpl;
import com.inmobiliaria.app.model.Persona;
import com.inmobiliaria.app.services.PersonaService;

public class PersonaServiceImpl implements PersonaService {

	@Override
	public List<Persona> getAllPersonaInfo() throws SQLException {
		return new personasDAOImpl().findAllPersonas();
		
	}

	@Override
	public List<Persona> findAllVisitaFiltro(String filtro) throws SQLException {
		return new personasDAOImpl().findAllVisitaFiltro(filtro);
	}
}
