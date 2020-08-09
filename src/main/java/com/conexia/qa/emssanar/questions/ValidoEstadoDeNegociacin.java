package com.conexia.qa.emssanar.questions;

import static com.conexia.qa.emssanar.user_interfaces.ResultadoGestionDeCuentasValidadasPage.*;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
public class ValidoEstadoDeNegociacin implements Question<Boolean> {
	
	private String estado;
	
	public ValidoEstadoDeNegociacin(String estado) {
		this.estado = estado;
	}


	@Override
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
	if (!ESTADO_NEGOCIACION_OTROSI.of(estado).resolveFor(actor).isVisible()) {
			takeScreenshot();
			System.out.println("Estado");
			return false;
		}
		takeScreenshot();
		return true;
	}
	
	public static ValidoEstadoDeNegociacin conEstado(String estado) {
		return new ValidoEstadoDeNegociacin(estado);
	}

}
