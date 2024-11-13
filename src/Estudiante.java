public class Estudiante extends  Usuario {
    private String carrera;

    public Estudiante(String RUN, String nombreCompleto, Character genero, String carrera) {
        super(RUN, nombreCompleto, genero);
        this.carrera=carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "carrera='" + carrera + '\'' +
                " Usuario='" + super.toString() + '\'' +
                '}';
    }
}
