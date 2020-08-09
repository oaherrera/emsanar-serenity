package com.conexia.qa.emssanar.tasks;

import static net.serenitybdd.core.Serenity.takeScreenshot;

import org.openqa.selenium.Keys;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.user_interfaces.ListasDeTrabajoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ConsultoCuentaEnListasDeTrabajo implements Task {
	
	String nroCuenta;
	
	public ConsultoCuentaEnListasDeTrabajo(String nroCuenta) {
		
		this.nroCuenta = nroCuenta;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		actor.attemptsTo(Enter.theValue(nroCuenta).into(ListasDeTrabajoPage.INPUT_NUMERO_DE_CUENTA).thenHit(Keys.ENTER));
		takeScreenshot();
		
		//actor.attemptsTo(Click.on(ListasDeTrabajoPage.BOTON_BUSCAR));
		takeScreenshot();
		actor.attemptsTo(Esperar.por(2000));
		
	}
	
	public static ConsultoCuentaEnListasDeTrabajo conCuenta(String nroCuenta) {
		
		return Tasks.instrumented(ConsultoCuentaEnListasDeTrabajo.class, nroCuenta);
	}

}
