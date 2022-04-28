package com.inmobiliaria.app.model;

public class Persona {

	private int id;
	private String apellido;
	private String email;
	private String nombre;
	private Propiedad propiedad;
	private Visita visita;

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}
	public Persona(String apellido, String email, String nombre,String direccion,int idPropiedad, String fechaVisita) {
		this.apellido = apellido;
		this.email = email;
		this.nombre = nombre;
		

	}
	public Persona(String apellido, String email, String nombre) {
		this.apellido = apellido;
		this.email = email;
		this.nombre = nombre;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
