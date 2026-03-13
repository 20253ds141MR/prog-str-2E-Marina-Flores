package Biblioteca;
import java.util.Scanner;

public class RentaBicicletas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Horas de renta (int) ---
        System.out.print("Horas de renta (entero): ");
        // Si no hay int: "Entrada inválida" y return
        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        // FALTA 2: leer horas con nextInt()
        int horas = sc.nextInt() ;
        sc.nextLine(); // consumir salto de línea

        // Validar horas >= 0
        if (!validarHoras(horas)) {
            System.out.println("Horas inválidas");
            sc.close();
            return;
        }

        // --- Tarifa por hora ---
        System.out.print("Tarifa por hora: ");
        // Si no hay double: "Entrada inválida" y return
        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        // FALTA 5: leer tarifa con nextDouble()
        double tarifa = sc.nextDouble() ;
        sc.nextLine(); // consumir salto de línea

        // Validar tarifa > 0
        if (!validarTarifa(tarifa)) {
            System.out.println("Tarifa inválida");
            sc.close();
            return;
        }

        // --- ¿Cuenta con cupón de descuento? (boolean) ---
        System.out.print("¿Cuenta con cupón de descuento? (true/false): ");
        // Si no hay boolean: "Entrada inválida" y return
        if (!sc.hasNextBoolean()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        // FALTA 8: leer boolean con nextBoolean()
        boolean tieneBoleto = sc.hasNextBoolean();
        sc.nextLine(); // consumir salto de línea

        // --- Cálculo base ---
        // 4) subtotal = horas * tarifa
        double subtotal = horas * tarifa ;

        // 5) Si horas > 10: 12% de descuento
        double trasDescHoras = aplicarDescuentoHoras(subtotal, horas) ;

        // 6) Si tiene cupón: 5% adicional
        double totalFinal = aplicarDescuentoBoleto(trasDescHoras, tieneBoleto);

        // Descuento total
        double descuentoTotal = subtotal - totalFinal ;

        // 7) Aviso si supera 1000
        if (totalFinal > 1000) {
            System.out.println("Requiere autorización");
        }

        // 8) Imprimir con 2 decimales
        System.out.println("-----Resumen-----");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Descuento total: " + descuentoTotal);
        System.out.println("Total final: " + totalFinal);

        sc.close();
    }

    // 9) static boolean validarHoras(int horas) -> horas >= 0
    static boolean validarHoras(int horas) {
        // FALTA A: condición correcta
        return horas >= 0 ;
    }

    // 10) static boolean validarTarifa(double tarifa) -> tarifa > 0
    static boolean validarTarifa(double tarifa) {
        // FALTA B: condición correcta
        return tarifa > 0;
    }

    // 11) Descuento por horas (>10) del 12%
    static double aplicarDescuentoHoras(double total, int horas) {
        if (horas > 10) {
            // 12% de descuento → pagar 88%
            return total = total * 0.88 ;
        } else {
            return total;
        }
    }

    // 12) Descuento adicional por cupón (5%)
    static double aplicarDescuentoBoleto(double total, boolean tieneBoleto) {
        if (tieneBoleto) {
            // 5% de descuento → pagar 95%
            return total = total * 0.95;
        } else {
            return total;
        }
    }
}