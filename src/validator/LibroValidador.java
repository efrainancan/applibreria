package validator;

import model.Libro;
import store.StoreManager;

public class LibroValidador {

  private static final StoreManager storeManager = StoreManager.getInstance();

  public Libro existe(String isbn) {
    var libroOptional = storeManager.getLibro(isbn);
    if (libroOptional.isEmpty()) {
      System.err.println("Libro no existe con ISBN: " + isbn);
      return null;
    }
    return libroOptional.get();
  }

  public boolean validadCantidadTotal(int cantidadTotal) {
    if (cantidadTotal > 0) {
      return true;
    }
    System.err.println("Cantidad total debe ser mayor a cero.");
    return false;
  }

  public boolean validadCantidadDisponible(int cantidadDisponible, int cantidadTotal) {
    boolean result = true;
    if (!(cantidadDisponible > 0)) {
      System.err.println("Cantidad disponible debe ser mayor a cero");
      result = false;
    }
    if (!(cantidadDisponible <= cantidadTotal)) {
      System.err.println("Cantidad disponible debe ser menor o igual a cantidad total.");
      result = false;
    }
    return result;
  }

}
