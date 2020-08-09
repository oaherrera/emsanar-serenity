package com.conexia.qa.emssanar.tasks;

import static com.conexia.qa.emssanar.models.ImportarTecnologiasEvento.cantidadTecnologias;
import static com.conexia.qa.emssanar.models.ImportarTecnologiasEvento.traerImportTecnologia;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionTecnologiasPage.IMPORTAR_MEDICAMENTOS;
import static com.conexia.qa.emssanar.user_interfaces.NegociacionTecnologiasPage.TAB_MEDICAMENTOS;

import com.conexia.qa.emssanar.interactions.AdjuntoArchivo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ImportoArchivoTecnologias implements Task {

	public ImportoArchivoTecnologias() {
	}

	@Step("{0} Carga los archivos de las tecnologias a la negociación")
	@Override
	public <T extends Actor> void performAs(T actor) {
		int indice = 0;
		while (indice < cantidadTecnologias()) {
			switch (traerImportTecnologia(indice).getTecnologia()) {
			case "Medicamentos":
				System.out.println("Medicamentow");
				actor.attemptsTo(Click.on(TAB_MEDICAMENTOS));
				actor.attemptsTo(
						AdjuntoArchivo.con(traerImportTecnologia(indice).getArchovACargar(), IMPORTAR_MEDICAMENTOS));
				break;
			case "Insumos":
				System.out.println("insumos");
				break;
			}

			indice++;
		}

	}

	public static ImportoArchivoTecnologias conLosDatosDelModelo() {
		return Tasks.instrumented(ImportoArchivoTecnologias.class);
	}

}
