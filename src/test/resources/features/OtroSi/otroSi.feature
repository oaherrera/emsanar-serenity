Feature: OtroSi
  yo como usuario deseo poder crear y hacer modificaciones de OtroSi

  Background: 
    Given me autentico con cppruebas y contraseña pruebas

  @CreaciónDeOtroSi
  Scenario Outline: creación de Otrosi
    When Ingreso al modulo de negociacion
    And busco una negociacion
      | numeroNegociacion |
    And filtro por numero de negociacion
      | numeroNegociacion | mesAnio | diaDelMes |
    And ingreso al modulo de legalizacion
    And busco la negociacion en legalizacion
      | numeroNegociacion |
    And valido el estado de la negociacion
    And diligencio datos del contrato
      | correo | nivelAtencion |
    Then se debe mostrar el mensaje de guardado correctamente
    And diligencio el visto bueno
      | responsable |
    Then se visualizan los mensajes de tramite exitoso

    Examples: 
      | data |
       ##@externaldata@./src/test/resources/data/Negociacion/Negociacion.xlsx@OtroSi
