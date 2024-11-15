package model;

import model.enums.TipoUsuario;

public class Docente extends Usuario {

  private String profesion;
  private String gradoAcademico;

  public Docente(String RUN, String nombreCompleto, Character genero, String profesion, String gradoAcademico) {
    super(RUN, nombreCompleto, genero);
    this.profesion = profesion;
    this.gradoAcademico = gradoAcademico;
  }

  public String getProfesion() {
    return profesion;
  }

  public void setProfesion(String profesion) {
    this.profesion = profesion;
  }

  public String getGradoAcademico() {
    return gradoAcademico;
  }

  public void setGradoAcademico(String gradoAcademico) {
    this.gradoAcademico = gradoAcademico;
  }

  @Override
  public TipoUsuario getTipoUsuario() {
    return TipoUsuario.DOCENTE;
  }

  @Override
  public String toString() {
    return "model.Docente{" + "profesion='" + profesion + '\'' + ", gradoAcademico='" + gradoAcademico + '\'' + ", model.Usuario='" + super.toString() + '\'' + '}';
  }

}
