public class EstantesFijos {
    private String[][] estantes;

    public EstantesFijos() {
        estantes = new String[3][3]; // 3 secciones con 3 libros cada una
        estantes[0][0] = "1984";
        estantes[0][1] = "Don Quijote";
        estantes[0][2] = "La Odisea";
        estantes[1][0] = "Cien Años de Soledad";
        estantes[1][1] = "El Principito";
        estantes[1][2] = "Hamlet";
        estantes[2][0] = "Crimen y Castigo";
        estantes[2][1] = "Drácula";
        estantes[2][2] = "Frankenstein";
    }

    public String[][] getEstantes() {
        return estantes;
    }

    public void actualizarLibro(int fila, int col, String nuevo) {
        estantes[fila][col] = nuevo;
    }

    public void eliminarLibro(int fila, int col) {
        estantes[fila][col] = null;
    }
}
