package ui;

import java.util.LinkedList;
import java.util.List;

import model.Libro;
import model.Prestamo;
import model.Usuario;

public class CLIHelperFacade extends BaseCLI {

  private final List<Libro> libroList = new LinkedList<>();
  private final List<Usuario> listaUsuario = new LinkedList<>();
  private final List<Prestamo> prestamoList = new LinkedList<>();

  private final LibroCLIDelegate libroCLIHelper;
  private final UsuarioCLIDelegate estudianteCLIHelper;
  private final PrestamosCLIDelegate prestamosCLIHelper;
  private final DevolucionCLIDelegate devolucionCLIDelegate;

  public CLIHelperFacade() {
    libroCLIHelper = new LibroCLIDelegate(libroList);
    estudianteCLIHelper = new UsuarioCLIDelegate(listaUsuario);
    prestamosCLIHelper = new PrestamosCLIDelegate(libroList, listaUsuario, prestamoList);
    devolucionCLIDelegate = new DevolucionCLIDelegate(libroList, listaUsuario);
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
