package PracticasEnClase;

import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double subtotal = 0.0;

        while (true) {

            System.out.print("Precio (0 para terminar): ");

            if (!sc.hasNextDouble()) {
                System.out.println("Entrada inválida");
                sc.close();
                return;
            }

            double p = sc.nextDouble();

            // Si p es 0 entonces termina captura
            if (p == 0) {
                break;
            }

            if (!service.esPrecioValido(p)) {
                System.out.println("Precio inválido");
                continue;
            }

            subtotal = service.calcularSubtotal(subtotal, p);
        }

        System.out.println("Método de pago: 1) Efectivo  2) Tarjeta");

        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }

        int metodo = sc.nextInt();

        // Validación método 1 o 2
        if (metodo != 1 && metodo != 2) {
            System.out.println("Método inválido");
            sc.close();
            return;
        }

        double descuento = service.calcularDescuento(subtotal, metodo);
        double total = service.calcularTotal(subtotal, descuento);

        System.out.println("=== TICKET ===");
        System.out.printf("Subtotal: %.2f\n", subtotal);
        System.out.printf("Descuento: %.2f\n", descuento);
        System.out.printf("Total: %.2f\n", total);
        
        sc.close();
    }
}

