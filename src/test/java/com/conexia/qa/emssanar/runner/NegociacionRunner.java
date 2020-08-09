package com.conexia.qa.emssanar.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
		features = "src/test/resources/features/Negociacion/negociacion.feature", 
		snippets = SnippetType.CAMELCASE,
		//monochrome = true,
		glue = "com.conexia.qa.emssanar.step_definitions"
		,tags = "@CreoNegociacionSencillaConCargueManual"
		//, tags = "@GestionarCuentaEnviarHomologar,@GestionarCuentaFinalizarHomologacion,@GestionarCuentaEnviarAVerificarEPS,@RevisarFacturasCuentaEps,@RegostroCuentaEps "
)

public class NegociacionRunner {

	
	
}
	