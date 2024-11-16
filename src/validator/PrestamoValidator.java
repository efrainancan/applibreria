package validator;

import model.Libro;
import model.enums.TipoUsuario;

public class PrestamoValidator {

  private final LibroValidador libroValidador;

  public PrestamoValidator() {
    libroValidador = new LibroValidador();
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
