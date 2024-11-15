package ui;

import java.util.List;

import model.Docente;
import model.Estudiante;
import model.Usuario;
import model.enums.TipoUsuario;
import validator.UsuarioValidador;

public class UsuarioCLIDelegate extends BaseCLI {

  private final UsuarioValidador validador;
  private final List<Usuario> listaUsuarios;

  public UsuarioCLIDelegate(List<Usuario> listaUsuarios) {
    validador = new UsuarioValidador(listaUsuarios);
    this.listaUsuarios = listaUsuarios;
  }

  public void run() {
    boolean isRunning = true;
    while (isRunning) {
      var prompt = prompt("Que operacion desea realizar sobre usuarios (agregar, listar, eliminar, salir)");
      switch (prompt.toLowerCase()) {
        case "salir" -> isRunning = false;
        case "agregar" -> agregar();
        case "listar" -> listar();
        case "eliminar" -> eliminar();
        default -> {
          br("Opcion no valida");
          isRunning = false;
        }
      }
    }
  }

  public void agregar() {
    System.out.println("Ingrese datos del usuario");
    String run = prompt("Ingrese RUN: ");
    while (!validador.validarRut(run)) {
      run = prompt("Run no valido, ingrese nuevamente: ");
    }

    String nombre = prompt("Nombre completo: ");
    String genero = prompt("Genero (Valores validos son " + validador.getValidGenders() + "): ");
    while (!validador.isGenderOk(genero)) {
      genero = prompt("Genero ingreado no valido, ingrese nuevamente: ");
    }

    String tipoUsuario = prompt("Selecctione el tipo de usuario (Estudiante, Docente): ");
    while (!validador.esTipoUsuarioPermitido(tipoUsuario)) {
      tipoUsuario = prompt("Selecctione el tipo de usuario (Estudiante, Docente): ");
    }

    var tipoUsuarioEnum = TipoUsuario.fromCode(tipoUsuario);
    if (tipoUsuarioEnum.esEstudiante()) {
      String carrera = prompt("Carrera: ");
      listaUsuarios.add(new Estudiante(run, nombre, genero.charAt(0), carrera));
    } else {
      String profesion = prompt("Profesion: ");
      String gradoAcademico = prompt("Grado Academico: ");
      listaUsuarios.add(new Docente(run, nombre, genero.charAt(0), profesion, gradoAcademico));
    }
  }

  public void listar() {
    System.out.println("Hay " + listaUsuarios.size() + " estudiantes en la lista");
    listaUsuarios.forEach(System.out::println);
    br();
  }

  public void eliminar() {
    String rut = prompt("Ingrese Rut de usuario a eliminar: ");
    boolean wasRemoved = listaUsuarios.removeIf(u -> u.getRUN().equalsIgnoreCase(rut));
    if (!wasRemoved) {
      showError("usuario eliminado");
    }
    br();
  }

}
