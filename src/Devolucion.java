import java.util.Date;

public class Devolucion {

    private Usuario usuario;
    private Libro libro;
    private Prestamo prestamo;
    private Date fechaDevolucion;

    public Devolucion(Usuario usuario, Libro libro, Prestamo prestamo, Date fechaDevolucion) {
        this.usuario = usuario;
        this.libro = libro;
        this.prestamo = prestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "usuario=" + usuario +
                ", libro=" + libro +
                ", prestamo=" + prestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
