package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.emssanar.user_interfaces.MenuPage.DESPLEGAR_MENU;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.models.Selenium;
import com.conexia.qa.emssanar.user_interfaces.CommonPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class IrAModuloDeNegociacion implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(setiarAtributo(DESPLEGAR_MENU, "style", "display:block;"));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CommonPage.MENU_PRECONTRACTUAL));
		Serenity.takeScreenshot();
		if(Selenium.parameters().getProperty("url").equals("https://lazosuat.conexia.com.co:8443/wap/negociacion")) {
			actor.attemptsTo(Click.on(CommonPage.MENU_NEGOCIACION_UAT));
		}else {
			actor.attemptsTo(Click.on(CommonPage.MENU_NEGOCIACION));
		}
		
		actor.attemptsTo(Esperar.por(1000));
		Serenity.takeScreenshot();

	}
	
	public static IrAModuloDeNegociacion enElMenu() {
		
		return Tasks.instrumented(IrAModuloDeNegociacion.class);
	}

}
