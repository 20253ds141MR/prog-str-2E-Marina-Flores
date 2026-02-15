package AlumnosCRUD;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static SistemaAlumnos sistema = new SistemaAlumnos();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1:
                    opcionAlta();
                    break;
                case 2:
                    opcionBuscar();
                    break;
                case 3:
                    opcionActualizar();
                    break;
                case 4:
                    opcionBaja();
                    break;
                case 5:
                    sistema.listarActivos();
                    break;
                case 6:
                    sistema.mostrarReportes();
                    break;
                case 0:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    static void mostrarMenu() {
        System.out.println("\n------- MENÚ ALUMNOS -------");
        System.out.println("1. Alta alumno");
        System.out.println("2. Buscar por ID");
        System.out.println("3. Actualizar mediante el ID");
        System.out.println("4. Baja lógica por ID");
        System.out.println("5. Lista de alumnos");
        System.out.println("6. Reportes");
        System.out.println("Si desea salir ingrese 0");
    }

    static void opcionAlta() {
        int id = leerEntero("ID: ");
        System.out.print("Nombre del alumno: ");
        String nombre = sc.nextLine();
        double promedio = leerDouble("Promedio (0 a 10): ");

        boolean ok = sistema.altaAlumno(id, nombre, promedio);

        if (ok) {
            System.out.println("Alumno dado de alta correctamente.");
        } else {
            System.out.println("No se logro dar de alta.");
        }
    }

    static void opcionBuscar() {
        int id = leerEntero("ID a buscar: ");
        Alumno a = sistema.buscarActivoPorId(id);

        if (a == null) {
            System.out.println("No encontrado, el alumno no existe o se encuentra inactivo.");
        } else {
            System.out.println("ID: " + a.ID);
            System.out.println("Nombre: " + a.nombre);
            System.out.println("Promedio: " + a.promedio);
            System.out.println("Activo: " + a.activo);
        }
    }

    static void opcionActualizar() {
        int id = leerEntero("ID del alumno: ");
        double nuevo = leerDouble("Nuevo promedio que desea ingresar: ");

        boolean ok = sistema.actualizarPromedioActivo(id, nuevo);

        if (ok) {
            System.out.println("Promedio actualizado correctamente.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
    }

    static void opcionBaja() {
        int id = leerEntero("ID del alumno a dar de baja: ");
        int resultado = sistema.bajaLogica(id);

        if (resultado == 1) {
            System.out.println("Alumno dado de baja con exito.");
        } else {
            System.out.println("No existe ese alumno.");
        }
    }

    static int leerEntero(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String linea = sc.nextLine();
                return Integer.parseInt(linea);
            } catch (Exception e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    static double leerDouble(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String linea = sc.nextLine();
                return Double.parseDouble(linea);
            } catch (Exception e) {
                System.out.println("Ingresa un número válido.");
            }
        }
    }
}