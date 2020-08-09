package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.NUMERO_NEGOCIACION_FILTRO;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.TABLA_ENCABEZADO;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.VER_NEGOCIACION;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.emssanar.interactions.Esperar;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConsultoNegociacion implements Task {

	private String numeroNegociacion;
	private String accionAlBuscar;

	public ConsultoNegociacion(String numeroNegociacion, String accionAlBuscar) {
		this.numeroNegociacion = numeroNegociacion;
		this.accionAlBuscar = accionAlBuscar;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		takeScreenshot();

		if (numeroNegociacion != null) {
			actor.attemptsTo(Enter.theValue(numeroNegociacion).into(NUMERO_NEGOCIACION_FILTRO));
			actor.attemptsTo(Esperar.por(6000));
			takeScreenshot();
		}

		switch (accionAlBuscar) {
		case "Ver negociación":
			actor.attemptsTo(setiarAtributo(TABLA_ENCABEZADO, "value", "753,0"));
			takeScreenshot();
			actor.attemptsTo(Click.on(VER_NEGOCIACION));
			break;
		}
		takeScreenshot();
	}

	public static ConsultoNegociacion porNumeroDeNegocacion(String numeroNegociacion) {
		return Tasks.instrumented(ConsultoNegociacion.class, numeroNegociacion, "");
	}

	public static ConsultoNegociacion para(String accionAlBuscar) {
		return Tasks.instrumented(ConsultoNegociacion.class, null, accionAlBuscar);
	}

}
