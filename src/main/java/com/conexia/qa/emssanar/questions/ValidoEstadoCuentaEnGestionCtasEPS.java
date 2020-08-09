package com.conexia.qa.emssanar.questions;

import static com.conexia.qa.emssanar.user_interfaces.ResultadoGestionDeCuentasValidadasPage.ESTADO_GESTION_CUENTAS_EPS;
import static com.conexia.qa.emssanar.user_interfaces.ResultadoGestionDeCuentasValidadasPage.NUMERO_CUENTA;
import static net.serenitybdd.core.Serenity.takeScreenshot;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidoEstadoCuentaEnGestionCtasEPS implements Question<Boolean> {

	private String nroCuenta;
	private String estado;

	public ValidoEstadoCuentaEnGestionCtasEPS(String nroCuenta, String estado) {
		this.nroCuenta = nroCuenta;
		this.estado = estado;
	}

	@Override
	public Boolean answeredBy(Actor actor) {

		takeScreenshot();
		if (!NUMERO_CUENTA.of(nroCuenta).resolveFor(actor).isVisible()) {
			takeScreenshot();
			System.out.println("Numero cuenta");
			return false;
		} else if (!ESTADO_GESTION_CUENTAS_EPS.of(estado).resolveFor(actor).isVisible()) {
			takeScreenshot();
			System.out.println("Estado");
			return false;
		}
		takeScreenshot();
		return true;
	}

	public static ValidoEstadoCuentaEnGestionCtasEPS en(String nroCuenta, String estado) {

		return new ValidoEstadoCuentaEnGestionCtasEPS(nroCuenta, estado);
	}
}
