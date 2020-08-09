package com.conexia.qa.emssanar.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LegalizacionOtroSiPage {
	
	public static final Target NUMERO_DE_NEGOCIACION = Target.the("Numero de Negociación")
			.locatedBy("//input[contains(@id,'formConsultaSolicitudes:txtNumeroNegociacion')]");
	public static final Target VER_SOLICITUDES_OTROSI = Target.the("Ver solicitudes otro si")
			.locatedBy("//button[contains(@id,'formConsultaSolicitudes:tblListaSolicitudesPorLegalizar:0:btnVerSolicitudesOtroSi')]");
	public static final Target BOTON_LEGALIZAR_SOLICITUD = Target.the("Ver solicitudes otro si")
			.locatedBy("(//a[contains(@id,'formConsultaSolicitudes:tblListaSolicitudesPorLegalizar:')])[1]");
	public static final Target ACTA_OTROSI = Target.the("Acta Otro Si")
			.locatedBy("//label[contains(@id,'formGenerarMinuta:formatoActaOtroSi_label')]");
	public static final Target ACTA_OTROSI_SELECCION = Target.the("Acta Otro Si")
			.locatedBy("//div[contains(@id,'formGenerarMinuta:formatoActaOtroSi_panel')]//li[contains(@data-label,'ACTA OTROSI - DUPLICA  CONTRATO EVENTO DE TRATAMIENTO DE DROGADICCION')]");
	public static final Target GUARAR_DATOS_OTROSI = Target.the("Guardar datos del otrosi")
			.locatedBy("//button[contains(@id,'formGenerarMinuta:guardarLegalizacion')]");
	public static final Target BOTON_CONFIRMAR_ACEPTAR = Target.the("Boton confirmar Aceptar")
			.locatedBy("//button[contains(@id,'formDialogConfirmDuracion:')]/span[contains(text(),'Aceptar')]");
	public static final Target MENU_VISTO_BUENO = Target.the("Menu Visto Bueno")
			.locatedBy("(//span[contains(text(),'Visto Bueno')])[1]");
	public static final Target ACCIONES_VISTO_BUENO = Target.the("Click para ir a Visto Bueno")
			.locatedBy("(//a[contains(@title,'Asignar Visto Bueno')])[1]");
	public static final Target RESPONSABLE_VISTO_BUENO = Target.the("Responsable Visto Bueno")
			.locatedBy("//label[contains(@id,'formGenerarMinuta:responsableVoBo_label')]");
	public static final Target SELECCION_RESPONSABLE_VISTO_BUENO = Target.the("Selección Responsable Visto Bueno")
			.locatedBy("//div[contains(@id,'formGenerarMinuta:responsableVoBo_panel')]//li[contains(@data-label,'{0}')]");
	public static final Target GUARDAR_VISTO_BUENO = Target.the("Guardar Visto Bueno")
			.locatedBy("//button[contains(@id,'formGenerarMinuta:asignarVIstoBueno')]");
	public static final Target CORREO_ELECTRONICO = Target.the("Correo Electronico")
			.locatedBy("//input[contains(@id,'formGenerarMinuta:correoElectronico')]");
	public static final Target NIVEL_DE_ATENCION = Target.the("Nivel de Atención")
			.locatedBy("//label[@id='formGenerarMinuta:nivelContrato_label']");
	public static final Target NIVEL_DE_ATENCION_SELECCION = Target.the("Nivel de Atención Selección")
			.locatedBy("//div[contains(@id,'formGenerarMinuta:nivelContrato_panel')]//li[@data-label='{0}']");
	public static final Target SELECT_NIVEL__DE_ATENCION = Target.the("Seleccionar Nivel de Atención Selección")
			.locatedBy("//select[@id='formGenerarMinuta:nivelContrato_input']");
	
}
