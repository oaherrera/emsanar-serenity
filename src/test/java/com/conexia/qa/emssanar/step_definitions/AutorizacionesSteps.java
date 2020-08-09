package com.conexia.qa.emssanar.step_definitions;

import static com.conexia.qa.emssanar.models.DatosAfiliado.limpiarDatosAfiliadoList;
import static com.conexia.qa.emssanar.models.DatosAfiliado.salvarInfoDatosAfiliado;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;

import com.conexia.qa.emssanar.models.DatosAfiliado;
import com.conexia.qa.emssanar.tasks.DiligencioFormularioAut;

import cucumber.api.java.en.And;

public class AutorizacionesSteps {
	@And("^diligencio los datos del formulario$")
	public void diligencioLosDatosDelFormulario(List<DatosAfiliado> data) {
		limpiarDatosAfiliadoList();
		salvarInfoDatosAfiliado(data.get(0));
		theActorInTheSpotlight().attemptsTo(DiligencioFormularioAut.conLosDatos());
	}

}
