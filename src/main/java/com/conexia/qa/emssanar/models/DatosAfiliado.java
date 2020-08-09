package com.conexia.qa.emssanar.models;

import java.util.ArrayList;
import java.util.List;

public class DatosAfiliado {

	String razonSocial;
	String especialidad;
	String origenDeLaAtencion;
	String prioridadDeLaAtncion;
	String tipoServicioSolicitado;
	String ubicacionDelPaciente;
	String codigoCIE;
	String nomDiagnostico;
	String tipoDiagnostico;
	String codProcedimiento;
	String nomProcedimiento;
	String codMedicamento;
	String nomMedicamento;
	String codInsumo;
	String nomInsumo;
	

	public static List<DatosAfiliado> datosAfiliadoData = new ArrayList<>();

	public static void salvarInfoDatosAfiliado(DatosAfiliado datosAfiliado) {
		datosAfiliadoData.add(datosAfiliado);
	}

	public static DatosAfiliado traerDatos(int index) {
		return datosAfiliadoData.get(index);
	}

	public static void limpiarDatosAfiliadoList() {
		datosAfiliadoData = new ArrayList<>();
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getOrigenDeLaAtencion() {
		return origenDeLaAtencion;
	}

	public void setOrigenDeLaAtencion(String origenDeLaAtencion) {
		this.origenDeLaAtencion = origenDeLaAtencion;
	}

	public String getPrioridadDeLaAtncion() {
		return prioridadDeLaAtncion;
	}

	public void setPrioridadDeLaAtncion(String prioridadDeLaAtncion) {
		this.prioridadDeLaAtncion = prioridadDeLaAtncion;
	}

	public String getTipoServicioSolicitado() {
		return tipoServicioSolicitado;
	}

	public void setTipoServicioSolicitado(String tipoServicioSolicitado) {
		this.tipoServicioSolicitado = tipoServicioSolicitado;
	}

	public String getUbicacionDelPaciente() {
		return ubicacionDelPaciente;
	}

	public void setUbicacionDelPaciente(String ubicacionDelPaciente) {
		this.ubicacionDelPaciente = ubicacionDelPaciente;
	}

	public String getCodigoCIE() {
		return codigoCIE;
	}

	public void setCodigoCIE(String codigoCIE) {
		this.codigoCIE = codigoCIE;
	}

	public String getNomDiagnostico() {
		return nomDiagnostico;
	}

	public void setNomDiagnostico(String nomDiagnostico) {
		this.nomDiagnostico = nomDiagnostico;
	}

	public String getTipoDiagnostico() {
		return tipoDiagnostico;
	}

	public void setTipoDiagnostico(String tipoDiagnostico) {
		this.tipoDiagnostico = tipoDiagnostico;
	}

	public String getCodProcedimiento() {
		return codProcedimiento;
	}

	public void setCodProcedimiento(String codProcedimiento) {
		this.codProcedimiento = codProcedimiento;
	}

	public String getNomProcedimiento() {
		return nomProcedimiento;
	}

	public void setNomProcedimiento(String nomProcedimiento) {
		this.nomProcedimiento = nomProcedimiento;
	}

	public String getCodMedicamento() {
		return codMedicamento;
	}

	public void setCodMedicamento(String codMedicamento) {
		this.codMedicamento = codMedicamento;
	}

	public String getNomMedicamento() {
		return nomMedicamento;
	}

	public void setNomMedicamento(String nomMedicamento) {
		this.nomMedicamento = nomMedicamento;
	}

	public String getCodInsumo() {
		return codInsumo;
	}

	public void setCodInsumo(String codInsumo) {
		this.codInsumo = codInsumo;
	}

	public String getNomInsumo() {
		return nomInsumo;
	}

	public void setNomInsumo(String nomInsumo) {
		this.nomInsumo = nomInsumo;
	}
	
	

}
