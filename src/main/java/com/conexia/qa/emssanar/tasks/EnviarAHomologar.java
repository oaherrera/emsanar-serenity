package com.conexia.qa.emssanar.tasks;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.HacerClic;
import com.conexia.qa.emssanar.interactions.Sleep;
import com.conexia.qa.emssanar.user_interfaces.CommonPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class EnviarAHomologar implements Task {
	
	public EnviarAHomologar() {
	}

	@Override
	@Step("{0} se envia al proceso de homologación")
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Esperar.por(3000));
		actor.attemptsTo(HacerClic.En(CommonPage.ENVIAR_HOMOLOGACION));
		actor.attemptsTo(Esperar.por(1000));
		actor.attemptsTo(Click.on(CommonPage.CONFIRMAR_SI));
		Serenity.takeScreenshot();
		actor.attemptsTo(Esperar.por(5000));
	}

	public static EnviarAHomologar cuenta() {

		return Tasks.instrumented(EnviarAHomologar.class);
	}

}
