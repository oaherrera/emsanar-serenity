package com.conexia.qa.emssanar.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class NegociacionPage {

	public static final Target CREAR_NEGOCIACION = Target.the("Crear Negociacion")
			.locatedBy("//button[@type='submit']/span[.='Crear negociación']");
	public static final Target NUMERO_NEGOCIACION_FILTRO = Target.the("N° Negociacion tabla filtro")
			.locatedBy("//thead[contains(@id,'negociacionesPrestador_head')]/tr/th[.='No. Negociación']/child::input");
	public static final Target VER_NEGOCIACION = Target.the("Ver negociacion")
			.locatedBy("//button[contains(@id,'btnVerNegociacion')]");
	public static final Target TABLA_ENCABEZADO = Target.the("Tabla Encabezado").locatedBy(
			"//input[contains(@id,'tblNegociacionesPrestadorForm:negociacionesPrestador_scrollState')]");

	// Crear Negociación
	public static final Target MODALIDAD_NEGOCIACION = Target.the("Modalidad Negociacion")
			.locatedBy("//label[contains(@id,'modalidadNegociacion_label')]");
	public static final Target MODALIDAD_NEGOCIACION_SELECCION = Target.the("Modalidad Negociacion {0}")
			.locatedBy("//div[contains(@id,'modalidadNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target REGIMEN_NEGOCIACION = Target.the("Regimen Negociacion")
			.locatedBy("//label[contains(@id,'regimenNegociacion_label')]");
	public static final Target MODALIDAD_REGIMEN_SELECCION = Target.the("Regimen Negociacion {0}")
			.locatedBy("//div[contains(@id,'regimenNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target POBLACION = Target.the("Poblacion")
			.locatedBy("//input[contains(@id,'poblacionNegociacion')]");
	public static final Target COMPLEJIDAD = Target.the("Complejidad")
			.locatedBy("//label[contains(@id,'complejidadNegociacion_label')]");
	public static final Target COMPLEJIDAD_SELECCION = Target.the("Complejidad {0}")
			.locatedBy("//div[contains(@id,'complejidadNegociacion_panel')]//li[@data-label='{0}']");
	public static final Target AREA_DE_COBERTURA = Target.the("Area de cobertura")
			.locatedBy("//label[contains(@id,'listOpcionesArea_label')]");
	public static final Target AREA_DE_COBERTURA_SELECCION = Target.the("Area de cobertura {0}")
			.locatedBy("//div[contains(@id,'listOpcionesArea_panel')]//li[@data-label='{0}']");
	public static final Target BOTON_GUARDAR = Target.the("Boton Guardar")
			.locatedBy("//button[contains(@id,'encabezadoForm:')]//span[contains(text(),'Guardar')]");
	public static final Target SELECCIONAR_REGISTRO = Target.the("Seleccionar Registro de la tabla")
			.locatedBy("(//input[@name='sedesPrestadorForm:sedesNegociacion_checkbox']//following::span)[3]");
	public static final Target ASIGNAR_AREAS_COBERTURA = Target.the("Asignar Areas de Cobertura")
			.locatedBy("//button[contains(@id,'sedesPrestadorForm:sedesNegociacion:0:btnInvitar')]");
	public static final Target MARCAR_TODOS_MUNICIPIOS = Target.the("Marcar todos los Municipios")
			.locatedBy("//th[contains(@id,'areasCoberturaForm:deptoMunicipioCobertura:columnSeleccion')]");
	public static final Target BOTON_REPLICAR_AREA = Target.the("Boton Marcar area")
			.locatedBy("//span[contains(text(),'Replicar área')]");
	public static final Target CONFIRMACION_SI_SEDES = Target.the("Confirmación de asociación de las sedes")
			.locatedBy("//button[contains(@id,'confirmDialogForm:')]//span[contains(text(),'Si')]");
	public static final Target CERRAR_TABLA_DE_ASIGNAR_MUNICIPIOS = Target.the("Cerrar tabla de asinación de municipios")
			.locatedBy("(//a[contains(@class,'ui-dialog-titlebar-icon ui-dialog-titlebar-close ui-corner-all')])[1]");
	public static final Target POP_UP_EMERGENTE = Target.the("Cerrar pop_up emergente")
			.locatedBy("//div[@class ='ui-growl-icon-close ui-icon ui-icon-closethick']");
	public static final Target SEDE_PRINCIPAL = Target.the("Sede Principal")
			.locatedBy("//label[contains(@id,'sedesPrestadorForm:sedePrincipal_label')]");
	public static final Target SEDE_PRINCIPAL_SELECCION = Target.the("Selecciona Sede Principal")
			.locatedBy("//div[contains(@id,'sedesPrestadorForm:sedePrincipal_panel')]//li[@data-label='{0}']");
	public static final Target DISTRIBUIR_POBLACION = Target.the("Desea distribuir la población por servicio?")
			.locatedBy("(//div[contains(@class,'ui-radiobutton-box ui-widget ui-corner-all ui-state-default')])[1]");
	public static final Target BOTON_SIGUIENTE = Target.the("Boton siguiente")
			.locatedBy("//button[contains(@id,'sedesPrestadorForm:siguiente_prestador')]");
	public static final Target BOTON_SIGUIENTE2 = Target.the("Boton siguiente2")
			.locatedBy("//button[contains(@id,'tipoModalidadNegociacionForm:siguiente')]");
	
	public static final Target NEGOCIAR_TODAS_LAS_SEDES = Target.the("Check Negociar todas las sedes")
			.locatedBy("//table[contains(@id,'tipoModalidadNegociacionForm:tipoModalidadNegociacion')]//div[contains(@class,'ui-radiobutton-box ui-widget ui-corner-all ui-state-default')]/span");
	public static final Target CREAR_CONTENIDO_APARTIR_EXISTENTE = Target.the("Crear contenido a partir de una negociación existente")
			.locatedBy("//div[contains(@id,'tipoModalidadNegociacionForm:baseOtraNegociacion')]/div//following::span[@class='ui-chkbox-icon ui-icon ui-icon-blank ui-c']");
	public static final Target NUMERO_NEGOCIACION_A_DUPLICAR = Target.the("Numero de negociación a duplicar")
			.locatedBy("//input[contains(@id,'tipoModalidadNegociacionForm:numeroNegociacion')]");
	public static final Target BOTON_BUSCAR = Target.the("Boton Buscar")
			.locatedBy("//button[contains(@id,'tipoModalidadNegociacionForm')]//span[contains(text(),'Buscar')]");
	public static final Target BOTON_TERMINAR = Target.the("Boton Terminar")
			.locatedBy("//button[contains(@id,'tipoModalidadNegociacionForm:terminar')]//span[contains(text(),'Terminar')]");
	public static final Target MEDICAMENTO_POR_CODIGO_EMSSANAR = Target.the("Medicamento por codigo")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:codigoTecnologiaAgregarEvento')]");
	
	public static final Target BOTON_AGREGAR_MEDICAMENTO = Target.the("Boton Agregar Medicamento")
			.locatedBy("//button[contains(@id,'tecnologiasSSForm:tabsTecnologias:btnAgregarMxEvento')]");
	public static final Target SELECCIONAR_TODOS_LOS_MEDICAMENTOS = Target.the("Seleccionar todos los medicamentos")
			.locatedBy("//th[contains(@id,'medicamentosAgregarForm:medicamentoAgregarTable:') and @style='width:5%']");
	public static final Target AGREGAR_MEDICAMENTO = Target.the("Agregar Medicamento despues de seleccionar todos")
			.locatedBy("//button[contains(@id,'medicamentosAgregarForm:btnAgregarMedicamento')]");

	public static final Target DESCRIPCION_MEDICAMENTO = Target.the("Descripcion del Medicamento")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:descripicionTecnologiaAgregarEvento')]");
	
	
	public static final Target ATC_MEDICAMENTO = Target.the("Codigo ATC del Medicamento")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:AtcTecnologiaAgregarEvento')]");
	
	public static final Target TAB_PROCEDIMIENTOS = Target.the("Tab Procedimientos")
			.locatedBy("//a[contains(@href,'tabServicios')]");
	public static final Target CODIGO_PROCEDIMIENTO_EMSSANAR = Target.the("Codigo Procedimiento Emssanar")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:acordionPanelServicioSS:codigoTecnologiaAgregar')]");
	public static final Target BOTON_AGREGAR_PROCEDIMIENTO = Target.the("Boton Agregar Procedimiento")
			.locatedBy("//button[contains(@id,'tecnologiasSSForm:tabsTecnologias:acordionPanelServicioSS:btnAgregarTecnologia')]");
	public static final Target SELECCIONAR_TODOS_LOS_PROCEDIMIENTOS = Target.the("Seleccionar todos los Procedimientos")
			.locatedBy("//th[contains(@id,'serviciosAgregarForm:serviciosAgregarTable')and @style='width:5%']");
	public static final Target AGREGAR_PROCEDIMIENTO = Target.the("Agregar procedimientos despues de seleccionar todos")
			.locatedBy("//button[contains(@id,'serviciosAgregarForm:btnAgregarTecnologia')]");
	public static final Target DESCRIPCION_PROCEDIMIENTO = Target.the("Descripcion del Procedimiento")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:acordionPanelServicioSS:descripicionTecnologiaAgregar')]");
	public static final Target BARRA_SCROLL_HORIZONTAL = Target.the("Descripcion del Procedimiento")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:negociacionMedicamentosSS_scrollState')]");
	public static final Target CHECK_VALOR_NEGOCIADO = Target.the("Valor Negociado")
			.locatedBy("//div[contains(@class,'ui-cell-editor-output')]/span");
	public static final Target INPUT_VALOR_NEGOCIADO = Target.the("Valor Negociado")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:negociacionMedicamentosSS:0:inputValorNegociado')]");
	public static final Target BOTON_TERMINAR_ASIGNACION = Target.the("Terminar asignación de tarifas")
			.locatedBy("//button[@id='tecnologiasSSForm:btnValidarTarifas']");
	public static final Target BOTON_TERMINAR_NEG_SIMPLE = Target.the("Terminar asignación de tarifas")
			.locatedBy("//button[contains(@id,'contratoAnteriorForm:terminar_contrato')]//span[contains(text(),'Terminar')]");
	public static final Target TIPO_TECNOLOGIA = Target.the("Tipo de Tecnologia")
			.locatedBy("//label[contains(@id,'formDialogValidarTarif:selectTipoTecnolog_label')]");
	public static final Target TIPO_TECNOLOGIA_SELECCION = Target.the("Tipo de tecnologia seleccionada")
			.locatedBy("//div[contains(@id,'formDialogValidarTarif:selectTipoTecnolog_panel')]//li[@data-label='Medicamentos']");
	public static final Target DATO_REFERENCIA = Target.the("Dato referencia")
			.locatedBy("//label[contains(@id,'formDialogValidarTarif:selectDatoRef_label')]");
	public static final Target DATO_REFERENCIA_SELECCION = Target.the("Dato Referencia seleccionado")
			.locatedBy("//div[contains(@id,'formDialogValidarTarif:selectDatoRef_panel')]//li[@data-label='Vr Maximo']");
	public static final Target BOTON_ACEPTAR_TARIFARIO = Target.the("Boton Aceptar")
			.locatedBy("//button[contains(@id,'formDialogValidarTarif:j_idt917')]/span");
	public static final Target BOTON_OMITIR = Target.the("Boton Omitir")
			.locatedBy("//button[contains(@id,'formDialogValidarTarif:')]//span[contains(text(),'Omitir')]");
	public static final Target BOTON_CONFIRMAR_SI = Target.the("Boton Confirmar SI")
			.locatedBy("//button[contains(@id,'confirmDialogForm:')]/span[contains(text(),'Si')]");
	public static final Target TAB_PAQUETES = Target.the("Tab Paquetes")
			.locatedBy("//a[contains(text(),'Paquetes')]");
	public static final Target CODIGO_PAQUETE = Target.the("Codigo Paquete")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:accordionOpciones:codigoTecnologiaAgregar')]");
	public static final Target DESCRIPCION_PAQUETE = Target.the("Descripcion Paquete")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:accordionOpciones:descripicionTecnologiaAgregar')]");
	public static final Target CODIGO_IPS_PAQUETE = Target.the("Codigo IPS Paquete")
			.locatedBy("//input[contains(@id,'tecnologiasSSForm:tabsTecnologias:accordionOpciones:codigoIpsTecnologiaAgregar')]");
	public static final Target BOTON_AGREGAR_PAQUETE = Target.the("Boton Agregar Paquete")
			.locatedBy("//button[contains(@id,'tecnologiasSSForm:tabsTecnologias:accordionOpciones:btnAgregarTecnologia')]");
	public static final Target SELECCIONAR_TODOS_EN_PAQUETES = Target.the("Seleccionar todos en paquetes")
			.locatedBy("(//th[contains(@id,'paquetesAgregarForm:paquetesAgregarTable:') and @style='width: 59px;'])[1]");
	public static final Target AGREGAR_PAQUETE = Target.the("Agregar Medicamento despues de seleccionar todos")
			.locatedBy("//button[contains(@id,'paquetesAgregarForm:btnAgregarTecnologia')]");
	public static final Target SELECCIONAR_SEDE = Target.the("Seleccionar Sede")
			.locatedBy("//label[contains(@class,'ui-selectcheckboxmenu-label ui-corner-all') and contains(text(),'Sedes')]");
	public static final Target CHECK_SELECCIONAR_SEDE = Target.the("Check Seleccionar Sede")
			.locatedBy("//div[contains(@class,'ui-selectcheckboxmenu-items-wrapper')]//following::span");
	
	
	
	
	
	
	
	
	
	
	
}
