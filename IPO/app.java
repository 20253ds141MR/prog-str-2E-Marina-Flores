package IPO;

import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;

public class app {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculos calc = new Calculos();
        double peso = leerDoubleEnRango(sc, "Ingresa el peso en kg (0.1 a 50.0): ", 0.1, 50.0);
        int distancia = leerIntEnRango(sc, "Ingresa la distancia en km (1 a 2000): ", 1, 2000);
        int servicio = leerIntEnRango(sc, "Tipo de servicio (1 -> Estándar, 2 -> Express): ", 1, 2);
        boolean zona = leerBoolean(sc, "¿Zona remota? (true/false): ");

        double subtotal = calc.calcularSubtotal(peso, distancia, servicio, zona);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva);

        imprimirTicket(peso, distancia, servicio, zona, subtotal, iva, total);
        sc.close();
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        while (true) {
            System.out.print(msg);
            String linea = sc.nextLine().trim();
            try {
                double valor = Double.parseDouble(linea);
                if (valor >= min && valor <= max) return valor;
                System.out.println("Fuera de rango. Intenta de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Escribe un número decimal.");
            }
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            String linea = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(linea);
                if (valor >= min && valor <= max) return valor;
                System.out.println("Fuera de rango. Intenta de nuevo.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Escribe un número entero.");
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String linea = sc.nextLine().trim().toLowerCase(Locale.ROOT);
            if (linea.equals("true")) return true;
            if (linea.equals("false")) return false;
            System.out.println("Escribe exactamente true o false.");
        }
    }

    public static void imprimirTicket(double peso, int distancia, int tipoServicio, boolean zonaRemota,
                                      double subtotal, double iva, double total) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String[] nombres = {"", "Estándar", "Express"};
        String servicio = nombres[Math.max(0, Math.min(tipoServicio, 2))];

        System.out.println();
        System.out.println("------ TICKET ------");
        System.out.println("Servicio: " + servicio);
        System.out.println("Peso (kg): " + peso);
        System.out.println("Distancia (km): " + distancia);
        System.out.println("Zona remota: " + (zonaRemota ? "Sí" : "No"));
        System.out.println("--------------------");
        System.out.println("Subtotal: $" + df.format(subtotal));
        System.out.println("IVA (16%): $" + df.format(iva));
        System.out.println("Total:    $" + df.format(total));
        System.out.println("--------------------");
        System.out.println();
    }
}