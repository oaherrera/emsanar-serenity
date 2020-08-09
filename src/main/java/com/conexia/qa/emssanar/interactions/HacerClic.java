package com.conexia.qa.emssanar.interactions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.conexia.qa.emssanar.drivers.OwnWebDriver;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class HacerClic implements Interaction{

	private Target Elemento;
	
	
	
	public HacerClic(Target elemento) {
		Elemento = elemento;
	}

	@Override
	@Step("{0} hacer click en el elemento")
	public <T extends Actor> void performAs(T actor) {

		WebElement ElementoWeb = this.Elemento.resolveFor(actor);
		Actions Accion = new Actions(OwnWebDriver.getDriver());
		Accion.moveToElement(ElementoWeb).click().build().perform();;
	}
	
	public static HacerClic En (Target Elemento) {
		return Tasks.instrumented(HacerClic.class, Elemento);

		
	}

	
	
}

