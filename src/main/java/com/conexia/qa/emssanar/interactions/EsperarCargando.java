package com.conexia.qa.emssanar.interactions;

import static com.conexia.qa.emssanar.drivers.OwnWebDriver.getDriver;
import static com.conexia.qa.emssanar.user_interfaces.CommonPage.CARGANDO;
import static java.util.concurrent.TimeUnit.SECONDS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class EsperarCargando implements Interaction {

	@Override
	@Step("{0} esperar mientras la pagina esta cargando")
	public <T extends Actor> void performAs(T actor) {
			actor.attemptsTo(Esperar.por(1000));
			getDriver().manage().timeouts().implicitlyWait(2, SECONDS);
			while (CARGANDO.resolveFor(actor).isVisible()) {
				actor.attemptsTo(Esperar.por(1000));
			}
			getDriver().manage().timeouts().implicitlyWait(10, SECONDS);
	}

	public static EsperarCargando pagina() {
		return Tasks.instrumented(EsperarCargando.class);
	}

}
