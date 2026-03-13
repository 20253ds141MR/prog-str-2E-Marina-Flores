package Biblioteca;
import java.util.Scanner;

public class AlquilerSalaCine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Duración del evento (horas, int) ---
        System.out.print("Duración del evento en horas (entero): ");
        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        int horas = sc.nextInt() ;
        sc.nextLine();

        if (!validarHoras(horas)) {
            System.out.println("Horas inválidas");
            sc.close();
            return;
        }

        // --- Tarifa por hora de la sala (double) ---
        System.out.print("Tarifa por hora de la sala (decimal): ");
        if (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        double tarifa = sc.nextDouble();
        sc.nextLine();

        if (!validarTarifa(tarifa)) {
            System.out.println("Tarifa inválida");
            sc.close();
            return;
        }

        // --- ¿Tiene pase corporativo? (boolean) ---
        System.out.print("¿Pase corporativo? (true/false): ");
        if (!sc.hasNextBoolean()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        boolean tieneBoleto = sc.nextBoolean() ;
        sc.nextLine();

        // --- Cálculo ---
        // 4) subtotal = horas * tarifa
        double subtotal = horas * tarifa ;

        // 5) Si horas > 10: 12% descuento
        double trasDescHoras= aplicarDescuentoHoras(subtotal, horas) ;

        // 6) Si pase corporativo: 5% adicional
        double totalFinal = aplicarDescuentoBoleto(trasDescHoras, tieneBoleto);

        // descuentoTotal = subtotal - totalFinal
        double descuentoTotal = subtotal - totalFinal;

        // 7) Aviso si totalFinal > 1000
        if (totalFinal > 1000 ) {
            System.out.println("Requiere autorización");
        }

        // 8) Salida con 2 decimales
        System.out.println("-------Resumen-------");
        System.out.printf("\nSubtotal: " + subtotal); 
        System.out.printf("\nDescuento total: " + descuentoTotal); 
        System.out.printf("\nTotal final: " + totalFinal); 

        sc.close();
    }

    // 9) Validar horas (>= 0)
    static boolean validarHoras(int horas) {
        return horas >= 0 ;
    }

    // 10) Validar tarifa (> 0)
    static boolean validarTarifa(double tarifa) {
        return tarifa > 0;
    }

    // 11) Descuento por horas (>10) del 12%
    static double aplicarDescuentoHoras(double total, int horas) {
        if (horas > 10 ) {
            return total = total * 0.88;
        }
        return total;
    }

    // 12) Descuento adicional por pase corporativo (5%)
    static double aplicarDescuentoBoleto(double total, boolean tieneBoleto) {
        if (tieneBoleto ) {
            return total = total * 0.95 ;
        }
        return total;
    }
}