package model;

import java.time.LocalDate;

public class Devolucion {

  private Usuario usuario;
  private Libro libro;
  private Prestamo prestamo;
  private LocalDate fechaDevolucion;

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

  public Prestamo getPrestamo() {
    return prestamo;
  }

  public void setPrestamo(Prestamo prestamo) {
    this.prestamo = prestamo;
  }

  public LocalDate getFechaDevolucion() {
    return fechaDevolucion;
  }

  public void setFechaDevolucion(LocalDate fechaDevolucion) {
    this.fechaDevolucion = fechaDevolucion;
  }

  public int calcularPrestamo(int valorMultaPorDia) {
    var fechaVencimiento = prestamo.getFechaPrestamo().plusDays(prestamo.getDiasPrestamo());
    int monto = 0;
    if (fechaDevolucion.isAfter(fechaVencimiento)) {
      monto = fechaVencimiento.until(fechaDevolucion).getDays() * valorMultaPorDia;
    }
    return monto;
  }

  @Override
  public String toString() {
    return "model.Devolucion{" + "usuario=" + usuario + ", libro=" + libro + ", prestamo=" + prestamo + ", fechaDevolucion=" + fechaDevolucion + '}';
  }

}
