import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE LA BIBLIOTECA ---");
            System.out.println("1. Ver estantes fijos");
            System.out.println("2. Gestionar libros nuevos");
            System.out.println("3. Gestionar préstamos");
            System.out.println("4. Gestionar devoluciones");
            System.out.println("5. Gestionar fila de atención");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    verEstantesFijos(biblioteca, sc);
                    break;
                case 2:
                    gestionarLibrosNuevos(biblioteca, sc);
                    break;
                case 3:
                    gestionarPrestamos(biblioteca, sc);
                    break;
                case 4:
                    gestionarDevoluciones(biblioteca, sc);
                    break;
                case 5:
                    gestionarFilaAtencion(biblioteca, sc);
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);

        sc.close();
    }

    // ESTANTES FIJOS (Arreglo)
    private static void verEstantesFijos(Biblioteca biblioteca, Scanner sc) {
        System.out.println("\n--- ESTANTES FIJOS ---");
        String[][] estantes = biblioteca.estantes.getEstantes();
        for (int i = 0; i < estantes.length; i++) {
            System.out.println("Sección " + (i + 1) + ":");
            for (int j = 0; j < estantes[i].length; j++) {
                System.out.println(" [" + i + "," + j + "]: " + estantes[i][j]);
            }
        }
        System.out.println("¿Desea editar (1) o eliminar (2) un libro? (otro número para regresar): ");
        int op = sc.nextInt();
        sc.nextLine();
        if (op == 1 || op == 2) {
            System.out.print("Fila: ");
            int fila = sc.nextInt();
            System.out.print("Columna: ");
            int col = sc.nextInt();
            sc.nextLine();
            if (op == 1) {
                System.out.print("Nuevo título: ");
                String nuevo = sc.nextLine();
                biblioteca.estantes.actualizarLibro(fila, col, nuevo);
            } else {
                biblioteca.estantes.eliminarLibro(fila, col);
                System.out.println("Libro eliminado.");
            }
        }
    }

    // LIBROS NUEVOS (ArrayList)
    private static void gestionarLibrosNuevos(Biblioteca biblioteca, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE LIBROS NUEVOS ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Ver libros");
            System.out.println("3. Editar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Sección: ");
                    String seccion = sc.nextLine();
                    biblioteca.nuevos.agregarLibro(new Libro(titulo, seccion));
                    break;
                case 2:
                    System.out.println("\n--- Libros Nuevos ---");
                    for (int i = 0; i < biblioteca.nuevos.verLibros().size(); i++) {
                        System.out.println(i + ". " + biblioteca.nuevos.verLibros().get(i));
                    }
                    break;
                case 3:
                    System.out.print("Índice del libro a editar: ");
                    int idxEdit = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String nuevoT = sc.nextLine();
                    System.out.print("Nueva sección: ");
                    String nuevaS = sc.nextLine();
                    biblioteca.nuevos.actualizarLibro(idxEdit, nuevoT, nuevaS);
                    break;
                case 4:
                    System.out.print("Índice del libro a eliminar: ");
                    int idxDel = sc.nextInt();
                    biblioteca.nuevos.eliminarLibro(idxDel);
                    break;
            }
        } while (opcion != 5);
    }

    // PRÉSTAMOS (Lista)
    private static void gestionarPrestamos(Biblioteca biblioteca, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Agregar préstamo");
            System.out.println("2. Ver préstamos");
            System.out.println("3. Editar préstamo");
            System.out.println("4. Eliminar préstamo");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Sección: ");
                    String seccion = sc.nextLine();
                    biblioteca.prestamos.agregarPrestamo(new Libro(titulo, seccion));
                    break;
                case 2:
                    System.out.println("\n--- Préstamos ---");
                    for (int i = 0; i < biblioteca.prestamos.verPrestamos().size(); i++) {
                        System.out.println(i + ". " + biblioteca.prestamos.verPrestamos().get(i));
                    }
                    break;
                case 3:
                    System.out.print("Índice a editar: ");
                    int idxE = sc.nextInt(); sc.nextLine();
                    System.out.print("Nuevo título: ");
                    String tNuevo = sc.nextLine();
                    System.out.print("Nueva sección: ");
                    String sNueva = sc.nextLine();
                    biblioteca.prestamos.actualizarPrestamo(idxE, tNuevo, sNueva);
                    break;
                case 4:
                    System.out.print("Índice a eliminar: ");
                    int idxX = sc.nextInt();
                    biblioteca.prestamos.eliminarPrestamo(idxX);
                    break;
            }
        } while (opcion != 5);
    }

    // DEVOLUCIONES (Pila)
    private static void gestionarDevoluciones(Biblioteca biblioteca, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE DEVOLUCIONES ---");
            System.out.println("1. Agregar devolución");
            System.out.println("2. Ver último libro devuelto");
            System.out.println("3. Revisar (quitar) libro devuelto");
            System.out.println("4. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Sección: ");
                    String seccion = sc.nextLine();
                    biblioteca.devoluciones.agregarDevolucion(new Libro(titulo, seccion));
                    break;
                case 2:
                    Libro ultimo = biblioteca.devoluciones.verUltimo();
                    System.out.println(ultimo == null ? "No hay libros." : ultimo);
                    break;
                case 3:
                    Libro revisado = biblioteca.devoluciones.revisarLibro();
                    System.out.println(revisado == null ? "Nada que revisar." : "Revisado: " + revisado);
                    break;
            }
        } while (opcion != 4);
    }

    // FILA DE ATENCIÓN (Cola)
    private static void gestionarFilaAtencion(Biblioteca biblioteca, Scanner sc) {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE FILA DE ATENCIÓN ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Ver quién sigue");
            System.out.println("3. Atender persona");
            System.out.println("4. Regresar");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    biblioteca.fila.agregarPersona(nombre);
                    break;
                case 2:
                    String siguiente = biblioteca.fila.verSiguiente();
                    System.out.println(siguiente == null ? "Nadie en la fila." : "Siguiente: " + siguiente);
                    break;
                case 3:
                    String atendido = biblioteca.fila.atenderPersona();
                    System.out.println(atendido == null ? "Fila vacía." : "Atendido: " + atendido);
                    break;
            }
        } while (opcion != 4);
    }
}
