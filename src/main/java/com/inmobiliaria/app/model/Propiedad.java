package com.inmobiliaria.app.model;

public class Propiedad {

	private int id;
	protected String direccion;
	protected String ciudad;

	public Propiedad(String direccion, String ciudad) {
		super();
		this.direccion = direccion;
		this.ciudad = ciudad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
