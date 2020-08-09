package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.LegalizacionOtroSiPage.*;
import org.openqa.selenium.Keys;
import com.conexia.qa.emssanar.interactions.Esperar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class BuscoNegociacionEnLegalizacion implements Task {
	
	private String numeroNegociacion;
	
	public BuscoNegociacionEnLegalizacion(String numeroNegociacion) {
		this.numeroNegociacion = numeroNegociacion;
	}

	@Override
	@Step("{0} Busco la Negociación en la parte de Legalización")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(numeroNegociacion)
				.into(NUMERO_DE_NEGOCIACION).thenHit(Keys.ENTER));
		actor.attemptsTo(Click.on(VER_SOLICITUDES_OTROSI));
		actor.attemptsTo(Esperar.por(3000));
		
	}
	
	public static BuscoNegociacionEnLegalizacion conNumero(String numeroNegociacion) {
		return Tasks.instrumented(BuscoNegociacionEnLegalizacion.class, numeroNegociacion);
	}

}
