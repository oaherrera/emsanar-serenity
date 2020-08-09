package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.GestionCuentasEpsPage.ACCION;
import static com.conexia.qa.emssanar.user_interfaces.GestionCuentasPage.CONFIRMAR_SI;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.emssanar.interactions.EsperarCargando;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class GestionoLaCuentaComoEps implements Task {

	private String accion;

	public GestionoLaCuentaComoEps(String accion) {
		this.accion = accion;
	}

	@Override
	@Step("{0} Gestion de la cuenta como EPS")
	public <T extends Actor> void performAs(T actor) {

		Serenity.takeScreenshot();
		switch (accion) {
		case "Devolución EPS":
			actor.attemptsTo(EsperarCargando.pagina(), Click.on(ACCION.of(accion)), EsperarCargando.pagina());
			Serenity.takeScreenshot();
			break;
		case "Registrar Cuenta EPS":
			actor.attemptsTo(EsperarCargando.pagina(), Click.on(ACCION.of(accion)), EsperarCargando.pagina());
			Serenity.takeScreenshot();
			break;

		}

		Serenity.takeScreenshot();
	}

	public static GestionoLaCuentaComoEps realizandoLaAccion(String accion) {
		return Tasks.instrumented(GestionoLaCuentaComoEps.class, accion);

	}

}
