package com.conexia.qa.emssanar.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ConfirmarDerechosPage {

	
	public static final Target SELECT_TIPO_DOCUMENTO = Target.the("Numero de documento")
			.locatedBy("//select[@id='tipoIdentificacion']");
	public static final Target INPUT_NUMERO_DOCUMENTO = Target.the("Numero de documento")
			.locatedBy("(//input[@id='numeroIdentificacion'])[1]");
	public static final Target BOTON_BUSCAR = Target.the("Buscar")
			.locatedBy("//button[contains(@id,'btnAceptar') and contains(text(),'Buscar')]");
	public static final Target BOTON_ACEPTAR = Target.the("ACEPTAR")
			.locatedBy("//button[@id='aceptarAfiliado']");
	public static final Target INPUT_RAZON_SOCIAL = Target.the("Razon Social")
			.locatedBy("//input[@id='razonSocial']");
	public static final Target SELECT_ESPECIALIDAD = Target.the("Especialidad")
			.locatedBy("//select[@id='especialidad']");
	public static final Target SELECT_ORIGEN_DE_ATENCION = Target.the("Origen de la Atención")
			.locatedBy("//select[@id='origenAtencionId']");
	public static final Target SELECT_PRIORIDAD_DE_ATENCION = Target.the("Prioridad de la Atención")
			.locatedBy("//select[@id='prioridadAtencion']");
	public static final Target SELECT_TIPO_SERVICIO_SOLICITADO = Target.the("Tipo de servicio Solicitado")
			.locatedBy("//select[@id='tipoServicioSolicitadoId']");
	public static final Target SELECT_UBICACION_DEL_PACIENTE = Target.the("Ubicación del paciente")
			.locatedBy("//select[@id='tipoUbicacion']");
	public static final Target BOTON_BUSCAR_INFOIPS = Target.the("Buscar información IPS")
			.locatedBy("(//button[contains(text(),'Buscar')])[2]");
	public static final Target BOTON_BUSCAR_PROFESIONAL = Target.the("Buscar información IPS")
			.locatedBy("(//button[contains(text(),'Buscar')])[3]");
	public static final Target PROFESIONAL = Target.the("Selecciona Profesional")
			.locatedBy("(//div[@id='tblSearchDiag_wrapper']//following::tr)[1]");
	
	
	
	
	
	

}