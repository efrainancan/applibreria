package validator;

import java.util.List;

import model.Libro;
import model.Usuario;
import model.enums.TipoUsuario;

public class PrestamoValidator {

  private final List<Libro> libroList;
  private final List<Usuario> usuarioList;
  private LibroValidador libroValidador;

  public PrestamoValidator(List<Libro> libroList, List<Usuario> usuarioList) {
    this.libroList = libroList;
    this.usuarioList = usuarioList;
    libroValidador = new LibroValidador(libroList);
  }

  public Libro validarLibro(String isbn) {
    var libro = libroValidador.existe(isbn);
    if (libro == null) {
      return null;
    }
    if (libro.getCantidadDisponible() == 0) {
      System.err.println("No hay stock disponible");
      return null;
    }
    return libro;
  }

  public boolean validarDiasPrestamo(TipoUsuario tipoUsuario, int dias) {
    boolean result = true;
    if (tipoUsuario.esEstudiante() && dias > 10) {
      System.err.println("Estudiante no puede solicitar libro por mas de 10 dias");
      result = false;
    }

    if (tipoUsuario.esDocente() && dias > 20) {
      System.err.println("Docente no puede solicitar libro por mas de 20 dias");
      result = false;
    }

    return result;
  }

}
