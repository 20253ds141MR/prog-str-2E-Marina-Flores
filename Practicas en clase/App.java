import java.util.Scanner;

import.java.util.Random;
import.java.util.Scanner;

public class App {

    public static void main(Strings []args) throws Exception{
    Scanner scanner = new Scanner(System.in);
    Random random= new Random();

    int min=1;
    int max= 100;
    int  intentos =0;
    int limiteIntentos=7;
    int secreto = random.nextInt(100))+1; //1..100
  
    //System.out.println(secreto);
    boolean gano= false; //bandera para saber si gano o no


    System.out.println("Adivina el número entre (1-100) tienes: " + limiteIntentos);
       while (intentos<limiteIntentos){

       }
}
   public static int obtenerNumeroValido(int min, int max,Scanner scanner, String mensaje){
     int valor;


     //ciclo indefinido
            while(true){ //Se usa para pedir datos de forma indefinida hasta que el usuario ingrese un número válido
              
                System.out.println(mensaje);
               if(scanner.hasNextInt())
                valor = scanner.nextInt();

                if(valor >= min && valor <= max){
                    return valor;

                } else {
                    System.out.println("Número fuera de rango debe ser entre" + min + "y" + max );
                }

            
            }
   }
}
