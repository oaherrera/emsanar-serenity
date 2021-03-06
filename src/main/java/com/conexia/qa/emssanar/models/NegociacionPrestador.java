package com.conexia.qa.emssanar.models;

public class NegociacionPrestador {

	private String modalidad;
	private String regimen;
	private String poblacion;
	private String complejidad;
	private String numeroNegociacion;
	private String mesAnio;
	private String diaDelMes;
	private String acta;
	private String responsable;
	private String correo;
	private String nivelAtencion;

	private static NegociacionPrestador negociacionPrestador;

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getComplejidad() {
		return complejidad;
	}

	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}

	public String getNumeroNegociacion() {
		return numeroNegociacion;
	}

	public void setNumeroNegociacion(String numeroNegociacion) {
		this.numeroNegociacion = numeroNegociacion;
	}

	public String getMesAnio() {
		return mesAnio;
	}

	public void setMesAnio(String mesAnio) {
		this.mesAnio = mesAnio;
	}

	public String getDiadelMes() {
		return diaDelMes;
	}

	public void setDiaDelMes(String diaDelMes) {
		this.diaDelMes = diaDelMes;
	}

	public String getActa() {
		return acta;
	}

	public void setActa(String acta) {
		this.acta = acta;
	}
	

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNivelAtencion() {
		return nivelAtencion;
	}

	public void setNivelAtencion(String nivelAtencion) {
		this.nivelAtencion = nivelAtencion;
	}

	public static void guardarNegociacionPrestador(NegociacionPrestador pnegociacionPrestador) {
		if (negociacionPrestador != null) {
			negociacionPrestador = new NegociacionPrestador();
		}
		negociacionPrestador = pnegociacionPrestador;
	}

	public static NegociacionPrestador traerNegociacionPrestador() {
		return negociacionPrestador;
	}

	public static void limpioDatosNegociacionPrestador() {
		negociacionPrestador = new NegociacionPrestador();
	}

}
