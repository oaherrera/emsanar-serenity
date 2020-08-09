package com.conexia.qa.emssanar.step_definitions;

import static com.conexia.qa.emssanar.models.NegociacionPrestador.guardarNegociacionPrestador;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import java.util.List;
import com.conexia.qa.emssanar.models.NegociacionPrestador;
import com.conexia.qa.emssanar.questions.MensajeTemporal;
import com.conexia.qa.emssanar.questions.ValidoEstadoDeNegociacin;
import com.conexia.qa.emssanar.tasks.BuscoLaNegociacion;
import com.conexia.qa.emssanar.tasks.BuscoNegociacionEnLegalizacion;
import com.conexia.qa.emssanar.tasks.DiligencioDatos;
import com.conexia.qa.emssanar.tasks.FiltroNegociacion;
import com.conexia.qa.emssanar.tasks.GenerarOtroSi;
import com.conexia.qa.emssanar.tasks.IrAModuloDeLegalizacion;
import com.conexia.qa.emssanar.tasks.IrAModuloVistoBueno;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OtroSiSteps {

	@When("^busco una negociacion$")
	public void buscoUnaNegociacion(List<NegociacionPrestador> datosNegociacion) {
		guardarNegociacionPrestador(datosNegociacion.get(0));
		theActorInTheSpotlight().attemptsTo(
				BuscoLaNegociacion.porNumero(NegociacionPrestador.traerNegociacionPrestador().getNumeroNegociacion()));
		theActorInTheSpotlight().attemptsTo(BuscoLaNegociacion.parairA());
	}

	@And("^filtro por numero de negociacion$")
	public void filtroPorNumeroDeNegociacion(List<NegociacionPrestador> datosNegociacion) {
		guardarNegociacionPrestador(datosNegociacion.get(0));
		theActorInTheSpotlight().attemptsTo(
				FiltroNegociacion.porNumero(NegociacionPrestador.traerNegociacionPrestador().getNumeroNegociacion(),
						NegociacionPrestador.traerNegociacionPrestador().getMesAnio(),
						NegociacionPrestador.traerNegociacionPrestador().getDiadelMes()));
	}

	@And("^ingreso a crear otroSi$")
	public void ingresoACrearOtroSi(List<NegociacionPrestador> datosNegociacion) {
		guardarNegociacionPrestador(datosNegociacion.get(0));
		theActorInTheSpotlight()
				.attemptsTo(GenerarOtroSi.conDatos(NegociacionPrestador.traerNegociacionPrestador().getMesAnio(),
						NegociacionPrestador.traerNegociacionPrestador().getDiadelMes()));
	}

	@And("^ingreso al modulo de legalizacion$")
	public void ingresoAlModuloDeLegalizacion() {
		theActorInTheSpotlight().attemptsTo(IrAModuloDeLegalizacion.enElMenu());
	}
	
	@And("^busco la negociacion en legalizacion$")
	public void buscoLaNegociacion(List<NegociacionPrestador> datosNegociacion) {
		guardarNegociacionPrestador(datosNegociacion.get(0));
		theActorInTheSpotlight().attemptsTo(BuscoNegociacionEnLegalizacion.conNumero(NegociacionPrestador.traerNegociacionPrestador().getNumeroNegociacion()));
	}
	
	@And("^valido el estado de la negociacion$")
	public void validoElEstadoDeLaNegociacion() {
		theActorInTheSpotlight().should(seeThat(ValidoEstadoDeNegociacin.conEstado("Pendiente legalización")));

	}
	
	@And("^diligencio datos del contrato$")
	public void diligencioDatosDelContrato(List<NegociacionPrestador> datosNegociacion) {
		guardarNegociacionPrestador(datosNegociacion.get(0));
		theActorInTheSpotlight().attemptsTo(DiligencioDatos.delContrato(NegociacionPrestador.traerNegociacionPrestador().getCorreo(),
				NegociacionPrestador.traerNegociacionPrestador().getNivelAtencion()));
	}
	
	@Then("^se debe mostrar el mensaje de guardado correctamente$")
	public void seDebeMostrarElMensajeDeGuardadoCorrectamente() {
		theActorInTheSpotlight()
		.should(seeThat(MensajeTemporal.es(), containsString("Se guardo correctamente la legalización del contrato ahora puede descargarla y asignar el visto bueno")));
	}
	
	@And("^diligencio el visto bueno$")
	public void diligencioElVistoBueno(List<NegociacionPrestador> datosNegociacion) {
		guardarNegociacionPrestador(datosNegociacion.get(0));
		theActorInTheSpotlight().attemptsTo(IrAModuloVistoBueno.yDiligenciar(NegociacionPrestador.traerNegociacionPrestador().getResponsable()));
	}
	
	@Then("^se visualizan los mensajes de tramite exitoso$")
	public void seVisualizanLosMensajesDeTramiteExitoso() {
		theActorInTheSpotlight()
		.should(seeThat(MensajeTemporal.es(), containsString("Se asigno correctamente la firma del visto bueno al contrato.")));
	}

}
