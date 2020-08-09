package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.user_interfaces.LoginPage.CONTRASEÑA;
import static com.conexia.qa.emssanar.user_interfaces.LoginPage.INICIAR_SESION;
import static com.conexia.qa.emssanar.user_interfaces.LoginPage.NOMBRE_USUARIO;
import static net.serenitybdd.core.Serenity.takeScreenshot;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class Loguearse implements Task {

	private String usuario;
	private String contrasena;

	public Loguearse(String usuario, String contrasena) {
		this.usuario = usuario;
		this.contrasena = contrasena;
	}

	@Override
	@Step("{0} Loguearse en la aolicación con #usuario y #contrasena")
	public <T extends Actor> void performAs(T actor) {
		Serenity.takeScreenshot();
		actor.attemptsTo(
				Enter.theValue(usuario).into(NOMBRE_USUARIO),
				Enter.theValue(contrasena).into(CONTRASEÑA)
						);
		Serenity.takeScreenshot();
		actor.attemptsTo(Click.on(INICIAR_SESION));
		Serenity.takeScreenshot();
	}

	public static Loguearse enElPortal(String usuario, String contrasena) {
		return Tasks.instrumented(Loguearse.class, usuario, contrasena);
	}
}
