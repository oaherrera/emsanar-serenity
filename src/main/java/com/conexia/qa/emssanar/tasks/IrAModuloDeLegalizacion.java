package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.emssanar.user_interfaces.MenuPage.DESPLEGAR_MENU;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.user_interfaces.CommonPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class IrAModuloDeLegalizacion implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(setiarAtributo(DESPLEGAR_MENU, "style", "display:block;"));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CommonPage.MENU_CONTRACTUAL));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CommonPage.MENU_LEGALIZACION), EsperarCargando.pagina());
		actor.attemptsTo(Esperar.por(1000));
		Serenity.takeScreenshot();

	}

	public static IrAModuloDeLegalizacion enElMenu() {

		return Tasks.instrumented(IrAModuloDeLegalizacion.class);
	}

}
