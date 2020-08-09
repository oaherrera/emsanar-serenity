package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.LegalizacionOtroSiPage.*;
import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.interactions.Swipe;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class DiligencioDatos implements Task {

	private String correo;
	private String nivelAtencion;

	public DiligencioDatos(String correo, String nivelAtencion) {
		this.correo = correo;
		this.nivelAtencion = nivelAtencion;

	}

	@Override
	@Step("{0} Diligencio los datos del contrato")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BOTON_LEGALIZAR_SOLICITUD), EsperarCargando.pagina());
		if (CORREO_ELECTRONICO.resolveFor(actor).getAttribute("value").equals("")) {
			actor.attemptsTo(Enter.theValue(correo).into(CORREO_ELECTRONICO));
		}
		actor.attemptsTo(Esperar.por(3000));

		if (SELECT_NIVEL__DE_ATENCION.resolveFor(actor).getAttribute("value").equals("")) {
			// actor.attemptsTo(SelectFromOptions.byVisibleText(nivelAtencion).from(SELECT_NIVEL__DE_ATENCION));
			actor.attemptsTo(Click.on(NIVEL_DE_ATENCION));
			actor.attemptsTo(Click.on(NIVEL_DE_ATENCION_SELECCION.of(nivelAtencion)));

		}

		actor.attemptsTo(Swipe.vertical(300));
		actor.attemptsTo(Click.on(ACTA_OTROSI));
		actor.attemptsTo(Esperar.por(2000));
		// actor.attemptsTo(Click.on(ACTA_OTROSI_SELECCION.of(acta)));
		actor.attemptsTo(JavaScriptClick.on(ACTA_OTROSI_SELECCION));
		Serenity.takeScreenshot();
		actor.attemptsTo(Esperar.por(1000));
		actor.attemptsTo(Swipe.vertical(500));
		actor.attemptsTo(Click.on(GUARAR_DATOS_OTROSI), EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(BOTON_CONFIRMAR_ACEPTAR), EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Esperar.por(2000));

	}

	public static DiligencioDatos delContrato(String correo, String nivelAtencion) {
		return Tasks.instrumented(DiligencioDatos.class, correo, nivelAtencion);
	}

}
