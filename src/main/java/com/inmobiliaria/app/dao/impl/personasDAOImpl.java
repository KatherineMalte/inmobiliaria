package com.inmobiliaria.app.dao.impl;

import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.inmobiliaria.app.dao.PersonaDAO;
import com.inmobiliaria.app.model.Persona;
import com.inmobiliaria.app.util.DBUtil;

public class personasDAOImpl implements PersonaDAO {
	@Override
	public List<Persona> findAllPersonas() throws SQLException {

		List<Persona> listPersonas = new ArrayList<Persona>();
		String sql = "SELECT id, nombre, apellido, correo FROM desarrollo.persona";
		try (Connection connection = DBUtil.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String correo = resultSet.getString("correo");

				Persona p = new Persona(nombre, apellido, correo);
				listPersonas.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPersonas;
	}

	@Override
	public List<Persona> findAllVisitaFiltro(String filtro) throws SQLException {

		List<Persona> listPersonas = new ArrayList<Persona>();
		String sql = "select p.nombre,p.apellido,v.fechavisita,	p.correo,v.idpropiedad,p2.direccion from persona p inner join visitas v on	v.idpersona = p.id inner join propiedad p2 on 	p2.id = v.idpropiedad where p.correo like :filtro 	or v.fechaVisita like :filtro or p.nombre like :filtro or p.apellido like :filtro or v.fechaVisita like :filtro	or v.idPropiedad like :filtro	or p2.direccion like :filtro";
		try (Connection connection = DBUtil.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String fechavisita = resultSet.getString("fechavisita");
				String correo = resultSet.getString("correo");
				int idpropiedad = resultSet.getInt("idpropiedad");
				String direccion = resultSet.getString("direccion");

				Persona p = new Persona(nombre, apellido, fechavisita, correo, idpropiedad, direccion);
				listPersonas.add(p);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listPersonas;
	}

}
