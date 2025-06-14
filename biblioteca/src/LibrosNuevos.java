import java.util.ArrayList;

public class LibrosNuevos {
    private ArrayList<Libro> nuevos;

    public LibrosNuevos() {
        nuevos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        nuevos.add(libro);
    }

    public ArrayList<Libro> verLibros() {
        return nuevos;
    }

    public void actualizarLibro(int index, String nuevoTitulo, String nuevaSeccion) {
        nuevos.get(index).setTitulo(nuevoTitulo);
        nuevos.get(index).setSeccion(nuevaSeccion);
    }

    public void eliminarLibro(int index) {
        nuevos.remove(index);
    }
}
