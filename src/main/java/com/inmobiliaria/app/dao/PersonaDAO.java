package com.inmobiliaria.app.dao;

import java.sql.SQLException;
import java.util.List;
import com.inmobiliaria.app.model.Persona;

public interface PersonaDAO {
	public List<Persona> findAllPersonas() throws SQLException;
	public List<Persona> findAllVisitaFiltro(String filtro) throws SQLException;
}
