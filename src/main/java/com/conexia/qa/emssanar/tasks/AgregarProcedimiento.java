package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BOTON_AGREGAR_PROCEDIMIENTO;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.CODIGO_PROCEDIMIENTO_EMSSANAR;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.TAB_PROCEDIMIENTOS;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.user_interfaces.NegociacionPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class AgregarProcedimiento implements Task {

	public String porCodigoProcedimiento;
	public String porDescripcionProc;
	public String accionEscogida;

	public AgregarProcedimiento(String porCodigoProcedimiento, String porDescripcionProc , String accionEscogida) {

		this.porCodigoProcedimiento = porCodigoProcedimiento;
		this.porDescripcionProc = porDescripcionProc;
		this.accionEscogida = accionEscogida;

	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		switch (accionEscogida) {
		case "codigo":
			actor.attemptsTo(Click.on(TAB_PROCEDIMIENTOS));
			actor.attemptsTo(Enter.theValue(porCodigoProcedimiento).into(NegociacionPage.CODIGO_PROCEDIMIENTO_EMSSANAR));
			takeScreenshot();
			actor.attemptsTo(Click.on(BOTON_AGREGAR_PROCEDIMIENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.SELECCIONAR_TODOS_LOS_PROCEDIMIENTOS));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.AGREGAR_PROCEDIMIENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			break;
		case "descripcion":
			actor.attemptsTo(Clear.field(NegociacionPage.CODIGO_PROCEDIMIENTO_EMSSANAR));
			actor.attemptsTo(Click.on(TAB_PROCEDIMIENTOS));
			actor.attemptsTo(Enter.theValue(porDescripcionProc).into(NegociacionPage.DESCRIPCION_PROCEDIMIENTO));
			takeScreenshot();
			actor.attemptsTo(Click.on(BOTON_AGREGAR_PROCEDIMIENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.SELECCIONAR_TODOS_LOS_PROCEDIMIENTOS));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.AGREGAR_PROCEDIMIENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			break;
		}

	}
	
	public static AgregarProcedimiento porCodigo(String codigo) {
		return Tasks.instrumented(AgregarProcedimiento.class, codigo,null, "codigo");
	}
	
	public static AgregarProcedimiento porDescripcion(String descripcion) {
		
		return Tasks.instrumented(AgregarProcedimiento.class, null, descripcion, "descripcion");
		
	}
	

}
