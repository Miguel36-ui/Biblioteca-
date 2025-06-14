public class Libro {
    private String titulo;
    private String seccion;

    public Libro(String titulo, String seccion) {
        this.titulo = titulo;
        this.seccion = seccion;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Sección: " + seccion;
    }
}
