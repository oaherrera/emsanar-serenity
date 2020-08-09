package com.conexia.qa.emssanar.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
		features = "src/test/resources/features/OtroSi/otroSi.feature", 
		snippets = SnippetType.CAMELCASE,
		//monochrome = true,
		glue = "com.conexia.qa.emssanar.step_definitions"
		,tags = "@CreaciónDeOtroSi"
)

public class OtroSiRunner {

}
