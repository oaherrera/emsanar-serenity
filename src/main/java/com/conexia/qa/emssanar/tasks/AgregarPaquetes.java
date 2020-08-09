package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BOTON_AGREGAR_MEDICAMENTO;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.MEDICAMENTO_POR_CODIGO_EMSSANAR;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.TAB_PROCEDIMIENTOS;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.interactions.Swipe;
import com.conexia.qa.emssanar.user_interfaces.NegociacionPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class AgregarPaquetes implements Task {
	
	public String porCodigoPaquete;
	public String porDescripcionpaquete;
	public String porCodigoIPSPaquete;
	public String accionEscogida;
	public String valorNegociado;
	
	public AgregarPaquetes(String porCodigoPaquete,String porDescripcionpaquete, String porCodigoIPSPaquete, String accionEscogida) {
		
		this.porCodigoPaquete = porCodigoPaquete;
		this.porDescripcionpaquete = porDescripcionpaquete;
		this.porCodigoIPSPaquete = porCodigoIPSPaquete;
		this.accionEscogida = accionEscogida;
		this.valorNegociado = "600";
	}
	

	@Override
	@Step("{0} agrega procedimientos")
	public <T extends Actor> void performAs(T actor) {
		switch (accionEscogida) {
		case "codigo":
			actor.attemptsTo(Click.on(NegociacionPage.TAB_PAQUETES));
			actor.attemptsTo(Enter.theValue(porCodigoPaquete).into(NegociacionPage.CODIGO_PAQUETE));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.BOTON_AGREGAR_PAQUETE));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.SELECCIONAR_SEDE));
			actor.attemptsTo(Esperar.por(1000));
			actor.attemptsTo(Click.on(NegociacionPage.CHECK_SELECCIONAR_SEDE));
			actor.attemptsTo(Esperar.por(1000));
			actor.attemptsTo(Click.on(NegociacionPage.SELECCIONAR_TODOS_EN_PAQUETES));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.AGREGAR_PAQUETE));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Swipe.vertical(500));
			takeScreenshot();
//			actor.attemptsTo(Esperar.por(5000));
//			//actor.attemptsTo(setiarAtributo(BARRA_SCROLL_HORIZONTAL, "value", "331,0"));
//			actor.attemptsTo(Click.on(NegociacionPage.CHECK_VALOR_NEGOCIADO));
//			takeScreenshot();
			actor.attemptsTo(Enter.theValue(valorNegociado).into(NegociacionPage.INPUT_VALOR_NEGOCIADO));
//			takeScreenshot();
//			actor.attemptsTo(Click.on(NegociacionPage.BOTON_TERMINAR_ASIGNACION),EsperarCargando.pagina());
//			takeScreenshot();
//			actor.attemptsTo(Esperar.por(2000));
//			takeScreenshot();
//			actor.attemptsTo(Click.on(NegociacionPage.TIPO_TECNOLOGIA));
//			takeScreenshot();
//			actor.attemptsTo(Esperar.por(2000));
//			takeScreenshot();
//			actor.attemptsTo(Click.on(NegociacionPage.TIPO_TECNOLOGIA_SELECCION));
//			actor.attemptsTo(Esperar.por(2000));
//			takeScreenshot();
//			actor.attemptsTo(Click.on(NegociacionPage.DATO_REFERENCIA));
//			actor.attemptsTo(Click.on(NegociacionPage.DATO_REFERENCIA_SELECCION));
//			takeScreenshot();
//			actor.attemptsTo(Click.on(NegociacionPage.BOTON_ACEPTAR_TARIFARIO));
//			takeScreenshot();
//			actor.attemptsTo(Click.on(NegociacionPage.BOTON_OMITIR));
//			actor.attemptsTo(Click.on(NegociacionPage.BOTON_CONFIRMAR_SI));
//			takeScreenshot();
//			actor.attemptsTo(Esperar.por(2000));
			
			break;
		case "descripcion":
			actor.attemptsTo(Clear.field(NegociacionPage.MEDICAMENTO_POR_CODIGO_EMSSANAR));
			actor.attemptsTo(Esperar.por(2000));
			actor.attemptsTo(Enter.theValue(porDescripcionpaquete).into(NegociacionPage.DESCRIPCION_MEDICAMENTO));
			takeScreenshot();
			actor.attemptsTo(Click.on(BOTON_AGREGAR_MEDICAMENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.SELECCIONAR_TODOS_LOS_MEDICAMENTOS));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.AGREGAR_MEDICAMENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			break;
		
		case "codigoIPS":
			actor.attemptsTo(Clear.field(NegociacionPage.DESCRIPCION_MEDICAMENTO));
			actor.attemptsTo(Enter.theValue(porCodigoIPSPaquete).into(NegociacionPage.ATC_MEDICAMENTO));
			takeScreenshot();
			actor.attemptsTo(Click.on(BOTON_AGREGAR_MEDICAMENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.SELECCIONAR_TODOS_LOS_MEDICAMENTOS));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
			actor.attemptsTo(Click.on(NegociacionPage.AGREGAR_MEDICAMENTO));
			actor.attemptsTo(Esperar.por(2000));
			takeScreenshot();
		
			break;
		}
		
	}
	
	public static AgregarPaquetes porCodigo(String codigo) {
		return Tasks.instrumented(AgregarPaquetes.class, codigo,null,null, "codigo");
	}
	
	public static AgregarPaquetes porDescripcion(String descripcionMed) {
		return Tasks.instrumented(AgregarPaquetes.class, null, descripcionMed,null, "descripcion",null);
	}
	
	public static AgregarPaquetes porATC(String atcMedicamento) {
		return Tasks.instrumented(AgregarPaquetes.class, null, null, atcMedicamento,"ATC",null);
	}
	
	
	

}
