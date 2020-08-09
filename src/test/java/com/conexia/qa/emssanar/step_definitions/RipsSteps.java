package com.conexia.qa.emssanar.step_definitions;

import static com.conexia.qa.emssanar.models.InformacionValidarRips.guardarInformacion;
import static com.conexia.qa.emssanar.models.InformacionValidarRips.limpiarInformacionValidarRipsData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.emssanar.drivers.OwnWebDriver;
import com.conexia.qa.emssanar.interactions.AbrirOpcion;
import com.conexia.qa.emssanar.interactions.AdjuntoArchivo;
import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.models.InformacionValidarRips;
import com.conexia.qa.emssanar.questions.ValidoEstadoCuenta;
import com.conexia.qa.emssanar.questions.ValidoEstadoCuentaEnGestionCtasEPS;
import com.conexia.qa.emssanar.questions.ValidoEstadoCuentaEnListasDeTrabajo;
import com.conexia.qa.emssanar.tasks.BuscarAfiliado;
import com.conexia.qa.emssanar.tasks.ConsultoCuentaEnListasDeTrabajo;
import com.conexia.qa.emssanar.tasks.ConsultoEstadoCuenta;
import com.conexia.qa.emssanar.tasks.ConsultoEstadoCuentaGestionCuentasEPS;
import com.conexia.qa.emssanar.tasks.DiligencioFormularioValidacionCuentaRips;
import com.conexia.qa.emssanar.tasks.EnviarAHomologar;
import com.conexia.qa.emssanar.tasks.EnvioLaCargaRips;
import com.conexia.qa.emssanar.tasks.EpsRadicaCuenta;
import com.conexia.qa.emssanar.tasks.GestionoLaCuenta;
import com.conexia.qa.emssanar.tasks.GestionoLaCuentaComoEps;
import com.conexia.qa.emssanar.tasks.IrAModuloDeNegociacion;
import com.conexia.qa.emssanar.tasks.LegarlizarCta;
import com.conexia.qa.emssanar.tasks.RealizaElLogueo;
import com.conexia.qa.emssanar.tasks.RealizaElLogueoParaValidarCta;
import com.conexia.qa.emssanar.tasks.marcoLaCuenta;
import com.conexia.qa.emssanar.models.Selenium;
import com.conexia.qa.emssanar.tasks.Loguearse;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;

public class RipsSteps {

	@Given("^me autentico con (.+) y contraseña (.+)$")
	public void meAutenticoConUsuarioYContraseña(String usuario, String contrasena) {
		setTheStage(Cast.ofStandardActors());
		theActorCalled(usuario);
		theActorInTheSpotlight()
				.can(BrowseTheWeb.with(OwnWebDriver.withChrome().setURL(Selenium.parameters().getProperty("url"))));
		theActorInTheSpotlight().attemptsTo(Loguearse.enElPortal(usuario, contrasena));
	}

	@When("^Ingreso al modulo de negociacion$")
	public void ingresoAlModuloDeNegociacion() {
		theActorInTheSpotlight().attemptsTo(IrAModuloDeNegociacion.enElMenu());
	}

	@Given("^Ingreso al modulo de (.+), a (.+)$")
	public void ingresoAlModuloA(String modulo, String accionSubmoudlo) {
		theActorInTheSpotlight().attemptsTo(AbrirOpcion.delMenu(modulo, accionSubmoudlo));
	}

	@And("^Ingreso al logueo de la ips (.+)$")
	public void IngresoAlLogueoDeLaIps(String ips) {
		theActorInTheSpotlight().attemptsTo(RealizaElLogueo.deIps(ips));
	}

	@When("^Diligencio el formulario de Cargue y Vaidación de Rips$")
	public void diligencioElFormularioDeCargueYValidacionRips(List<InformacionValidarRips> InformacionValidarRipsData) {
		limpiarInformacionValidarRipsData();
		guardarInformacion(InformacionValidarRipsData.get(0));
		theActorInTheSpotlight().attemptsTo(DiligencioFormularioValidacionCuentaRips.conTodosLosDatos());
	}

	@And("^Adjunto el o los archivos de Rips y los Cargo$")
	public void adjuntoElOLosArchivosDeRipsYLosCargo(List<String> archivos) {
		System.out.println(archivos.get(1));
		int indice = 1;
		while (indice < archivos.size()) {
			theActorInTheSpotlight().attemptsTo(AdjuntoArchivo.con(archivos.get(indice), null));
			indice += 1;
		}
		theActorInTheSpotlight().attemptsTo(EnvioLaCargaRips.paraGenerarCuentaValidada());
	}

	@And("^para Ingreso al logueo de la ips (.+) para validar la cuenta$")
	public void paraIngresoAlLogueoDeLaIpsParaValidarLaCuenta(String ips) {
		theActorInTheSpotlight().attemptsTo(RealizaElLogueoParaValidarCta.deIps(ips));

	}

	@And("^Consulto el estado de la cuenta (.+) gestionada para la ips$")
	public void consultoElEstadoDelaCuentaGestionada(String nroCuenta) {
		theActorInTheSpotlight().attemptsTo(ConsultoEstadoCuenta.conLaCuentaDeLaIps(nroCuenta));
	}

	@And("^Consulto el estado de la cuenta (.+) gestionada para la ips en gestion cuentas EPS$")
	public void consultoElEstadoDeLaCuentaGestionadaParaLaIpsEnGestionCuentasEPS(String nroCuenta) {
		theActorInTheSpotlight().attemptsTo(ConsultoEstadoCuentaGestionCuentasEPS.conLaCuentaDeLaIps(nroCuenta));
	}

	@And("^Consulto el estado de la cuenta (.+) en listas de trabajo$")
	public void onsultoElEstadoDeLaCuentaEnListasDeTrabajo(String nroCuenta) {
		theActorInTheSpotlight().attemptsTo(ConsultoCuentaEnListasDeTrabajo.conCuenta(nroCuenta));
	}

	@And("^La cuenta se encuentra en estado$")
	public void laCuentaSeEncuentraEnEstado(List<String> cuentaEstado) {
		String cuenta = cuentaEstado.get(2);
		String estado = cuentaEstado.get(3);
		theActorInTheSpotlight().should(seeThat(ValidoEstadoCuenta.en(estado, cuenta)));
		theActorInTheSpotlight().attemptsTo(Esperar.por(2000));
	}

	@And("^se valida el estado de la cuenta en gestion de cuentas EPS$")
	public void seValidaElEstadoDeLaCuentaEnGestionDeCuentasEPS(List<String> cuentaEstado) {
		String cuenta = cuentaEstado.get(2);
		String estado = cuentaEstado.get(3);
		theActorInTheSpotlight().should(seeThat(ValidoEstadoCuentaEnGestionCtasEPS.en(cuenta, estado)));
		theActorInTheSpotlight().attemptsTo(Esperar.por(2000));
	}

	@And("^envio al proceso de homologacion$")
	public void envioAlProcesoDeHomologacion() {
		theActorInTheSpotlight().attemptsTo(EnviarAHomologar.cuenta());
	}

	@And("^legalizo la cuenta$")
	public void legalizoLaCuenta() {
		theActorInTheSpotlight().attemptsTo(LegarlizarCta.enLaOpcion());
	}

	@And("^Gestiono la encuenta, (.+)$")
	public void gestionoLaCuenta(String accionSobreLaCuenta) {
		theActorInTheSpotlight().attemptsTo(GestionoLaCuenta.realizandoLaAccion(accionSobreLaCuenta));
	}

	@And("^la cuenta debe cambiar al siguiente estado$")
	public void laCuentaDebeCambiarAlSiguienteEstado(List<String> datos) {
		String cuenta = datos.get(2);
		String estado = datos.get(3);
		theActorInTheSpotlight().should(seeThat(ValidoEstadoCuentaEnListasDeTrabajo.con(cuenta, estado)));
		theActorInTheSpotlight().attemptsTo(Esperar.por(2000));
	}

	@And("^Gestiono la encuenta como Eps, (.+)$")
	public void gestionoLaCuentaComoEps(String accionSobreLaCuenta) {
		theActorInTheSpotlight().attemptsTo(GestionoLaCuentaComoEps.realizandoLaAccion(accionSobreLaCuenta));
	}

	@And("^Marco la cuenta con todas las Facturas como Revisado$")
	public void MarcoLaCuentaConFacturasComoRevisado() {
		theActorInTheSpotlight().attemptsTo(marcoLaCuenta.comoRevisada());
	}

	@And("^Radico la cuenta con la Eps$")
	public void radicoLaCuentaConLaEps(List<String> radicar) {
		String regional = radicar.get(4);
		String claseDeServicio = radicar.get(5);
		String responsableDePago = radicar.get(6);
		String observaciones = radicar.get(7);

		theActorInTheSpotlight()
				.attemptsTo(EpsRadicaCuenta.conLosDatos(regional, claseDeServicio, responsableDePago, observaciones));
	}

	@Given("^Consulto afiliado con (.+) Nro (.+) en Autorizaciones$")
	public void consultoAfiliadoConTipoDocumentoNro(String tipoDocumento, String numeroDocumento) {
		theActorInTheSpotlight().attemptsTo(BuscarAfiliado.porTipoidentificacion(tipoDocumento, numeroDocumento));
	}

}
