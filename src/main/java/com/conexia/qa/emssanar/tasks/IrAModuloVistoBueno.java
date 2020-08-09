package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.emssanar.user_interfaces.CommonPage.MENU_CONTRACTUAL;
import static com.conexia.qa.emssanar.user_interfaces.LegalizacionOtroSiPage.*;
import static com.conexia.qa.emssanar.user_interfaces.MenuPage.DESPLEGAR_MENU;
import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.interactions.Swipe;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class IrAModuloVistoBueno implements Task{
	
	private String responsable;
	
	public IrAModuloVistoBueno(String responsable) {
		this.responsable = responsable;
		
	}

	@Override
	@Step("{0} Ingreso al modulo de visto bueno")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(setiarAtributo(DESPLEGAR_MENU, "style", "display:block;"));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(MENU_CONTRACTUAL));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(MENU_VISTO_BUENO), EsperarCargando.pagina());
		actor.attemptsTo(Esperar.por(2000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ACCIONES_VISTO_BUENO));
		actor.attemptsTo(Swipe.vertical(200));
		actor.attemptsTo(Click.on(RESPONSABLE_VISTO_BUENO));
		actor.attemptsTo(Esperar.por(2000));
		actor.attemptsTo(Click.on(SELECCION_RESPONSABLE_VISTO_BUENO.of(responsable)));
		actor.attemptsTo(Click.on(GUARDAR_VISTO_BUENO), EsperarCargando.pagina());
		actor.attemptsTo(Esperar.por(3000));


	}
	
	public static IrAModuloVistoBueno yDiligenciar(String responsable) {
		return Tasks.instrumented(IrAModuloVistoBueno.class, responsable);
	}

}
