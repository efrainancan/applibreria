package validator;

import model.Usuario;
import model.enums.TipoUsuario;
import store.StoreManager;

public class UsuarioValidador extends BasicValidator {

  private static final StoreManager storeManager = StoreManager.getInstance();
  public final String[] allowed_genders = new String[] { "M", "F" };

  public Usuario existeUsuario(String RUN) {
    if (isBlank(RUN)) {
      System.err.println("RUN ingresado esta vacio");
      return null;
    }
    var usuarioOpt = storeManager.getUsuario(RUN);
    if (usuarioOpt.isEmpty()) {
      System.err.println("RUN no existe");
      return null;
    }
    return usuarioOpt.get();
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
      var tmpRut = rut.toUpperCase().replace(".", "").replace("-", "");
      int rutAux = Integer.parseInt(tmpRut.substring(0, tmpRut.length() - 1));

      char dv = tmpRut.charAt(rut.length() - 1);

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
