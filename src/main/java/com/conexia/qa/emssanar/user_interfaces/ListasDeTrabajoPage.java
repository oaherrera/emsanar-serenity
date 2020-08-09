package com.conexia.qa.emssanar.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class ListasDeTrabajoPage {

	public static final Target INPUT_NUMERO_DE_CUENTA = Target.the("Numero de Cuenta")
			.locatedBy("(//input[contains(@id,'busquedaRadicado:formListaTrabajo:listaTrabajo')])[2]");
	public static final Target BOTON_BUSCAR = Target.the("Buscar").locatedBy(
			"//button[contains(@id,'busquedaRadicado:formListaTrabajo:compositeFiltroRadicado:')]/span[.='Buscar']");

}
