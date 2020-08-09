package com.conexia.qa.emssanar.interactions;

import static com.conexia.qa.emssanar.user_interfaces.ResultadoGestionDeCuentasValidadasPage.ESTADO;
import static com.conexia.qa.emssanar.user_interfaces.ResultadoGestionDeCuentasValidadasPage.NUMERO_CUENTA;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class ValidoEstadoCuenta implements Question<Boolean> {

	private String estado;
	private String nroCuenta;

	public ValidoEstadoCuenta(String estado, String nroCuenta) {
		this.estado = estado;
		this.nroCuenta = nroCuenta;
	}

	@Override
	@Step("{0} se valida el estado de la cuenta")
	public Boolean answeredBy(Actor actor) {
		takeScreenshot();
		 if(!NUMERO_CUENTA.of(nroCuenta).resolveFor(actor).isVisible()) {
			 takeScreenshot();
			 System.out.println("Numero cuenta");
			 return false;
		 }else if(!ESTADO.of(estado).resolveFor(actor).isVisible()) {
			 takeScreenshot();
			 System.out.println("Estado");
			 return false;
		 }
		 takeScreenshot();
		return true;
	}

	public static ValidoEstadoCuenta en(String estado, String nroCuenta) {

		return new ValidoEstadoCuenta(estado, nroCuenta);
	}
}
