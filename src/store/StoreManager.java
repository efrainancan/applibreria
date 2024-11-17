package store;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import model.Devolucion;
import model.Libro;
import model.Prestamo;
import model.Usuario;

public class StoreManager {

  private static StoreManager INSTANCE;
  private final List<Usuario> usuarioStore;
  private final List<Libro> libroStore;
  private final List<Prestamo> prestamoStore;
  private final List<Devolucion> devolucionStore;

  private StoreManager() {
    usuarioStore = new LinkedList<>();
    prestamoStore = new LinkedList<>();
    libroStore = new LinkedList<>();
    devolucionStore = new LinkedList<>();
  }

  public static StoreManager getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new StoreManager();
    }
    return INSTANCE;
  }

  public List<Usuario> getUsuarioStore() {
    return usuarioStore;
  }

  public List<Libro> getLibroStore() {
    return libroStore;
  }

  public List<Prestamo> getPrestamosStore() {
    return prestamoStore;
  }

  public Optional<Libro> getLibro(String key) {
    return libroStore.stream().filter(e -> e.getISBN().equalsIgnoreCase(key)).findFirst();
  }

  public void add(Usuario usuario) {
    if (existsUsuario(usuario.getRUN())) {
      throw new EntityAlreadyExistsException("Usuario con RUN ya existe: " + usuario.getRUN());
    }
    usuarioStore.add(usuario);
  }

  public void add(Libro libro) {
    if (existsLibro(libro.getISBN())) {
      throw new EntityAlreadyExistsException("Libro con ISBN ya existe: " + libro.getISBN());
    }
    libroStore.add(libro);
  }

  public void add(Devolucion devolucion) {
    devolucionStore.add(devolucion);
  }

  public void add(Prestamo prestamo) {
    prestamoStore.add(prestamo);
  }

  public boolean remove(Usuario usuario) {
    return usuarioStore.remove(usuario);
  }

  public boolean remove(Libro libro) {
    return libroStore.remove(libro);
  }

  public boolean existsUsuario(String key) {
    return usuarioStore.stream().anyMatch(u -> u.getRUN().equals(key));
  }

  public boolean existsLibro(String key) {
    return libroStore.stream().anyMatch(u -> u.getISBN().equals(key));
  }

  public Optional<Usuario> getUsuario(String key) {
    return usuarioStore.stream().filter(u -> u.getRUN().equals(key)).findFirst();
  }

  public Optional<Prestamo> getPrestamoMasReciente(String userKey, String bookKey) {
    return prestamoStore.stream().filter(p -> p.getUsuario().getRUN().equals(userKey) && p.getLibro().getISBN().equals(bookKey)).max(Comparator.comparing(Prestamo::getFechaPrestamo));
  }

  public void agregarCantidadDisponible(Libro libro, int cantidad) {
    int cantidadActual = libro.getCantidadDisponible();
    libro.setCantidadDisponible(cantidadActual + cantidad);
  }

  public void prestarLibro(Usuario usuario, String isbn) {
    usuario.setPrestamo(isbn);
  }

}
