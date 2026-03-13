package Biblioteca;
import java.util.Scanner;

public class CajaEstacionamiento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Horas estacionado (int) ---
        System.out.print("Horas estacionado (entero): ");
        // Si no hay int: "Entrada inválida" y return
        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        // FALTA 2: leer horas con nextInt()
        int horas = sc.nextInt() ;
        sc.nextLine(); 

        // Validar horas >= 0. Si es negativa: "Horas inválidas" y return
        if (!validarHoras(horas)) {
            System.out.println("Horas inválidas");
            sc.close();
            return;
        }

        // --- Tarifa por hora ---
        System.out.print("Tarifa por hora: ");
        
        if (!sc.hasNextInt()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        // FALTA 5: leer tarifa con nextDouble()
        double tarifa = sc.nextDouble() ;
        sc.nextLine(); // consumir salto de línea

        // Validar tarifa > 0. Si no: "Tarifa inválida" y return
        if (!validarTarifa(tarifa)) {
            System.out.println("Tarifa inválida");
            sc.close();
            return;
        }

        // --- ¿Tiene boleto de descuento? (boolean) ---
        System.out.print("¿Tiene boleto de descuento? (true/false): ");
       
        if (!sc.hasNextBoolean()) {
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        // FALTA 8: leer boolean con nextBoolean()
        boolean tieneBoleto = sc.hasNextBoolean() ;
        sc.nextLine(); // consumir salto de línea

        // --- Cálculo base ---
        // 4) total = horas * tarifa (lo llamaremos subtotal antes de descuentos)
       
        double subtotal = horas*tarifa;

        // 5) Descuento por horas > 10: 12% sobre el total (subtotal)
        
        double totalConDescuentoHoras = aplicarDescuentoHoras(subtotal, horas);

        // 6) Si tiene boleto, descuento adicional del 5% sobre el total ya descontado
        
        double totalFinal = aplicarDescuentoBoleto(totalConDescuentoHoras, tieneBoleto) ;

        // Calcular descuentoTotal = subtotal - totalFinal
        
        double descuentoTotal = subtotal - totalFinal ;

        // 7) Si el total final supera 1000, imprimir aviso
        if (totalFinal > 1000 ) {
            System.out.println("Requiere autorización");
        }

        // 8) Imprimir: subtotal, descuentoTotal y totalFinal (2 decimales)
        
        System.out.println("--------Resumen---------");
        System.out.printf("\nSubtotal: $" + subtotal); 
        System.out.printf("\nDescuento total: $" + descuentoTotal); 
        System.out.printf("\nTotal final: $" + totalFinal); 

        sc.close();
    }

    // 9) static boolean validarHoras(int horas) -> horas >= 0
    static boolean validarHoras(int horas) {
        
        return horas >= 0 ;
    }

    // 10) static boolean validarTarifa(double tarifa) -> tarifa > 0
    static boolean validarTarifa(double tarifa) {
       
        return tarifa > 0  ;
    }

    // 11) 
    //     Si horas > 10, aplicar 12% de descuento; si no, devolver total sin cambios
    static double aplicarDescuentoHoras(double total, int horas) {
        // FALTA C: condición y cálculo
        if (horas > 10 ) {
            total = total * 0.88;
            return total;
        } else {
            return total;
        }
    }

    static double aplicarDescuentoBoleto(double total, boolean tieneBoleto) {
        // FALTA D: condición y cálculo
        if (tieneBoleto) {
            total = total * 0.95;
            return total ;
        } else {
            return total;
        }
    }
}