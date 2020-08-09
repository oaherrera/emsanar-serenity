package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.ConfirmarDerechosPage.BOTON_ACEPTAR;
import static com.conexia.qa.emssanar.user_interfaces.ConfirmarDerechosPage.BOTON_BUSCAR;
import static com.conexia.qa.emssanar.user_interfaces.ConfirmarDerechosPage.INPUT_NUMERO_DOCUMENTO;
import static com.conexia.qa.emssanar.user_interfaces.ConfirmarDerechosPage.SELECT_TIPO_DOCUMENTO;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.tasks.BuscarAfiliado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class BuscarAfiliado implements Task{
	
	
	private String TipoDocumento;
	private String NroDocumento;

	public BuscarAfiliado(String tipoDocumento, String nroDocumento) {
		this.TipoDocumento = tipoDocumento;
		this.NroDocumento = nroDocumento;
	}
	
	

	@Override
	@Step("{0} busca al afiliado identificado con #TipoDocumento y #NroDocumento ")
	public <T extends Actor> void performAs(T actor) {
		takeScreenshot();
		
		actor.attemptsTo(SelectFromOptions.byVisibleText(TipoDocumento).from(SELECT_TIPO_DOCUMENTO));
		actor.attemptsTo(Enter.theValue(NroDocumento).into(INPUT_NUMERO_DOCUMENTO));
		actor.attemptsTo(Esperar.por(2000));
		takeScreenshot();
		actor.attemptsTo(Click.on(BOTON_BUSCAR));
		actor.attemptsTo(EsperarCargando.pagina());
		takeScreenshot();
		actor.attemptsTo(Click.on(BOTON_ACEPTAR));
		actor.attemptsTo(EsperarCargando.pagina());
		takeScreenshot();
		
	}
	
	public static BuscarAfiliado porTipoidentificacion(String tipoDocumento, String nroDocumento) {
		return Tasks.instrumented(BuscarAfiliado.class, tipoDocumento, nroDocumento);
	}
	
	

}
