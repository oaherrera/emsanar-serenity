package com.conexia.qa.emssanar.models;

import java.util.ArrayList;
import java.util.List;

public class Insumos {

	String porCodigoMedicamento;
	String porDescripcionMedicamento;
	String porCodigoATCMedicamento;
	String porCodigoProcedimiento;
	String porDescripcionProcedimiento;
	String porCodigoPaquete;
	String porDescripcionpaquete;
	String porCodigoIPSPaquete;
	

	public Insumos(String porCodigoMedicamento, String porDescripcionMedicamento, String porCodigoATCMedicamento, String porCodigoProcedimiento,
			String porDescripcionProcedimiento,String porCodigoPaquete,String porDescripcionpaquete,String porCodigoIPSPaquete ) {
		this.porCodigoMedicamento = porCodigoMedicamento;
		this.porDescripcionMedicamento = porDescripcionMedicamento;
		this.porCodigoATCMedicamento = porCodigoATCMedicamento;
		this.porCodigoProcedimiento = porCodigoProcedimiento;
		this.porDescripcionProcedimiento = porDescripcionProcedimiento;
		this.porCodigoPaquete = porCodigoPaquete;
		this.porDescripcionpaquete = porDescripcionpaquete;
		this.porCodigoIPSPaquete = porCodigoIPSPaquete;
		

	}

	private static Insumos objInsumos;
	private static List<Insumos> insumos = new ArrayList<>();

	public static void salvarInformacionMedicamentos(Insumos medicamentosData) {
		insumos.add(medicamentosData);
	}

	public static Insumos traerInsumo(int indice) {
		return insumos.get(indice);
	}

	public int cantidadMedicamentos() {
		return insumos.size();
	}

	public String getPorCodigoMedicamento() {
		return porCodigoMedicamento;
	}

	public void setPorCodigoMedicamento(String porCodigoMedicamento) {
		this.porCodigoMedicamento = porCodigoMedicamento;
	}

	public String getPorDescripcionMedicamento() {
		return porDescripcionMedicamento;
	}

	public void setPorDescripcionMedicamento(String porDescripcionMedicamento) {
		this.porDescripcionMedicamento = porDescripcionMedicamento;
	}

	public String getPorCodigoATCMedicamento() {
		return porCodigoATCMedicamento;
	}

	public void setPorCodigoATCMedicamento(String porCodigoATCMedicamento) {
		this.porCodigoATCMedicamento = porCodigoATCMedicamento;
	}

	public String getPorCodigoProcedimiento() {
		return porCodigoProcedimiento;
	}

	public void setPorCodigoProcedimiento(String porCodigoProcedimiento) {
		this.porCodigoProcedimiento = porCodigoProcedimiento;
	}

	public String getPorDescripcionProcedimiento() {
		return porDescripcionProcedimiento;
	}

	public void setPorDescripcionProcedimiento(String porDescripcionProcedimiento) {
		this.porDescripcionProcedimiento = porDescripcionProcedimiento;
	}

	public String getPorCodigoPaquete() {
		return porCodigoPaquete;
	}

	public void setPorCodigoPaquete(String porCodigoPaquete) {
		this.porCodigoPaquete = porCodigoPaquete;
	}

	public String getPorDescripcionpaquete() {
		return porDescripcionpaquete;
	}

	public void setPorDescripcionpaquete(String porDescripcionpaquete) {
		this.porDescripcionpaquete = porDescripcionpaquete;
	}

	public String getPorCodigoIPSPaquete() {
		return porCodigoIPSPaquete;
	}

	public void setPorCodigoIPSPaquete(String porCodigoIPSPaquete) {
		this.porCodigoIPSPaquete = porCodigoIPSPaquete;
	}

	
	

}
