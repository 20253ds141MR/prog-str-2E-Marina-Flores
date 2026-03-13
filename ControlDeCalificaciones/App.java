package ControlDeCalificaciones;

import java.util.Scanner;

public class App {

    
    public static String leerTextoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    public static double leerDoubleRango(Scanner sc, String msg, double min, double max) {
        double num;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                num = sc.nextDouble();
                sc.nextLine(); 
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.printf("El valor debe estar entre %.2f y %.2f%n", min, max);
            } else {
                System.out.println("Ingresa un número válido (usa punto decimal).");
                sc.nextLine(); 
            }
        }
    }

    public static int leerEnteroRango(Scanner sc, String msg, int min, int max) {
        int num;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine(); 
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.printf("El valor debe estar entre %d y %d%n", min, max);
            } else {
                System.out.println("Ingresa un entero válido.");
                sc.nextLine();
        }}
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String texto = sc.nextLine().trim().toLowerCase();
            if (texto.equals("true") || texto.equals("false")) {
                return Boolean.parseBoolean(texto);
            }

            System.out.println("Responde: true/false");
        }
    }

    public static void imprimirReporte(
            String nombre,
            double c1, double c2, double c3,
            double promedio,
            int asistencia,
            boolean entregoProyecto,
            double finalCal,
            String estado) {

        System.out.println("\n---------- Reporte ----------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Parciales: " + c1 + ", " + c2 + ", " + c3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.println("Calificación final: " + finalCal);
        System.out.println("Estado: " + estado);
        System.out.println("-----------------------------");
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String nombre = leerTextoVacio(sc, "Nombre del alumno: ");
            double c1 = leerDoubleRango(sc, "Calificación del parcial 1 (0 a 100): ", 0, 100);
            double c2 = leerDoubleRango(sc, "Calificación del parcial 2 (0 a 100): ", 0, 100);
            double c3 = leerDoubleRango(sc, "Calificación del parcial 3 (0 a 100): ", 0, 100);

            int asistencia = leerEnteroRango(sc, "Porcentaje de asistencia: ", 0, 100);
            boolean entregoProyecto = leerBoolean(sc, "¿El alumno entregó su proyecto? (true/false): ");

            GradeService gs = new GradeService();
            double promedio = gs.calcularPromedio(c1, c2, c3);
            double finalCal = gs.calcularFinal(promedio, asistencia);
            String estado = gs.determinarEstado(finalCal, asistencia, entregoProyecto);

            imprimirReporte(nombre, c1, c2, c3, promedio, asistencia, entregoProyecto, finalCal, estado);
        } finally {
            sc.close();
        }
    }
}
