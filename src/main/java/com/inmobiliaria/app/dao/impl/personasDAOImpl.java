package com.inmobiliaria.app.dao.impl;

import javax.swing.table.DefaultTableModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.inmobiliaria.app.dao.PersonaDAO;

public class personasDAOImpl implements PersonaDAO {
	private String url_api = "http://localhost:5001/proyectoLista";

	@Override
	public String get() {
		String salida = "";
		try {
			URL url = new URL(url_api);
			HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
			c_api.setRequestMethod("GET");
			c_api.setRequestProperty("Accept", "application/json");
			if (c_api.getResponseCode() == 200) {
				InputStreamReader entrada = new InputStreamReader(c_api.getInputStream());
				BufferedReader lectura = new BufferedReader(entrada);
				salida = lectura.readLine();
			} else {
				salida = "";
				System.out.println("No se puede conectar a la api : " + c_api.getResponseCode());

			}

			c_api.disconnect();

		} catch (IOException ex) {
			System.out.println("Error api:" + ex.getMessage());
		}
		return salida;
	}

	@Override
	public DefaultTableModel leer() {
		DefaultTableModel tabla = new DefaultTableModel();
		try {
			String encabezado[] = { "nombre", "apellido", "fechavisita", "correo", "idpropiedad", "direccion" };

			tabla.setColumnIdentifiers(encabezado);
			String datos[] = new String[6];
			JSONArray arreglo = new JSONArray(get());
			for (int indice = 0; indice < arreglo.length(); indice++) {
				JSONObject atributo = arreglo.getJSONObject(indice);
				datos[0] = atributo.getString("nombre");
				datos[1] = atributo.getString("apellido");
				datos[2] = atributo.getString("fechavisita");
				datos[3] = atributo.getString("correo");
				datos[4] = String.valueOf(atributo.getInt("idpropiedad"));
				datos[5] = atributo.getString("direccion");
				tabla.addRow(datos);
			}
		} catch (JSONException ex) {
			System.out.println("Error tabla:" + ex.getMessage());
		}
		return tabla;
	}
}
