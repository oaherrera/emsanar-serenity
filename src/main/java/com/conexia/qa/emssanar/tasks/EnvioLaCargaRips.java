package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.RipsValidacionCuentaPage.ACEPTAR_PROCESO_CARGUE_TERMINADO;
import static com.conexia.qa.emssanar.user_interfaces.RipsValidacionCuentaPage.CARGAR_ARCHIVOS;
import static com.conexia.qa.emssanar.user_interfaces.RipsValidacionCuentaPage.CERRAR_INFORMACION_DE_VALIDACION;
import static com.conexia.qa.emssanar.user_interfaces.RipsValidacionCuentaPage.CONFIRMAR;
import static com.conexia.qa.emssanar.user_interfaces.RipsValidacionCuentaPage.CONFIRMAR_SI;

import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.interactions.MueveScroll;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class EnvioLaCargaRips implements Task{

	@Override
	@Step("{0} proceso de envío de los archivos cargados")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(MueveScroll.vertical(400));
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CARGAR_ARCHIVOS),EsperarCargando.pagina()); 
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CONFIRMAR_SI),EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(ACEPTAR_PROCESO_CARGUE_TERMINADO),EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CONFIRMAR),EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CONFIRMAR_SI),EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(CERRAR_INFORMACION_DE_VALIDACION),EsperarCargando.pagina());
		actor.attemptsTo(Esperar.por(2000));
		Serenity.takeScreenshot();
	}

	public static EnvioLaCargaRips paraGenerarCuentaValidada() {
		return Tasks.instrumented(EnvioLaCargaRips.class);
	}
}
