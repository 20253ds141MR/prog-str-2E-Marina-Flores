package PracticasEnClase;

import java.util.Scanner;

public class Estacionamiento{
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
        
        //Para las horas
        System.out.println("Introduzca las horas estacionadas en formato de número entero: ");
        if(!sc.hasNextInt()){
            System.out.println("Entrada inválida");
            sc.close();
            return; //terminaría el programada
        }
    
        int horasEstacionadas = sc.nextInt();

        if(!validarHoras(horasEstacionadas)){
            System.out.println("Horas inválidadas");
            sc.close();
            return;
        }

        //Tarifa a aplicarse
        System.out.println("Costo de tarifa por hora estacionado: ");
        if(!sc.hasNextDouble()){
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }

        double tarifa = sc.nextDouble();

        if(!validarTarifa(tarifa)){
            System.out.println("Tarifa inválida");
            sc.close();
            return;
        }

        //Boleto con descuento
    System.out.println("¿Cuenta con un boleto de descuento? (True or False) ");
        if(!sc.hasNextBoolean()){
            System.out.println("Entrada inválida");
            sc.close();
            return;
        }
        boolean boletoDescuento =sc.nextBoolean();

        //Calculo 
        double subtotal = horasEstacionadas*tarifa;

        //Descuento por horas
        double totalDescuento = aplicarDescuentoHrs(subtotal, horasEstacionadas);

        //Descuento por boleto 
        double totalFinal = aplicarDescuentoBoleto(totalDescuento,boletoDescuento);

        //Total descuento acumulado
        double descuentoTotal = subtotal - totalFinal;

        //Autorización
        if (totalFinal > 1000){
            System.out.println("Requiere autorización");
        }

        //Salida
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("Descuento total: %.2f%n", descuentoTotal);
        System.out.printf("Total final: %.2f%n", totalFinal);
        
        sc.close();
    
    }

    static boolean validarHoras(int horasEstacionadas){
        return horasEstacionadas >=0;
    }

    static boolean validarTarifa(double tarifa){
        return tarifa > 0.0;
    }

    static double aplicarDescuentoHrs(double total, int horasEstacionadas){
        if (horasEstacionadas > 10){
            return total * 0.88;
        }
        return total;
    }

    static double aplicarDescuentoBoleto(double total, boolean boletoDescuento){

if (boletoDescuento) {
            return total * 0.95; // 5% de descuento
        }
        return total;
    }
}
