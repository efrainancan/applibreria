package model;

import java.time.LocalDate;

public class Prestamo {

  private Usuario usuario;
  private Libro libro;
  private Integer diasPrestamo;
  private Devolucion devolucion;
  private LocalDate fechaPrestamo;

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public Libro getLibro() {
    return libro;
  }

  public void setLibro(Libro libro) {
    this.libro = libro;
  }

  public Integer getDiasPrestamo() {
    return diasPrestamo;
  }

  public void setDiasPrestamo(Integer diasPrestamo) {
    this.diasPrestamo = diasPrestamo;
  }

  public Devolucion getDevolucion() {
    return devolucion;
  }

  public void setDevolucion(Devolucion devolucion) {
    this.devolucion = devolucion;
  }

  public LocalDate getFechaPrestamo() {
    return fechaPrestamo;
  }

  public void setFechaPrestamo(LocalDate fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
  }

}
