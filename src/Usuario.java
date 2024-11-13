public abstract class Usuario {
    private String RUN;
    private String nombreCompleto;
    private Character genero;

    public Usuario(String RUN, String nombreCompleto, Character genero) {
        this.RUN = RUN;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "RUN='" + RUN + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", genero=" + genero +
                '}';
    }

    public String getRUN() {
        return RUN;
    }

    public void setRUN(String RUN) {
        this.RUN = RUN;
    }
    /*
    //mejorar
    public static boolean validarRut(String rut) {

        boolean validacion = false;
        try {
            rut =  rut.toUpperCase();
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

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }
    */
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
}
