package ui;

import model.Libro;
import store.StoreManager;
import validator.LibroValidador;

public class LibroCLIDelegate extends BaseCLI {

  private static final StoreManager storeManager = StoreManager.getInstance();
  private final LibroValidador libroValidador;

  public LibroCLIDelegate() {
    libroValidador = new LibroValidador();
  }

  public void run() {
    do {
      int opcion = leerOpcion();
      if (opcion == 0) {
        return;
      }

      switch (opcion) {
        case 1 -> agregarLibro();
        case 2 -> mostrarLibros();
        case 3 -> eliminarLibros();
        default -> br("opcion no valida.");
      }
    } while (true);
  }

  public int leerOpcion() {
    return promptInt("""
        Que operacion desea realizar sobre Libro
        0. Salir
        1. Agregar Libro
        2. Listar Libros
        3. Eliminar Libro
        """);
  }

  public void agregarLibro() {
    System.out.println("Ingrese datos de los libros");
    String isbn = prompt("ISBN: ");

    if (!libroValidador.checkLibroNoExiste(isbn)) {
      return;
    }

    int cantidadTotal = promptInt("Cantidad total en biblioteca: ");
    if (!libroValidador.validadCantidadTotal(cantidadTotal)) {
      return;
    }

    int cantidadDisponible = promptInt("Cantidad disponible: ");
    if (!libroValidador.validadCantidadDisponible(cantidadDisponible, cantidadTotal)) {
      return;
    }

    String titulo = prompt("Nombre del Libro: ");
    String autor = prompt("Autor: ");
    String imagenUrl = prompt("Url del la imagen: ");
    storeManager.add(new Libro(isbn, titulo, autor, cantidadTotal, cantidadDisponible, imagenUrl));
    br("Libro guardado exitosamente.");
  }

  public void mostrarLibros() {
    var listaLibros = storeManager.getLibroStore();
    System.out.println("Hay " + listaLibros.size() + " libro(s) en memoria");
    listaLibros.forEach(System.out::println);
    br();
  }

  public void eliminarLibros() {
    String isbn = prompt("Qué libro (ISBN) desea eliminar?: ");

    var libroOpt = storeManager.getLibro(isbn);
    if (libroOpt.isEmpty()) {
      System.err.println("libro no existe");
      return;
    }

    if (storeManager.remove(libroOpt.get())) {
      br("Registro eliminado");
    }
  }

}
