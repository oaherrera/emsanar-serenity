package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.BandejaPrestadorNegociacionPage.*;

import java.util.List;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class FiltroNegociacion implements Task {

	private String numeroNegociacion;
	private String mesAnio;
	private String diaDelMes;

	public FiltroNegociacion(String numeroNegociacion, String mesAnio, String diaDelMes) {
		this.numeroNegociacion = numeroNegociacion;
		this.mesAnio = mesAnio;
		this.diaDelMes = diaDelMes;
	}

	@Override
	@Step("{0} Filtro por el número de la Negociación")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(numeroNegociacion).into(FILTRO_NUMERO_NEGOCIACION));
		actor.attemptsTo(Esperar.por(2000));
		if (BOTON_ICONO_VER_OTROSI.resolveFor(actor).isPresent()) {
			actor.attemptsTo(Click.on(BOTON_ICONO_VER_OTROSI));
			actor.attemptsTo(Click.on(BOTON_GENERAR_OTROSI));
			actor.attemptsTo(Esperar.por(1000));
			actor.attemptsTo(Click.on(CHECKBOX_PRORROGA));
			actor.attemptsTo(Esperar.por(1000));
			actor.attemptsTo(Click.on(ICONO_CALENDARIO));
			actor.attemptsTo(Esperar.por(1000));

			while (true) {
				String fechas = TITULO_CALENDARIO_FECHA.resolveFor(actor).getText();
				if (fechas.equals(mesAnio)) {
					break;
				} else {

					actor.attemptsTo(Click.on(BOTON_SIGUIENTE_MES));

				}

			}
			Serenity.takeScreenshot();
			actor.attemptsTo(Esperar.por(3000));

			List<WebElementFacade> diasDelMes = DIAS_DEL_MES.resolveAllFor(actor);

			for (WebElementFacade dias : diasDelMes) {
				// System.out.println(dias.getText());
				String todosLosDias = dias.getText();
				if (todosLosDias.equals(diaDelMes)) {
					dias.click();
					break;
				}

			}
			Serenity.takeScreenshot();
			actor.attemptsTo(Esperar.por(3000));
			actor.attemptsTo(Click.on(BOTON_GENERAR), EsperarCargando.pagina());
			actor.attemptsTo(Esperar.por(2000));
			
		} else {
			actor.attemptsTo(Click.on(BOTON_GENERAR_OTROSI));
			actor.attemptsTo(Esperar.por(1000));
			actor.attemptsTo(Click.on(CHECKBOX_PRORROGA));
			actor.attemptsTo(Esperar.por(1000));
			actor.attemptsTo(Click.on(ICONO_CALENDARIO));
			actor.attemptsTo(Esperar.por(1000));

			while (true) {
				String fechas = TITULO_CALENDARIO_FECHA.resolveFor(actor).getText();
				if (fechas.equals(mesAnio)) {
					break;
				} else {

					actor.attemptsTo(Click.on(BOTON_SIGUIENTE_MES));

				}

			}
			Serenity.takeScreenshot();
			actor.attemptsTo(Esperar.por(3000));

			List<WebElementFacade> diasDelMes = DIAS_DEL_MES.resolveAllFor(actor);

			for (WebElementFacade dias : diasDelMes) {
				// System.out.println(dias.getText());
				String todosLosDias = dias.getText();
				if (todosLosDias.equals(diaDelMes)) {
					dias.click();
					break;
				}

			}
			Serenity.takeScreenshot();
			actor.attemptsTo(Esperar.por(3000));
			actor.attemptsTo(Click.on(BOTON_GENERAR), EsperarCargando.pagina());
			actor.attemptsTo(Esperar.por(2000));
		}

	}

	public static FiltroNegociacion porNumero(String numeroNegociacion, String mesAnio, String diasDelMes) {
		return Tasks.instrumented(FiltroNegociacion.class, numeroNegociacion, mesAnio, diasDelMes);
	}

}
