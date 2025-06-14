public class Biblioteca {
    EstantesFijos estantes;
    LibrosNuevos nuevos;
    Prestamos prestamos;
    Devoluciones devoluciones;
    FilaAtencion fila;

    public Biblioteca() {
        estantes = new EstantesFijos();
        nuevos = new LibrosNuevos();
        prestamos = new Prestamos();
        devoluciones = new Devoluciones();
        fila = new FilaAtencion();
    }
}
