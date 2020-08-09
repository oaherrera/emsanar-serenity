package com.conexia.qa.emssanar.questions;

import static com.conexia.qa.emssanar.user_interfaces.ResultadoGestionDeCuentasValidadasPage.NUMEROCTA_LISTAS_DE_TRABAJO;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import com.conexia.qa.emssanar.user_interfaces.ResultadoGestionDeCuentasValidadasPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidoEstadoCuentaEnListasDeTrabajo implements Question<Boolean> {
	
	String cuenta;
	String estado;
	
	public ValidoEstadoCuentaEnListasDeTrabajo(String cuenta, String estado) {
		this.cuenta = cuenta;
		this.estado = estado;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		if (!NUMEROCTA_LISTAS_DE_TRABAJO.of(cuenta).resolveFor(actor).isVisible()) {
			takeScreenshot();
			System.out.println("Numero cuenta");
			return false;
		} else if (!ResultadoGestionDeCuentasValidadasPage.ESTADO_LISTAS_DE_TRABAJO.of(estado).resolveFor(actor).isVisible()) {
			takeScreenshot();
			System.out.println("estado");
			return false;
		}
		takeScreenshot();
		return true;
	}
		
		

	
	public static ValidoEstadoCuentaEnListasDeTrabajo con(String cuenta, String estado) {

		return new ValidoEstadoCuentaEnListasDeTrabajo(cuenta, estado);
	}

}
