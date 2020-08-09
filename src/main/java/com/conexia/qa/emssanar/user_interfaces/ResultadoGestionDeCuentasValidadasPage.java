package com.conexia.qa.emssanar.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ResultadoGestionDeCuentasValidadasPage {
	public static final Target NUMERO_CUENTA = Target.the("Resultado Numero de Cuenta")
			.locatedBy("//tbody[contains(@id,'tablaCuentas_data')]/tr/td[1][.='{0}']");
	public static final Target ESTADO = Target.the("Resultado Estado de Cuenta")
			.locatedBy("//tbody[contains(@id,'tablaCuentas_data')]/tr/td[9][.='{0}']");
	
	public static final Target ESTADO_GESTION_CUENTAS_EPS = Target.the("Resultado Estado de Cuenta")
			.locatedBy("//tbody[contains(@id,'tablaCuentas_data')]/tr/td[11][.='{0}']");
	public static final Target NUMEROCTA_LISTAS_DE_TRABAJO = Target.the("Numero Cuenta en Listas de Trabajo")
			.locatedBy("//tbody[contains(@id,'busquedaRadicado:formListaTrabajo:listaTrabajo_data')]/tr/td[3]/span[.='{0}']");
	
	public static final Target ESTADO_LISTAS_DE_TRABAJO = Target.the("Estado en Listas de Trabajo")
			.locatedBy("//tbody[contains(@id,'busquedaRadicado:formListaTrabajo:listaTrabajo_data')]/tr/td[8][.='{0}']");
	public static final Target ESTADO_NEGOCIACION_OTROSI = Target.the("Estado Negociación otro si")
			.locatedBy("//tbody[contains(@id,'formConsultaSolicitudes:tblListaSolicitudesPorLegalizar_data')]/tr/td[17][.='{0}']");
	
}
