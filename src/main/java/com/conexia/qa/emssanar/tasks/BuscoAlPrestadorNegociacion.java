package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.BandejaPrestadorNegociacionPage.FILTRO_NOMBRE;
import static com.conexia.qa.emssanar.user_interfaces.BandejaPrestadorNegociacionPage.VER_NEGOCIACIONES;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import org.openqa.selenium.Keys;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.tasks.BuscoAlPrestadorNegociacion;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.thucydides.core.annotations.Step;

public class BuscoAlPrestadorNegociacion implements Task {

	private String nombreprestador;
	private String realizarAccionAlBuscar;

	public BuscoAlPrestadorNegociacion(String nombreprestador, String realizarAccionAlBuscar) {
		this.nombreprestador = nombreprestador;
		this.realizarAccionAlBuscar = realizarAccionAlBuscar;
	}

	@Override
	@Step("{0} Buscamos un prestador para crear Negociación")
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		if (nombreprestador != null) {
			actor.attemptsTo(Enter.theValue(nombreprestador).into(FILTRO_NOMBRE));
			actor.attemptsTo(Hit.the(Keys.ENTER).into(FILTRO_NOMBRE));
			actor.attemptsTo(Esperar.por(2000));
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

	public static BuscoAlPrestadorNegociacion porNombre(String nombreprestador) {
		return Tasks.instrumented(BuscoAlPrestadorNegociacion.class, nombreprestador, null);
	}

	public static BuscoAlPrestadorNegociacion para(String realizarAccionAlBuscar ) {
		return Tasks.instrumented(BuscoAlPrestadorNegociacion.class, null, realizarAccionAlBuscar);
	}

}
