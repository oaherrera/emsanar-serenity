package com.conexia.qa.emssanar.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Rips/cargue_y_validacion_rips.feature", 
		snippets = SnippetType.CAMELCASE,
//		monochrome = true,
		glue = "com.conexia.qa.emssanar.step_definitions"
				,tags = "@CargarRipsDeEvento"
		
		//,tags = "@GestionarCuentaFinalizarHomologacion"
		//, tags = "@GestionarCuentaEnviarHomologar,@GestionarCuentaFinalizarHomologacion,@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegostroCuentaEps "
)

public class RipsRunner {

}
