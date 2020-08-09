package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.NegociacionTecnologiasPage.BORRAR_TODOS_PROCEDIMIENTOS;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionTecnologiasPage.CONFIRMAR_ACEPTAR;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionTecnologiasPage.GESTIONAR_SERVICIOS;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionTecnologiasPage.SELECCIONAR_TODOS_PROCEDIMIENTOS;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionTecnologiasPage.TAB_PROCEDMIENTOS;
import static com.conexia.qa.emssanar.sql.modelos.NegociacionProcedimiento.traerNegociacionProcedimiento;

import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.interactions.MueveScroll;
import com.conexia.qa.emssanar.sql.tasks.ConsultoEnNegociacion;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class EliminoTecnologiasPrecargadas implements Task {

	private String numeroNegociacion;

	public EliminoTecnologiasPrecargadas(String numeroNegociacion) {
		this.numeroNegociacion = numeroNegociacion;
	}

	@Override
	@Step("{0} Elimina todos los servicios de la negociación #numeroNegociacion")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(ConsultoEnNegociacion.procedimientos(numeroNegociacion));
		actor.attemptsTo(Click.on(TAB_PROCEDMIENTOS));
		actor.attemptsTo(MueveScroll.vertical(200));
		Serenity.takeScreenshot();
		while (traerNegociacionProcedimiento().cantidadProcedimientos() > 0) {
			actor.attemptsTo(Click.on(GESTIONAR_SERVICIOS));
			actor.attemptsTo(Click.on(SELECCIONAR_TODOS_PROCEDIMIENTOS),EsperarCargando.pagina());
			actor.attemptsTo(Click.on(GESTIONAR_SERVICIOS));
			actor.attemptsTo(Click.on(BORRAR_TODOS_PROCEDIMIENTOS));
			actor.attemptsTo(Click.on(CONFIRMAR_ACEPTAR),EsperarCargando.pagina());
			actor.attemptsTo(ConsultoEnNegociacion.procedimientos(numeroNegociacion));
		}
		Serenity.takeScreenshot();

	}

	public static EliminoTecnologiasPrecargadas paraLaNegociacion(String numeroNegociacion) {
		return Tasks.instrumented(EliminoTecnologiasPrecargadas.class, numeroNegociacion);
	}

}
