package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.LogueoIpsPage.BOTON_INGRESAR;
import static com.conexia.qa.emssanar.user_interfaces.LogueoIpsPage.BUSCAR_POR_RAZON_SOCIAL;
import static com.conexia.qa.emssanar.user_interfaces.LogueoIpsPage.VALIDAR_RIPS;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import org.openqa.selenium.support.ui.Sleeper;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.Sleep;
import com.conexia.qa.emssanar.user_interfaces.LogueoIpsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class RealizaElLogueoParaValidarCta implements Task{
	
private String ips;
	
	public RealizaElLogueoParaValidarCta(String ips) {
		
		this.ips = ips;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(BUSCAR_POR_RAZON_SOCIAL));
		actor.attemptsTo(Enter.theValue(ips).into(LogueoIpsPage.INPUT_RAZON_SOCIAL));
		actor.attemptsTo(Click.on(LogueoIpsPage.RAZON_SOCIAL_SELECCION.of(ips)));
		takeScreenshot();
		actor.attemptsTo(Click.on(BOTON_INGRESAR));
		Sleep.by(2000);
		takeScreenshot();
		
		
	}
	
	public static RealizaElLogueoParaValidarCta deIps(String ips) {
		
		return Tasks.instrumented(RealizaElLogueoParaValidarCta.class, ips );
	}

}
