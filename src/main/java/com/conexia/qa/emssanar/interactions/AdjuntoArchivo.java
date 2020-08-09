package com.conexia.qa.emssanar.interactions;

import static com.conexia.qa.emssanar.user_interfaces.CommonPage.ADJUNTAR_ARCHIVO;

import org.openqa.selenium.WebElement;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class AdjuntoArchivo implements Interaction{

	private String ruta;
	private Target alCampo;
	
	
	public AdjuntoArchivo(String ruta, Target alCampo) {
		this.ruta = ruta;
		if(alCampo!=null) {
			this.alCampo = alCampo;
		}
		else {
			this.alCampo = ADJUNTAR_ARCHIVO;
		}
	}

	@Override
	@Step("{0} adjunto archivo en la #ruta")
	public <T extends Actor> void performAs(T actor) {
		WebElement ElementoWeb = this.alCampo.resolveFor(actor);
		ElementoWeb.sendKeys(ruta);
		actor.attemptsTo(EsperarCargando.pagina(),EsperarCargandoArchivo.enElFormulario());
		
	}
	
	public static AdjuntoArchivo con(String ruta, Target alCampo) {
		return Tasks.instrumented(AdjuntoArchivo.class, ruta, alCampo);
		
	}

}
