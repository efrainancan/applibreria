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
    public void ValidarRun(){
        int contador;
        contador=2;
        Acumulador=0;
        while (RUN!=0){
            Multiplo=(RUN%10)*contador;
            Acumulador=Acumulador+Multiplo;
            RUN=RUN/10;
            contador=contador++;
            if(contador==8){
                contador=2;
            }
        }
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
