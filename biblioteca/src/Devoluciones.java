import java.util.Stack;

public class Devoluciones {
    private Stack<Libro> pila;

    public Devoluciones() {
        pila = new Stack<>();
    }

    public void agregarDevolucion(Libro libro) {
        pila.push(libro);
    }

    public Libro verUltimo() {
        return pila.isEmpty() ? null : pila.peek();
    }

    public Libro revisarLibro() {
        return pila.isEmpty() ? null : pila.pop();
    }
}
