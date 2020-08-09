package com.conexia.qa.emssanar.tasks;

import com.conexia.qa.emssanar.user_interfaces.FormularioGestionDeCuentasValidadasPage;
import com.conexia.qa.emssanar.user_interfaces.RipsValidacionCuentaPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class LegarlizarCta implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Click.on(FormularioGestionDeCuentasValidadasPage.BOTON_LEGALIZAR_CUENTA));
		actor.attemptsTo(Click.on(RipsValidacionCuentaPage.CONFIRMAR_SI));
		
	}
	
	public static LegarlizarCta enLaOpcion() {
		return Tasks.instrumented(LegarlizarCta.class );
	}

}
