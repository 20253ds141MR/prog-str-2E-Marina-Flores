
package GitConflictoFloresMarina;

import java.util.Scanner;

public class Main {

    public static final double IVA = 0.16;
    public static final double DESCUENTO = 0.10;
    public static final double UMBRAL_DESCUENTO = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Subtotal: ");

        // 1) Aplica IVA al subtotal
        double total = calcularTotalConIva(subtotal);

        // 2) Si el subtotal original supera el umbral, aplica descuento sobre el total actual
        total = aplicarDescuentoSiAplica(total, subtotal);

        System.out.printf("Total a pagar: %.2f%n", total);
    }

    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    // Aplica el IVA al subtotal
    public static double calcularTotalConIva(double subtotal) {
        return subtotal + (subtotal * IVA);
    }

    // Si el subtotal original supera el umbral, aplica descuento al total actual
    public static double aplicarDescuentoSiAplica(double total, double subtotal) {
        if (subtotal > UMBRAL_DESCUENTO) {
            total = total - (total * DESCUENTO);
        }
        return total;
    }
}

