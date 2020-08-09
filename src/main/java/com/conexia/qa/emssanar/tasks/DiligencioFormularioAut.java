package com.conexia.qa.emssanar.tasks;




import com.conexia.qa.emssanar.interactions.Esperar;
import com.conexia.qa.emssanar.interactions.EsperarCargando;
import com.conexia.qa.emssanar.interactions.Swipe;
import com.conexia.qa.emssanar.models.DatosAfiliado;
import com.conexia.qa.emssanar.user_interfaces.ConfirmarDerechosPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.model.TakeScreenshots;

public class DiligencioFormularioAut implements Task {

	private String razonSocial;
	private String especialidad;
	private String origenDeLaAtencion;
	private String prioridadDeLaAtncion;
	private String tipoServicioSolicitado;
	private String ubicacionDelPaciente;
	private String codigoCIE;
	private String nomDiagnostico;
	private String tipoDiagnostico;
	private String codProcedimiento;
	private String nomProcedimiento;
	private String codMedicamento;
	private String nomMedicamento;
	private String codInsumo;
	private String nomInsumo;
	
	
	
	

	public DiligencioFormularioAut() {
		
		this.razonSocial = DatosAfiliado.traerDatos(0).getRazonSocial();
		this.especialidad = DatosAfiliado.traerDatos(0).getEspecialidad();
		this.origenDeLaAtencion = DatosAfiliado.traerDatos(0).getOrigenDeLaAtencion();
		this.prioridadDeLaAtncion = DatosAfiliado.traerDatos(0).getPrioridadDeLaAtncion();
		this.tipoServicioSolicitado = DatosAfiliado.traerDatos(0).getTipoServicioSolicitado();
		this.ubicacionDelPaciente = DatosAfiliado.traerDatos(0).getUbicacionDelPaciente();
		this.codigoCIE = DatosAfiliado.traerDatos(0).getCodigoCIE();
		this.nomDiagnostico = DatosAfiliado.traerDatos(0).getNomDiagnostico();
		this.tipoDiagnostico = DatosAfiliado.traerDatos(0).getTipoDiagnostico();
		this.codProcedimiento = DatosAfiliado.traerDatos(0).getCodProcedimiento();
		this.nomProcedimiento = DatosAfiliado.traerDatos(0).getNomProcedimiento();
		this.codMedicamento = DatosAfiliado.traerDatos(0).getCodMedicamento();
		this.nomMedicamento = DatosAfiliado.traerDatos(0).getNomMedicamento();
		this.codInsumo = DatosAfiliado.traerDatos(0).getCodInsumo();
		this.nomInsumo = DatosAfiliado.traerDatos(0).getNomInsumo();
	}

	@Override
	@Step("{0} Diligenciar campos en el formulario")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Swipe.vertical(800));
		actor.attemptsTo(Enter.theValue(razonSocial).into(ConfirmarDerechosPage.INPUT_RAZON_SOCIAL));
		actor.attemptsTo(Click.on(ConfirmarDerechosPage.BOTON_BUSCAR_INFOIPS),EsperarCargando.pagina());
		Serenity.takeScreenshot();
		actor.attemptsTo(Swipe.vertical(400));
		Serenity.takeScreenshot();
		actor.attemptsTo(SelectFromOptions.byVisibleText(especialidad).from(ConfirmarDerechosPage.SELECT_ESPECIALIDAD));
		actor.attemptsTo(Click.on(ConfirmarDerechosPage.BOTON_BUSCAR_PROFESIONAL),EsperarCargando.pagina());
		actor.attemptsTo(Click.on(ConfirmarDerechosPage.PROFESIONAL));
		Serenity.takeScreenshot();
		actor.attemptsTo(Swipe.vertical(200));
		Serenity.takeScreenshot();
		actor.attemptsTo(SelectFromOptions.byVisibleText(origenDeLaAtencion).from(ConfirmarDerechosPage.SELECT_ORIGEN_DE_ATENCION));
		actor.attemptsTo(SelectFromOptions.byVisibleText(prioridadDeLaAtncion).from(ConfirmarDerechosPage.SELECT_PRIORIDAD_DE_ATENCION));
		actor.attemptsTo(SelectFromOptions.byVisibleText(tipoServicioSolicitado).from(ConfirmarDerechosPage.SELECT_TIPO_SERVICIO_SOLICITADO));
		actor.attemptsTo(SelectFromOptions.byVisibleText(ubicacionDelPaciente).from(ConfirmarDerechosPage.SELECT_UBICACION_DEL_PACIENTE));
		actor.attemptsTo(Esperar.por(2000));
		Serenity.takeScreenshot();
	}

	public static DiligencioFormularioAut conLosDatos() {
		return Tasks.instrumented(DiligencioFormularioAut.class );
	}

}
