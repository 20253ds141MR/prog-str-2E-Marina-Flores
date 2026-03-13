package ControlSwitchMarinaFlores;
import java.util.Scanner;

public class Main{
 public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);

    //Menú
    System.out.println("---MENÚ---");
    System.out.println("1) Sumar");
    System.out.println("2) Restar");
    System.out.println("3) Multiplicar");
    System.out.println("4) Dividir");

    //Elección de operación
    System.out.println("Selecciona una operación en formato númerico");
    int opcion= sc.nextInt();

    //Valores
    System.out.println("Ingresa el valor de a: ");
    double a= sc.nextDouble();

    System.out.println("Ingresa el valor de b: ");
    double b= sc.nextDouble();

    double resultado=0;
    String operacion = "";

    //Switch para la operación
    switch (opcion) {
        case 1:
            operacion= "Suma";
            resultado= a+b;
            System.out.println("\nOperacion: " + operacion);
            System.out.println("Valores: a= " + a + ", b = " + b);
            System.out.println("Resultado = "+ resultado);
            break;

        case 2:
           operacion= "Resta";
           System.out.println("\nOperacion: " + operacion);
           System.out.println("Valores: a= " + a + ", b = " + b);
           System.out.println("Resultado = "+ resultado);

        case 3:
            operacion= "Multiplicación";
            resultado= a*b;
            System.out.println("\nOperación: " + operacion);
            System.out.println("Valores: a= " + a + ", b = " + b);
            System.out.println("Resultado = "+ resultado);
            
            break;

        case 4:
            operacion= "División";
            System.out.println("\nOperación: " + operacion);
            System.out.println("Valores: a= " + a + ", b= " + b);

            if (b==0){
                System.out.println("No se puede dividir");
            } else {
                resultado= a/b;
                  System.out.println("Resultado: " + resultado);
            }
            break;
    
        default:
              System.out.println("\nOpción no válida, escoger otra operación");
            break;
    }

    sc.close();

 }
    
}