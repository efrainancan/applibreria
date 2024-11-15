package validator;

import java.util.List;

import model.Usuario;
import model.enums.TipoUsuario;

public class UsuarioValidador extends BasicValidator {

  public final String[] allowed_genders = new String[] { "M", "F" };

  private final List<Usuario> usuarioList;

  public UsuarioValidador(List<Usuario> usuarioList) {
    this.usuarioList = usuarioList;
  }

  public Usuario validarUsuario(String RUN) {
    var usuario = usuarioList.stream().filter(e -> e.getRUN().equalsIgnoreCase(RUN)).findFirst();
    if (usuario.isEmpty()) {
      System.err.println("RUN no existe");
      return null;
    }
    return usuario.get();
  }

  public boolean isGenderOk(String gender) {
    return !isBlank(gender) && inArray(allowed_genders, gender.toUpperCase());
  }

  public String getValidGenders() {
    return String.join(", ", allowed_genders);
  }

  public boolean esTipoUsuarioPermitido(String tipoUsuario) {
    return TipoUsuario.fromCode(tipoUsuario) != null;
  }

  public boolean validarRut(String rut) {
    boolean validacion = false;
    try {
      rut = rut.toUpperCase();
      rut = rut.replace(".", "");
      rut = rut.replace("-", "");
      int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

      char dv = rut.charAt(rut.length() - 1);

      int m = 0, s = 1;
      for (; rutAux != 0; rutAux /= 10) {
        s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
      }
      if (dv == (char) (s != 0 ? s + 47 : 75)) {
        validacion = true;
      }

    } catch (Exception e) {
    }

    return validacion;
  }

}
