package validator;

import java.util.List;

import model.Libro;

public class LibroValidador {

  private final List<Libro> libroList;

  public LibroValidador(List<Libro> libroList) {
    this.libroList = libroList;
  }

  public Libro existe(String isbn) {
    var libroOptional = libroList.stream().filter(e -> e.getISBN().equalsIgnoreCase(isbn)).findFirst();
    if (libroOptional.isEmpty()) {
      System.err.println("Libro no existe con ISBN: " + isbn);
      return null;
    }
    return libroOptional.get();
  }

}
