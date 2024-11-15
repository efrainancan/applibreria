package model;

import model.enums.TipoUsuario;

public abstract class Usuario {

  public static final String PRESTAMO_OK = "0";

  private String RUN;
  private String nombreCompleto;
  private Character genero;
  private String prestamo;

  public Usuario(String RUN, String nombreCompleto, Character genero) {
    this.RUN = RUN;
    this.nombreCompleto = nombreCompleto;
    this.genero = genero;
    this.prestamo = PRESTAMO_OK;
  }

  public String getRUN() {
    return RUN;
  }

  public void setRUN(String RUN) {
    this.RUN = RUN;
  }

  public String getNombreCompleto() {
    return nombreCompleto;
  }

  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }

  public Character getGenero() {
    return genero;
  }

  public void setGenero(Character genero) {
    this.genero = genero;
  }

  public abstract TipoUsuario getTipoUsuario();

  public String getPrestamo() {
    return prestamo;
  }

  public void setPrestamo(String prestamo) {
    this.prestamo = prestamo;
  }

  @Override
  public String toString() {
    return "Usuario{" + "RUN='" + RUN + '\'' + ", nombreCompleto='" + nombreCompleto + '\'' + ", genero=" + genero + '}';
  }

}
