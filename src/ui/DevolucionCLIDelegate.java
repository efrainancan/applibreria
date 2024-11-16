package ui;

import java.time.LocalDate;

import model.Usuario;
import store.StoreManager;
import validator.LibroValidador;
import validator.UsuarioValidador;

public class DevolucionCLIDelegate extends BaseCLI {

  private static final StoreManager storeManager = StoreManager.getInstance();

  private static final int FINE_BY_DAY = 1_000;

  private final LibroValidador libroValidador;
  private final UsuarioValidador usuarioValidador;

  public DevolucionCLIDelegate() {
    libroValidador = new LibroValidador();
    usuarioValidador = new UsuarioValidador();
  }

  public void run() {
    var RUN = prompt("RUN de usuario: ");
    var usuario = usuarioValidador.existeUsuario(RUN);
    if (usuario == null) {
      return;
    }

    String isbn = prompt("ISBN: ");
    var libro = libroValidador.existe(isbn);
    if (libro == null) {
      return;
    }

    if (!Usuario.PRESTAMO_OK.equals(usuario.getPrestamo())) {
      showError("Usuario no tiene prestamo pendiente");
      return;
    }

    if (!usuario.getPrestamo().equals(isbn)) {
      showError("Isbn del prestamos no coincide con el usuario");
      return;
    }

    var prestamo = storeManager.getPrestamoMasReciente(RUN, isbn);
    if (prestamo.isEmpty()) {
      showError("Usuario no tiene prestamos registrados");
      return;
    }

    var diasPrestamo = prestamo.get().getDiasPrestamo();
    var fechaPrestamo = prestamo.get().getFechaPrestamo();
    var dueDate = fechaPrestamo.plusDays(diasPrestamo);
    var today = LocalDate.now();

    if (today.isAfter(dueDate)) {
      var multa = dueDate.until(today).getDays() * FINE_BY_DAY;
      System.out.println("Se debe cancelar una multta de: " + multa);
    }

    storeManager.agregarCantidadDisponible(libro, 1);
    storeManager.prestarLibro(usuario, Usuario.PRESTAMO_OK);
    br("devolucion exitosa.");
  }

}
