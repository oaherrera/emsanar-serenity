package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.BandejaPrestadorNegociacionPage.*;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import org.openqa.selenium.Keys;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;

public class BuscoLaNegociacion implements Task {
	
	private String numeroNegociacion;
	private String realizarAccionAlBuscar;

	public BuscoLaNegociacion(String numeroNegociacion, String realizarAccionAlBuscar) {
		this.numeroNegociacion = numeroNegociacion;
		this.realizarAccionAlBuscar = realizarAccionAlBuscar;
	}


	@Override
	@Step("{0} Buscamos la Negociación")
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		if (numeroNegociacion != null) {
			actor.attemptsTo(Enter.theValue(numeroNegociacion).into(INPUT_NUMERO_NEGOCIACION));
			actor.attemptsTo(Hit.the(Keys.ENTER).into(INPUT_NUMERO_NEGOCIACION), EsperarCargando.pagina());
			actor.attemptsTo(Esperar.por(1000));
			takeScreenshot();
		}

		if (realizarAccionAlBuscar != null) {
			switch (realizarAccionAlBuscar) {
			case "Ver Negociaciones":
				actor.attemptsTo(Click.on(VER_NEGOCIACIONES));
				takeScreenshot();
			}
		}		
	}
	
	public static BuscoLaNegociacion porNumero(String numeroNegociacion) {
		return Tasks.instrumented(BuscoLaNegociacion.class, numeroNegociacion, null);
	}

	public static BuscoLaNegociacion parairA() {
		return Tasks.instrumented(BuscoLaNegociacion.class, null, "Ver Negociaciones");
	}


}
