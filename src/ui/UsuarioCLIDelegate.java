package ui;

import model.Docente;
import model.Estudiante;
import model.enums.TipoUsuario;
import store.StoreManager;
import validator.UsuarioValidador;

public class UsuarioCLIDelegate extends BaseCLI {

  private static final StoreManager storeManager = StoreManager.getInstance();
  private final UsuarioValidador validador;

  public UsuarioCLIDelegate() {
    validador = new UsuarioValidador();
  }

  public void run() {
    boolean isRunning = true;
    while (isRunning) {
      var prompt = prompt("Que operacion desea realizar sobre usuarios (agregar, listar, eliminar, salir)");
      switch (prompt.toLowerCase()) {
        case "salir" -> isRunning = false;
        case "agregar" -> agregar();
        case "editar" -> editar();
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

    var nombre = prompt("Nombre completo: ");
    var genero = promptGeneroValido();
    var tipoUsuario = prompt("Selecctione el tipo de usuario (Estudiante, Docente): ");
    while (!validador.esTipoUsuarioPermitido(tipoUsuario)) {
      tipoUsuario = prompt("Selecctione el tipo de usuario (Estudiante, Docente): ");
    }

    var tipoUsuarioEnum = TipoUsuario.fromCode(tipoUsuario);
    if (tipoUsuarioEnum.esEstudiante()) {
      String carrera = prompt("Carrera: ");
      storeManager.add(new Estudiante(run, nombre, genero, carrera));
    } else {
      String profesion = prompt("Profesion: ");
      String gradoAcademico = prompt("Grado Academico: ");
      storeManager.add(new Docente(run, nombre, genero, profesion, gradoAcademico));
    }
  }

  public void editar() {
    System.out.println("Ingrese datos del usuario");
    String run = prompt("Ingrese RUN: ");
    var usuario = validador.existeUsuario(run);
    if (usuario == null) {
      return;
    }

    usuario.setNombreCompleto(prompt("Nombre completo: "));
    usuario.setGenero(promptGeneroValido());
    br("Usuario actualizado con exito");
  }

  public void listar() {
    var listaUsuarios = storeManager.getUsuarioStore();
    System.out.println("Hay " + listaUsuarios.size() + " estudiantes en la lista");
    listaUsuarios.forEach(System.out::println);
    br();
  }

  public void eliminar() {
    var run = prompt("Ingrese RUN de usuario a eliminar: ");
    var usuario = validador.existeUsuario(run);
    if (usuario == null) {
      return;
    }

    if (storeManager.remove(usuario)) {
      br("usuario eliminado");
    }
  }

  private Character promptGeneroValido() {
    String genero = prompt("Genero (Valores validos son " + validador.getValidGenders() + "): ");
    while (!validador.isGenderOk(genero)) {
      genero = prompt("Genero ingreado no valido, ingrese nuevamente: ");
    }
    return genero.charAt(0);
  }

}
