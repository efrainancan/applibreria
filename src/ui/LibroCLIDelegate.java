package ui;

import java.util.List;

import model.Libro;

public class LibroCLIDelegate extends BaseCLI {

  private final List<Libro> listaLibros;

  public LibroCLIDelegate(List<Libro> listLibros) {
    this.listaLibros = listLibros;
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
    String titulo = prompt("Nombre del Libro: ");
    String autor = prompt("Autor: ");
    int cantidadTotal = promptInt("Cantidad total: ");
    int cantidadDisponible = promptInt("Cantidad disponible: ");
    String imagenUrl = prompt("Url del la imagen: ");
    listaLibros.add(new Libro(isbn, titulo, autor, cantidadTotal, cantidadDisponible, imagenUrl));
    br("Libro guardado");
  }

  public void mostrarLibros() {
    System.out.println("Hay " + listaLibros.size() + " libros en memoria");
    listaLibros.forEach(System.out::println);
    br();
  }

  public void eliminarLibros() {
    String isbn = prompt("Qué libro (ISBN) desea eliminar?");
    var wasDeleted = listaLibros.removeIf(libro -> libro.getISBN().equals(isbn));
    if (wasDeleted) {
      br("Registro eliminado");
    } else {
      br("Libro (ISBN) no encontrado");
    }
  }

}
