package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.AREA_DE_COBERTURA;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.AREA_DE_COBERTURA_SELECCION;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.ASIGNAR_AREAS_COBERTURA;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BOTON_GUARDAR;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BOTON_REPLICAR_AREA;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BOTON_SIGUIENTE;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BOTON_TERMINAR;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.CERRAR_TABLA_DE_ASIGNAR_MUNICIPIOS;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.CONFIRMACION_SI_SEDES;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.DISTRIBUIR_POBLACION;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.MARCAR_TODOS_MUNICIPIOS;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.NEGOCIAR_TODAS_LAS_SEDES;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.POP_UP_EMERGENTE;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.SEDE_PRINCIPAL;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.SEDE_PRINCIPAL_SELECCION;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.SELECCIONAR_REGISTRO;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.interactions.Swipe;
import com.conexia.qa.emssanar.user_interfaces.NegociacionPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;


public class DiligencioNegociacionSimple implements Task {
	
	private String areaCobertura;
	private String sedePrincipal;
	
	
	public DiligencioNegociacionSimple(String areaCobertura, String sedePrincipal ) {
		this.areaCobertura = areaCobertura;
		this.sedePrincipal = sedePrincipal;
		
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(AREA_DE_COBERTURA));
		actor.attemptsTo(Click.on(AREA_DE_COBERTURA_SELECCION.of(areaCobertura)));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(BOTON_GUARDAR));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(SELECCIONAR_REGISTRO));
		actor.attemptsTo(Esperar.por(2000));
		actor.attemptsTo(Click.on(ASIGNAR_AREAS_COBERTURA));
		actor.attemptsTo(Esperar.por(2000));
		actor.attemptsTo(Click.on(MARCAR_TODOS_MUNICIPIOS));
		actor.attemptsTo(Click.on(BOTON_REPLICAR_AREA));
		actor.attemptsTo(Esperar.por(2000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CONFIRMACION_SI_SEDES));
		actor.attemptsTo(setiarAtributo(POP_UP_EMERGENTE, "style", "display:block;"));
		actor.attemptsTo(Esperar.por(2000));
		actor.attemptsTo(Click.on(POP_UP_EMERGENTE));
		actor.attemptsTo(Esperar.por(2000));
		actor.attemptsTo(Click.on(CERRAR_TABLA_DE_ASIGNAR_MUNICIPIOS));
		actor.attemptsTo(Esperar.por(2000));
		actor.attemptsTo(Swipe.vertical(1000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Esperar.por(1000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(SEDE_PRINCIPAL));
		actor.attemptsTo(Click.on(SEDE_PRINCIPAL_SELECCION.of(sedePrincipal)));
		actor.attemptsTo(Esperar.por(1000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(DISTRIBUIR_POBLACION));
		actor.attemptsTo(Click.on(BOTON_SIGUIENTE));
		actor.attemptsTo(Esperar.por(1000));
		actor.attemptsTo(Click.on(NEGOCIAR_TODAS_LAS_SEDES));
		actor.attemptsTo(Click.on(NegociacionPage.BOTON_SIGUIENTE2));
		actor.attemptsTo(Esperar.por(1000));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(NegociacionPage.BOTON_TERMINAR_NEG_SIMPLE),EsperarCargando.pagina());
		Serenity.takeScreenshot();
	
		
		
		
		
		
	}
	
	public static DiligencioNegociacionSimple conDatos(String areaCobertura, String sedePrincipal) {
		
		return Tasks.instrumented(DiligencioNegociacionSimple.class, areaCobertura, sedePrincipal);
	}

}
