package ui;

public class CLIHelperFacade extends BaseCLI {

  private final LibroCLIDelegate libroCLIHelper;
  private final UsuarioCLIDelegate estudianteCLIHelper;
  private final PrestamosCLIDelegate prestamosCLIHelper;
  private final DevolucionCLIDelegate devolucionCLIDelegate;

  public CLIHelperFacade() {
    libroCLIHelper = new LibroCLIDelegate();
    estudianteCLIHelper = new UsuarioCLIDelegate();
    prestamosCLIHelper = new PrestamosCLIDelegate();
    devolucionCLIDelegate = new DevolucionCLIDelegate();
  }

  public void run() {
    System.out.println("===================================");
    boolean isRunning = true;
    while (isRunning) {
      switch (prompt("Que entidad quiere operar? (devolucion, usuario, libro, prestamo): ").toUpperCase()) {
        case "USUARIO" -> estudianteCLIHelper.run();
        case "LIBRO" -> libroCLIHelper.run();
        case "PRESTAMO" -> prestamosCLIHelper.run();
        case "DEVOLUCION" -> devolucionCLIDelegate.run();
        default -> {
          System.out.println("Opcion no valida");
          isRunning = false;
        }
      }
    }
    br("Programa finalizado");
  }

}
