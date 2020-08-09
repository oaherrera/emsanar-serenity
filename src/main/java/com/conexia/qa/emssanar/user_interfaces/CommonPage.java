package com.conexia.qa.emssanar.user_interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CommonPage {
	public static final Target CARGANDO = Target.the("Cargando Pagina")
			.locatedBy("//img[contains(@src,'ajaxloadingbar.gif')]");
	public static final Target ADJUNTAR_ARCHIVO = Target.the("Adjuntar Archivo").locatedBy("//input[@type='file']");
	public static final Target BARRA_DE_CARGANDO_ARCHIVO = Target.the("Barra de Cargando Archivo")
			.locatedBy("//div[@role='progressbar']/div[contains(@style,'display')]");
	public static final Target VOLVER = Target.the("Volver").locatedBy("//button[@role='button']/span[.='Volver']");
	public static final Target CONFIRMAR_ACEPTAR = Target.the("Confirmar Aceptar").locatedBy(
			"//div[contains(@style,'display: block')]//button[contains(@class,'ui-confirmdialog')]/span[.='Aceptar']");
	public static final Target CONFIRMAR_SI = Target.the("Confirmar Si")
			.locatedBy("//div[contains(@style,'display: block')]//button[contains(@class,'ui-button')]/span[.='Si']");
	public static final Target BUSCAR = Target.the("Buscar").locatedBy("//button[@type='submit']/span[.='Buscar']");
	public static final Target BUARDAR = Target.the("Guardar").locatedBy("//button[@type='submit']/span[.='Guardar']");
	public static final Target AGREGAR = Target.the("Agregar").locatedBy("//button[@type='submit']/span[.='Agregar']");
	public static final Target ASIGNAR = Target.the("Asignar").locatedBy("//button[@type='submit']/span[.='Asignar']");
	public static final Target ACEPTAR = Target.the("Aceotar").locatedBy("//button[@type='submit']/span[.='Aceptar']");
	public static final Target MENSAJE_TEMPORAL = Target.the("Mensaje Temporal")
			.locatedBy("//div[@class='ui-growl-message']/span");
	public static final Target ENVIAR_HOMOLOGACION = Target.the("Enviar a Homologación")
			.locatedBy("//button[contains(@title,'Enviar')]/span[1]");
	public static final Target MENU_PRECONTRACTUAL = Target.the("Menu Precontractual")
			.locatedBy("//a[contains(@class,'menu-dropdown')]/span[contains(text(),'Precontractual')]");
	public static final Target MENU_NEGOCIACION = Target.the("Menu Negociación")
			.locatedBy("//a[contains(@href,'bandejaPrestador')]/span");
	public static final Target MENU_NEGOCIACION_UAT = Target.the("Menu Negociación UAT")
			.locatedBy("//span[.='Negociación']");
	public static final Target MENU_CONTRACTUAL = Target.the("Menu contractual")
			.locatedBy("//a[contains(@class,'menu-dropdown')]/span[contains(text(),'Contractual')]");
	public static final Target MENU_LEGALIZACION = Target.the("Menu contractual")
			.locatedBy("(//span[contains(text(),'Legalización')])[1]");
	
	
}
