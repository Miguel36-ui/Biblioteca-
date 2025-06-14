import java.util.ArrayList;

public class Prestamos {
    private ArrayList<Libro> prestamos;

    public Prestamos() {
        prestamos = new ArrayList<>();
    }

    public void agregarPrestamo(Libro libro) {
        prestamos.add(libro);
    }

    public ArrayList<Libro> verPrestamos() {
        return prestamos;
    }

    public void actualizarPrestamo(int index, String nuevoTitulo, String nuevaSeccion) {
        prestamos.get(index).setTitulo(nuevoTitulo);
        prestamos.get(index).setSeccion(nuevaSeccion);
    }

    public void eliminarPrestamo(int index) {
        prestamos.remove(index);
    }
}
