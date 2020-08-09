Feature: Solicitud Autorizacion
  Yo como usuario requiero crear soicitudes de autorizacion

  Background: 
    Given me autentico con eps_pruebas y contraseña pruebas

  @CreoAutorizacion
  Scenario: Crear solicitud Autorización
    When Ingreso al modulo de Afiliado, a Solicitud
    And Consulto afiliado con CEDULA DE CIUDADANIA Nro 6391985 en Autorizaciones
    And diligencio los datos del formulario
      | razonSocial     | especialidad     | origenDeLaAtencion | prioridadDeLaAtncion | tipoServicioSolicitado | ubicacionDelPaciente | codigoCIE | nomDiagnostico | tipoDiagnostico | codProcedimiento | nomProcedimiento | codMedicamento | nomMedicamento | codInsumo | nomInsumo |
      | EVARISTO GARCIA | MEDICINA GENERAL | Enfermedad General | Prioritario          | Servicios electivos    | Consulta externa     | z000      |                | Confirmado      |           877815 |                  |                | aceta          |           | jering    |
