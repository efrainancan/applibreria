package ui;

import java.util.List;

import model.Libro;
import model.Usuario;
import validator.LibroValidador;
import validator.UsuarioValidador;

public class DevolucionCLIDelegate extends BaseCLI {

  private final LibroValidador libroValidador;
  private final UsuarioValidador usuarioValidador;

  public DevolucionCLIDelegate(List<Libro> libroList, List<Usuario> usuarioList) {
    libroValidador = new LibroValidador(libroList);
    usuarioValidador = new UsuarioValidador(usuarioList);
  }

  public void run() {
    String isbn = prompt("ISBN: ");
    var libro = libroValidador.existe(isbn);
    if (libro == null) {
      return;
    }

    var RUN = prompt("RUN de usuario: ");
    var usuario = usuarioValidador.validarUsuario(RUN);
    if (usuario == null) {
      return;
    }

    // TODO: seguir desarrollando el metodo

  }

}
