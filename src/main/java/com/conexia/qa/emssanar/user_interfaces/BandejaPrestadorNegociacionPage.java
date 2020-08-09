package com.conexia.qa.emssanar.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BandejaPrestadorNegociacionPage {

	public static final Target FILTRO_NOMBRE = Target.the("Filtrar por nombre")
			.locatedBy("//thead[contains(@id,'PrestadoresGral_head')]/tr/th/span[.=' Nombre']//following::input[1]");
	public static final Target VER_NEGOCIACIONES = Target.the("Ver Negociaciones")
			.locatedBy("(//button[@title='Ver Negociaciones del Prestador'])[1]");
	public static final Target INPUT_NUMERO_NEGOCIACION = Target.the("Número de Negociación")
			.locatedBy("//input[contains(@id,'filtrosPrestador:numeroNegociacion')]");
	public static final Target FILTRO_NUMERO_NEGOCIACION = Target.the("Filtro de Negociación")
			.locatedBy("(//input[contains(@id,'tblNegociacionesPrestadorForm:negociacionesPrestador:')])[1]");
	public static final Target BOTON_ICONO_VER_OTROSI = Target.the("Boton OtroSi").locatedBy(
			"//button[contains(@id,'tblNegociacionesPrestadorForm:negociacionesPrestador:0:btnVerNegociacionesOtroSi')]");
	public static final Target BOTON_GENERAR_OTROSI = Target.the("Boton Generar OtroSi")
			.locatedBy("//button[contains(@id,'tblNegociacionesPrestadorForm:negociacionesPrestador:0:btnOtroSi')]");
	public static final Target CHECKBOX_PRORROGA = Target.the("CheckBox Prorroga")
			.locatedBy("//div[contains(@id,'gestionOtroSiForm:optTipoOtro2')]");
	public static final Target INPUT_FECHA_FIN = Target.the("Fecha Fin Prorroga")
			.locatedBy("//input[contains(@id,'gestionOtroSiForm:calendarFechFinProrroga_input')]");
	public static final Target ICONO_CALENDARIO = Target.the("Icono Calendario").locatedBy(
			"(//button[contains(@class,'ui-datepicker-trigger ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only')])[2]");
	public static final Target BOTON_SIGUIENTE_MES = Target.the("Boton siguiente Mes")
			.locatedBy("//div[contains(@id,'ui-datepicker-div')]//span[contains(text(),'Siguiente')]");

	public static final Target TITULO_CALENDARIO_FECHA = Target.the("Titulo Calendario Fecha")
			.locatedBy("//div[contains(@class,'ui-datepicker-title')]");
	public static final Target DIAS_DEL_MES = Target.the("Dias del Mes")
			.locatedBy("//table[contains(@class,'ui-datepicker-calendar')]/tbody/tr/td");
	public static final Target BOTON_GENERAR = Target.the("Generar Otro Si")
			.locatedBy("//button[contains(@id,'gestionOtroSiForm:j_idt162')]/span");

}
