package ui;

import java.time.LocalDate;

import model.Prestamo;
import model.Usuario;
import store.StoreManager;
import validator.PrestamoValidator;
import validator.UsuarioValidador;

public class PrestamosCLIDelegate extends BaseCLI {

  private static final StoreManager storeManager = StoreManager.getInstance();

  private final PrestamoValidator validator;
  private final UsuarioValidador usuarioValidador;

  public PrestamosCLIDelegate() {
    validator = new PrestamoValidator();
    usuarioValidador = new UsuarioValidador();
  }

  public void run() {
    boolean isRunning = true;
    while (isRunning) {
      var prompt = prompt("Que operacion desea realizar sobre prestamos (agregar, listar, salir): ");
      switch (prompt.toLowerCase()) {
        case "salir" -> isRunning = false;
        case "agregar" -> agregarPrestamo();
        case "listar" -> listar();
      }
    }
  }

  private void agregarPrestamo() {
    var isbn = prompt("ISBN del libro: ");
    var libro = validator.validarLibro(isbn);
    if (libro == null) {
      return;
    }

    var run = prompt("Ingrese RUN de usuario: ");
    var usuario = usuarioValidador.existeUsuario(run);
    if (usuario == null) {
      return;
    }

    if (!Usuario.PRESTAMO_OK.equals(usuario.getPrestamo())) {
      showError("Usuario ya tiene un prestamo realizado.");
      return;
    }

    int dias = promptInt("Dias de prestamo: ");
    if (!validator.validarDiasPrestamo(usuario.getTipoUsuario(), dias)) {
      return;
    }

    Prestamo prestamo = new Prestamo();
    prestamo.setFechaPrestamo(LocalDate.now());
    prestamo.setUsuario(usuario);
    prestamo.setLibro(libro);
    prestamo.setDiasPrestamo(dias);
    storeManager.add(prestamo);
    storeManager.agregarCantidadDisponible(libro, -1);
    storeManager.prestarLibro(usuario, isbn);
    System.out.println(prestamo.generarTarjetPrestamo());
    br("Libro prestado con exito.");
  }

  public void listar() {
    var prestamos = storeManager.getPrestamosStore();
    System.out.println("Hay " + prestamos.size() + " prestamos registrados");
    prestamos.forEach(System.out::println);
    br();
  }

}
