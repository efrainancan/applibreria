package model;

public class Libro {

  private String ISBN;
  private String titulo;
  private String author;
  private Integer cantidadDisponible;
  private Integer cantidadTotal;
  private String imagen;

  public Libro(String ISBN, String titulo, String author, Integer cantidadTotal, Integer cantidadDisponible, String imagen) {
    this.ISBN = ISBN;
    this.titulo = titulo;
    this.author = author;
    this.cantidadTotal = cantidadTotal;
    this.cantidadDisponible = cantidadDisponible;
    this.imagen = imagen;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Integer getCantidadTotal() {
    return cantidadTotal;
  }

  public void setCantidadTotal(Integer cantidadTotal) {
    this.cantidadTotal = cantidadTotal;
  }

  public Integer getCantidadDisponible() {
    return cantidadDisponible;
  }

  public void setCantidadDisponible(Integer cantidadDisponible) {
    this.cantidadDisponible = cantidadDisponible;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  @Override
  public String toString() {
    return "Libro {" + "ISBN='" + ISBN + '\'' + ", titulo='" + titulo + '\'' + ", author='" + author + '\'' + ", cantidadTotal=" + cantidadTotal + ", cantidadDisponible=" + cantidadDisponible + ", imagen='" + imagen + '\'' + '}';
  }

}
