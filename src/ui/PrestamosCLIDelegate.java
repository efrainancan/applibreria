package ui;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import model.Libro;
import model.Prestamo;
import model.Usuario;
import validator.PrestamoValidator;
import validator.UsuarioValidador;

public class PrestamosCLIDelegate extends BaseCLI {

  private final List<Prestamo> prestamoList;
  private final PrestamoValidator validator;
  private final UsuarioValidador usuarioValidador;

  public PrestamosCLIDelegate(List<Libro> libroList, List<Usuario> listaUsuarios, List<Prestamo> prestamoList) {
    this.prestamoList = prestamoList;
    validator = new PrestamoValidator(libroList, listaUsuarios);
    usuarioValidador = new UsuarioValidador(listaUsuarios);
  }

  public void run() {
    boolean isRunning = true;
    while (isRunning) {
      var prompt = prompt("Que operacion desea realizar sobre prestamos (agregar, salir)");
      switch (prompt.toLowerCase()) {
        case "salir" -> isRunning = false;
        case "agregar" -> agregarPrestamo();
      }
    }
  }

  private void agregarPrestamo() {
    var isbn = prompt("ISBN del libro: ");
    var libro = validator.validarLibro(isbn);
    if (libro == null) {
      return;
    }

    var run = prompt("Ingrese RUN de usuario");
    var usuario = usuarioValidador.validarUsuario(run);
    if (usuario == null) {
      return;
    }

    if (!Usuario.PRESTAMO_OK.equals(usuario.getPrestamo())) {
      showError("Usuario ya tiene un prestamo realizado");
      return;
    }

    int dias = promptInt("Dias de prestamo: ");
    if (!validator.validarDiasPrestamo(usuario.getTipoUsuario(), dias)) {
      return;
    }

    Prestamo prestamo = new Prestamo();
    prestamo.setFechaPrestamo(Date.from(Instant.now()));
    prestamo.setUsuario(usuario);
    prestamo.setLibro(libro);
    prestamo.setDiasPrestamo(dias);
    prestamoList.add(prestamo);

    libro.setCantidadDisponible(libro.getCantidadDisponible() - 1);
    usuario.setPrestamo(isbn);
    br("Libro prestado con exito");
  }

}
