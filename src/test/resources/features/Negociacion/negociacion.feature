Feature: Negociacion

  Background: 
    Given me autentico con cppruebas y contraseña pruebas

  @CreoNegociacionSencillaConCargueManual
  Scenario Outline: Deseo crear una negociación con cargue de insumos manual
    When Ingreso al modulo de negociacion
    And Busco al prestador
    And Creo la base negociacion
      | modalidad | regimen | poblacion | complejidad |
    Then Negociación creada correctamente
    And Asigno area de cobertura sede principal y demas para negociacion simple
      | areaCobertura | sedePrincipal |
    And agrego insumos
      | porCodigoMedicamento | porDescripcionMedicamento | porCodigoATCMedicamento | porCodigoProcedimiento | porDescripcionProcedimiento |porCodigoPaquete|porDescripcionpaquete|porCodigoIPSPaquete|
      
    Then se muestra mensaje de La negociación se ha finalizado correctamente.

    Examples: 
      | data |
       ##@externaldata@./src/test/resources/data/Negociacion/Negociacion.xlsx@NegManual
