Feature: Cargue de los archivos Rips, y procesamiento de los mismos
  Yo como usuario requiero cargar, procesar y gestionar archivos Rips de las diferentes modalidades
  Capita, Evento y PGP

  Background: 
    Given me autentico con jlregional y contraseña pruebas

  @CargarRipsDeEvento
  Scenario: Carga Archivos rips de modalidad Evento
    When Ingreso al modulo de Liquidación de Prestaciones, a Kiosko EPS
    And Ingreso al logueo de la ips CORPOSALUD SAS - CORPORACION PARA LA SALUD INTEGRAL - PASTO ( NARIÃO )
    And Diligencio el formulario de Cargue y Vaidación de Rips
      | ips                                                                     | mesPrestacion | anhoPrestacion | nroCuenta | valorCuenta | contrato      | regional                   | responsableDePago    | tipoDeServicio |
      | CORPOSALUD SAS - CORPORACION PARA LA SALUD INTEGRAL - PASTO ( NARIÃO ) | Mayo          |           2019 |      1017 |        8000 | 150-1ES190001 | Regional Nariño - Putumayo | EPS EMSSANAR ESS RNP | Subsidiado     |
    And Adjunto el o los archivos de Rips y los Cargo
      | archivos                                                        |
      | C:/Users/oherrera/Downloads/rips_mayo_homologacion/AC000062.txt |
      | C:/Users/oherrera/Downloads/rips_mayo_homologacion/AF000062.txt |
      | C:/Users/oherrera/Downloads/rips_mayo_homologacion/AM000062.txt |
      | C:/Users/oherrera/Downloads/rips_mayo_homologacion/CT000062.txt |
      | C:/Users/oherrera/Downloads/rips_mayo_homologacion/US000062.txt |

  @validarCuenta_EnviarAHomologacion
  Scenario: 
    Validación de la cuenta que este en estado validado y enviar a homologacion

    When Ingreso al modulo de Liquidación de Prestaciones, a Kiosko EPS
    And para Ingreso al logueo de la ips CEHANI ESE - PASTO ( NARIÃO ) para validar la cuenta
    And Consulto el estado de la cuenta 1017 gestionada para la ips
    And La cuenta se encuentra en estado
      | cuenta | estadoCuenta |
      |   1017 | VALIDADO     |
    And envio al proceso de homologacion

  @validarEstadoDeLaCuenta_FinalizarHomologacion
  Scenario: Validación de la cuenta en estado pendiente homologación y finalizar
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto el estado de la cuenta 4311 gestionada para la ips en gestion cuentas EPS
    And se valida el estado de la cuenta en gestion de cuentas EPS
      | cuenta | estadoCuenta           |
      |   4311 | PENDIENTE HOMOLOGACION |
    And Gestiono la encuenta, Finalizar homologación

  @validarEstadoDeLaCuenta_EnviaAVerificaciónEPS
  Scenario: Validación de la cuenta en estado Homologación Terminada y enviar a Verificación EPS
    When Ingreso al modulo de Liquidación de Prestaciones, a Kiosko EPS
    And para Ingreso al logueo de la ips COOEMSSANAR SF - COOPERATIVA EMSSANAR SERVICIO FARMACEUTICO - SAN IGNACIO - PASTO ( NARIÃO ) para validar la cuenta
    And Consulto el estado de la cuenta 3450019 gestionada para la ips
    And La cuenta se encuentra en estado
      | cuenta  | estadoCuenta           |
      | 3450019 | HOMOLOGACION TERMINADA |
    And Gestiono la encuenta, Enviar a Verificación EPS
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto el estado de la cuenta 3450019 gestionada para la ips en gestion cuentas EPS
    And se valida el estado de la cuenta en gestion de cuentas EPS
      | cuenta  | estadoCuenta |
      | 3450019 | EN PROCESO   |
    And Gestiono la encuenta como Eps, Devolución EPS
    And Marco la cuenta con todas las Facturas como Revisado
    And Consulto el estado de la cuenta 3450019 gestionada para la ips en gestion cuentas EPS
    And se valida el estado de la cuenta en gestion de cuentas EPS
      | cuenta  | estadoCuenta |
      | 3450019 | REVISADO     |
    And Gestiono la encuenta como Eps, Registrar Cuenta EPS
    And Radico la cuenta con la Eps
      | regional                   | claseDeServicio        | responsableDePago    | observaciones |
      | Regional Nariño - Putumayo | Promoción y prevención | EPS EMSSANAR ESS RNP | observaciones |
    And se valida el estado de la cuenta en gestion de cuentas EPS
      | cuenta  | estadoCuenta      |
      | 3450019 | PROCESANDO CUENTA |

  @legalizarCuenta
  Scenario: legalizacion de la cuenta
    When Ingreso al modulo de Liquidación de Prestaciones, a Gestión de cuentas - EPS
    And Consulto el estado de la cuenta 3450019 gestionada para la ips en gestion cuentas EPS
    And se valida el estado de la cuenta en gestion de cuentas EPS
      | cuenta  | estadoCuenta                    |
      | 3450019 | RADICADO PENDIENTE DE NOTIFICAR |
    And legalizo la cuenta
    And Ingreso al modulo de Liquidación de Prestaciones, a Lista trabajo radicados
    And Consulto el estado de la cuenta 3450019 en listas de trabajo
    Then la cuenta debe cambiar al siguiente estado
      | cuenta  | estadoCuenta        |
      | 3450019 | Pendiente auditoría |
