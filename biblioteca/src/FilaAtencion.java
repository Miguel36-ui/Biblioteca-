import java.util.LinkedList;
import java.util.Queue;

public class FilaAtencion {
    private Queue<String> fila;

    public FilaAtencion() {
        fila = new LinkedList<>();
    }

    public void agregarPersona(String nombre) {
        fila.offer(nombre);
    }

    public String verSiguiente() {
        return fila.peek();
    }

    public String atenderPersona() {
        return fila.poll();
    }
}
