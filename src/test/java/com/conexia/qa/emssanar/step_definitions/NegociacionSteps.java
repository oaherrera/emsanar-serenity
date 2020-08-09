package com.conexia.qa.emssanar.step_definitions;

import static com.conexia.qa.emssanar.models.NegociacionPrestador.guardarNegociacionPrestador;
import static com.conexia.qa.emssanar.models.NegociacionPrestador.limpioDatosNegociacionPrestador;
import static com.conexia.qa.emssanar.models.MensajeTemporal.traerMensaje;
import static com.conexia.qa.emssanar.models.NegociacionPrestador.traerNegociacionPrestador;
import static com.conexia.qa.emssanar.models.ImportarTecnologiasEvento.agregarTecnologias;
import static com.conexia.qa.emssanar.models.ImportarTecnologiasEvento.limpiarTecnologias;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import java.util.List;

import com.conexia.qa.emssanar.tasks.AgregarMedicamentos;
import com.conexia.qa.emssanar.tasks.AgregarPaquetes;
import com.conexia.qa.emssanar.tasks.AgregarProcedimiento;
import com.conexia.qa.emssanar.tasks.AreaDeCoberturaYSedePpal;
import com.conexia.qa.emssanar.tasks.BuscoAlPrestadorNegociacion;
import com.conexia.qa.emssanar.models.NegociacionPrestador;
import com.conexia.qa.emssanar.tasks.CreaLaBaseDeNegociacion;
import com.conexia.qa.emssanar.tasks.DiligencioNegociacionSimple;
import com.conexia.qa.emssanar.questions.MensajeTemporal;
import com.conexia.qa.emssanar.utilitarios.ExtraerExprexion;
import com.conexia.qa.emssanar.models.ImportarTecnologiasEvento;
import com.conexia.qa.emssanar.models.Insumos;
import com.conexia.qa.emssanar.tasks.EliminoTecnologiasPrecargadas;
import com.conexia.qa.emssanar.tasks.ImportoArchivoTecnologias;
import com.conexia.qa.emssanar.tasks.ConsultoNegociacion;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NegociacionSteps {

	@And("^Busco al prestador (.+) para (.+).$")
	public void buscoAlPrestadorPara(String nombreprestador, String realizarAccionAlBuscar) {
		theActorInTheSpotlight().attemptsTo(BuscoAlPrestadorNegociacion.porNombre(nombreprestador));
		theActorInTheSpotlight().attemptsTo(BuscoAlPrestadorNegociacion.para(realizarAccionAlBuscar));
	}

	@And("^Busco al prestador$")
	public void buscoAlPrestador() {
		theActorInTheSpotlight()
				.attemptsTo(BuscoAlPrestadorNegociacion.porNombre("ESE HOSPITAL SAN RAFAEL - LETICIA ( AMAZONAS )"));
		theActorInTheSpotlight().attemptsTo(BuscoAlPrestadorNegociacion.para("Ver Negociaciones"));
	}

	@And("^Creo la base negociacion$")
	public void creoLaBaseNegociacion(List<NegociacionPrestador> datosNegociacionPrestador) {
		limpioDatosNegociacionPrestador();
		guardarNegociacionPrestador(datosNegociacionPrestador.get(0));
		theActorInTheSpotlight().attemptsTo(CreaLaBaseDeNegociacion.conLosDatos());
	}

	@Then("^Negociación creada correctamente$")
	public void negociaciónCreadaCorrectamente() {
		theActorInTheSpotlight()
				.should(seeThat(MensajeTemporal.es(), containsString("Negociación creada correctamente")));
		traerNegociacionPrestador()
				.setNumeroNegociacion(ExtraerExprexion.deUnTexto(traerMensaje(), ".*, No (.*)", 1).trim());
	}

	@And("^Consulto negociacion nro (.+), para (.+)$")
	public void consultoNegociacionNumeroParaVerNegociacion(String nroNegociacion, String accionAlBuscar) {
		int numeroNegociacion = 0;
		if (traerNegociacionPrestador() == null) {
			numeroNegociacion = Integer.parseInt(nroNegociacion);
			NegociacionPrestador.guardarNegociacionPrestador(new NegociacionPrestador());
			traerNegociacionPrestador().setNumeroNegociacion(nroNegociacion);
		} else {
			numeroNegociacion = Integer.parseInt(traerNegociacionPrestador().getNumeroNegociacion());
		}
		theActorInTheSpotlight().attemptsTo(ConsultoNegociacion.porNumeroDeNegocacion("" + numeroNegociacion));
		theActorInTheSpotlight().attemptsTo(ConsultoNegociacion.para(accionAlBuscar));
	}

	@And("^Asigno area de cobertura sede principal y demas$")
	public void asignoAreaDeCoberturaSedePrincipalYDemas(List<String> datos) {
		String areacobertura = datos.get(3);
		String sede = datos.get(4);
		String numero = datos.get(5);
		theActorInTheSpotlight().attemptsTo(AreaDeCoberturaYSedePpal.conDatos(areacobertura, sede, numero));

	}

	@And("^Importo las tecnologias respectivas$")
	public void importoLasTecnologiasRespectivas(List<ImportarTecnologiasEvento> importarTecnologias) {
		theActorInTheSpotlight().attemptsTo(
				EliminoTecnologiasPrecargadas.paraLaNegociacion(traerNegociacionPrestador().getNumeroNegociacion()));
		limpiarTecnologias();
		agregarTecnologias(importarTecnologias);
		theActorInTheSpotlight().attemptsTo(ImportoArchivoTecnologias.conLosDatosDelModelo());
	}

	@And("^Importo las tecnologias respectivas de la negociacion$")
	public void importoLasTecnologiasRespectivasDeLaNegociacion(List<ImportarTecnologiasEvento> importarTecnologias) {
		// theActorInTheSpotlight().attemptsTo(
		// EliminoTecnologiasPrecargadas.paraLaNegociacion(traerNegociacionPrestador().getNumeroNegociacion()));
		// limpiarTecnologias();
		agregarTecnologias(importarTecnologias);
		theActorInTheSpotlight().attemptsTo(ImportoArchivoTecnologias.conLosDatosDelModelo());
	}

	@And("^Asigno area de cobertura sede principal y demas para negociacion simple$")
	public void AsignoAreaDeCoberturaSedePrincipalYDemasParaNegociacionSimple(List<String> datos) {
		String areacobertura = datos.get(2);
		String sede = datos.get(3);
		theActorInTheSpotlight().attemptsTo(DiligencioNegociacionSimple.conDatos(areacobertura, sede));

	}

	@And("^agrego medicamentos manualmente por codigo Nro (.+)")
	public void agregoMecamentosManualmente(String codigo) {
		theActorInTheSpotlight().attemptsTo(AgregarMedicamentos.porCodigo(codigo));

	}

	@And("^agrego insumos")
	public void agregoMedicamentosManualmente(List<Insumos> insumosData) {
		Insumos.salvarInformacionMedicamentos(insumosData.get(0));
		theActorInTheSpotlight()
				.attemptsTo(AgregarMedicamentos.porCodigo(Insumos.traerInsumo(0).getPorCodigoMedicamento()));
		 theActorInTheSpotlight()
		 .attemptsTo(AgregarMedicamentos.porDescripcion(Insumos.traerInsumo(0).getPorDescripcionMedicamento()));
		 theActorInTheSpotlight()
		 .attemptsTo(AgregarMedicamentos.porATC(Insumos.traerInsumo(0).getPorCodigoATCMedicamento()));
		theActorInTheSpotlight()
				.attemptsTo(AgregarProcedimiento.porCodigo(Insumos.traerInsumo(0).getPorCodigoProcedimiento()));
		 theActorInTheSpotlight().attemptsTo(
		 AgregarProcedimiento.porDescripcion(Insumos.traerInsumo(0).getPorDescripcionProcedimiento()));
		theActorInTheSpotlight().attemptsTo(AgregarPaquetes.porCodigo(Insumos.traerInsumo(0).getPorCodigoPaquete()));

	}

	@Then("^se muestra mensaje de La negociación se ha finalizado correctamente.$")
	public void seMuestraMensajeDeSeAgregadoCorrectamenteLosMedicamentos() {
		theActorInTheSpotlight().should(
				seeThat(MensajeTemporal.es(), containsString("La negociación se ha finalizado correctamente.")));

	}

	@Then("^se muestra mensaje de Se han agregado correctamente los servicios$")
	public void seMuestraMensajeSeSeHanAgregadoCorrectamenteLosServicios() {
		theActorInTheSpotlight()
				.should(seeThat(MensajeTemporal.es(), containsString("Se han agregado correctamente los servicios:")));

	}

}
