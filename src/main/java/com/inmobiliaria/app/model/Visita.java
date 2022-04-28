package com.inmobiliaria.app.model;

public class Visita {

	private int id;
	private int idPropiedad;
	private int idPersona;
	private String fechaVisita;

	public Visita(int idPropiedad, int idPersona, String fechaVisita) {
		super();
		this.idPropiedad = idPropiedad;
		this.idPersona = idPersona;
		this.fechaVisita = fechaVisita;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getFechaVisita() {
		return fechaVisita;
	}

	public void setFechaVisita(String fechaVisita) {
		this.fechaVisita = fechaVisita;
	}

}
