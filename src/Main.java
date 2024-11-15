import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

  private static final List<Libro> books = new LinkedList<>();

  public static void main(String... args) throws IOException {
    int option = 0;
    do {
      printMenu();
      option = readOption();
      switch (option) {
        case 0: break;
        case 1: {
          books.add(addBook());
          break;
        }
        case 2: {
        }
        case 3: {
          printBooks();
        }
      }
    } while(option != 0);
    System.out.println("Programa finalizado");
  }

  public static void printMenu() {
    System.out.println("Ingrese una opcion para hacer algo");
    System.out.println("0. Cerrar programa");
    System.out.println("1. Agregar libro");
    System.out.println("2. Prestar libro");
    System.out.println("3. Listar libros");
  }

  public static Libro addBook() throws IOException {
    System.out.println("Ingrese datos de los libros");
    System.out.print("ISBN: ");
    String isbn = readStrOption();
    System.out.print("Nombre del Libro: ");
    String titulo = readStrOption();
    System.out.print("Autor: ");
    String autor = readStrOption();
    System.out.print("Url del la imagen: ");
    String imagenUrl = readStrOption();
    return new Libro(isbn, titulo, autor, 1,1, imagenUrl);
  }

  public static void printBooks() {
    System.out.println("Hay " + books.size() + " libros en memoria");
    books.forEach(System.out::println);
  }

  public static int readOption() throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    return Integer.parseInt(br.readLine());
  }

  public static String readStrOption() throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    return br.readLine();
  }

}
