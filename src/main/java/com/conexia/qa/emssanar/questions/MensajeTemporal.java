package com.conexia.qa.emssanar.questions;

import static com.conexia.qa.emssanar.models.MensajeTemporal.guardarMensaje;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.emssanar.user_interfaces.CommonPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class MensajeTemporal implements Question<String>{

	private String mensaje;
	@Override
	public String answeredBy(Actor actor) {
		mensaje = CommonPage.MENSAJE_TEMPORAL.resolveFor(actor).getText().toString();
		guardarMensaje(mensaje);
		takeScreenshot();
		return mensaje;
	}

	public static MensajeTemporal es() {
		return new MensajeTemporal();
	}
	
}
