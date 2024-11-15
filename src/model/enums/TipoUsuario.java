package model.enums;

import java.util.HashMap;
import java.util.Map;

public enum TipoUsuario {

  ESTUDIANTE("ESTUDIANTE"), DOCENTE("DOCENTE");

  private static final Map<String, TipoUsuario> mappedType = new HashMap<>();
  private final String code;

  static {
    for (var e : TipoUsuario.values()) {
      mappedType.put(e.getCode(), e);
    }
  }

  TipoUsuario(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public boolean esEstudiante() {
    return this.equals(ESTUDIANTE);
  }

  public boolean esDocente() {
    return this.equals(DOCENTE);
  }

  public static TipoUsuario fromCode(String code) {
    return mappedType.get(code.toUpperCase());
  }

}
