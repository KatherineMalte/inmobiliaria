package com.inmobiliaria.app.services;

import java.sql.SQLException;
import java.util.List;

import com.inmobiliaria.app.model.Persona;

public interface PersonaService {
	public abstract List<Persona> getAllPersonaInfo() throws SQLException;
	public abstract List<Persona> findAllVisitaFiltro(String filtro) throws SQLException;
}
