package com.conexia.qa.emssanar.interactions;

import static com.conexia.qa.emssanar.drivers.OwnWebDriver.getDriver;
import static com.conexia.qa.emssanar.user_interfaces.CommonPage.BARRA_DE_CARGANDO_ARCHIVO;
import static java.util.concurrent.TimeUnit.SECONDS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class EsperarCargandoArchivo implements Interaction {

	@Override
	@Step("{0} esperar mientras carga el archivo")
	public <T extends Actor> void performAs(T actor) {
			actor.attemptsTo(Esperar.por(1200));
			getDriver().manage().timeouts().implicitlyWait(2, SECONDS);
			while (BARRA_DE_CARGANDO_ARCHIVO.resolveFor(actor).isVisible()) {
				actor.attemptsTo(Esperar.por(1200));
			}
			getDriver().manage().timeouts().implicitlyWait(10, SECONDS);
	}

	public static EsperarCargandoArchivo enElFormulario() {
		return Tasks.instrumented(EsperarCargandoArchivo.class);
	}

}
