package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.interactions.AtributosElemento.setiarAtributo;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BARRA_SCROLL_HORIZONTAL;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.BOTON_AGREGAR_MEDICAMENTO;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.MEDICAMENTO_POR_CODIGO_EMSSANAR;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionPage.TABLA_ENCABEZADO;
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

public class AgregarMedicamentos implements Task{
	
	
	public String codigo;
	public String descripcionMed;
	public String atcMedicamento;
	public String accionEscogida;
	public String valorNegociado;
	
	public AgregarMedicamentos(String codigo,String descripcionMed, String atcMedicamento ,String accionEscogida,String valorNegoiado) {
		this.codigo = codigo;
		this.descripcionMed = descripcionMed;
		this.atcMedicamento = atcMedicamento;
		this.accionEscogida = accionEscogida;
		this.valorNegociado = valorNegoiado;
	}
	



	@Override
	@Step("{0} agrega el medicamento")
	public <T extends Actor> void performAs(T actor) {
		
		switch (accionEscogida) {
		case "codigo":
			actor.attemptsTo(Enter.theValue(codigo).into(MEDICAMENTO_POR_CODIGO_EMSSANAR));
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
//			actor.attemptsTo(Swipe.vertical(500));
//			takeScreenshot();
//			actor.attemptsTo(Esperar.por(5000));
//			actor.attemptsTo(setiarAtributo(BARRA_SCROLL_HORIZONTAL, "value", "331,0"));
//			actor.attemptsTo(Click.on(NegociacionPage.CHECK_VALOR_NEGOCIADO));
//			takeScreenshot();
//			actor.attemptsTo(Enter.theValue(valorNegociado).into(NegociacionPage.INPUT_VALOR_NEGOCIADO));
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
			actor.attemptsTo(Enter.theValue(descripcionMed).into(NegociacionPage.DESCRIPCION_MEDICAMENTO));
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
		
		case "ATC":
			actor.attemptsTo(Clear.field(NegociacionPage.DESCRIPCION_MEDICAMENTO));
			actor.attemptsTo(Enter.theValue(atcMedicamento).into(NegociacionPage.ATC_MEDICAMENTO));
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
	
	public static AgregarMedicamentos porCodigo(String codigo) {
		return Tasks.instrumented(AgregarMedicamentos.class, codigo,null,null, "codigo", "500");
	}
	
	public static AgregarMedicamentos porDescripcion(String descripcionMed) {
		return Tasks.instrumented(AgregarMedicamentos.class, null, descripcionMed,null, "descripcion",null);
	}
	
	public static AgregarMedicamentos porATC(String atcMedicamento) {
		return Tasks.instrumented(AgregarMedicamentos.class, null, null, atcMedicamento,"ATC",null);
	}
	
	

}
