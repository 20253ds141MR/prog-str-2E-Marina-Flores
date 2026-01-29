package AdivinaElNumero;
import java.util.Random;

import java.util.Scanner;



public class AdivinaNumero {

    public static void main(String[] args) {

        final int MIN = 1;

        final int MAX = 100;

        final int MaxIntentos = 7;



        Random rng = new Random();

        int secreto = rng.nextInt(MAX - MIN + 1) + MIN; // [1, 100]



        Scanner sc = new Scanner(System.in);


        //Control de ganador o perdedor
        boolean gano = false; 

        //Variables

        int intentosValidos = 0;             

        int fueraRangoB = 0;              

        int fueraRangoA = 0;              

        int noNum = 0;                 



        System.out.println("Adivina el número secreto (entre 1 y 100). Tienes " + MaxIntentos + " intentos.");



        while (!gano && intentosValidos < MaxIntentos) {

            System.out.print("Ingresa tu intento #" + (intentosValidos + 1) + ": ");

            String linea = sc.nextLine().trim();



            // Validación noNumerica

            int num;

            try {

                // Rango

                num = Integer.parseInt(linea);

            } catch (NumberFormatException e) {

                noNum++;

                System.out.println("Entrada no válida. Por favor ingresa un número entero.");

                continue; 

            }



            // Validación de rango

            if (num < MIN) {

                fueraRangoB++;

                System.out.println("Fuera de rango (menor que 1). Intenta de nuevo entre " + MIN + " y " + MAX + ".");

                continue; 

            } else if (num > MAX) {

                fueraRangoA++;

                System.out.println("Fuera de rango (mayor que 100). Intenta de nuevo entre " + MIN + " y " + MAX + ".");

                continue;

            }



            // Comenzamos a contar los intentos

            intentosValidos++;



            if (num == secreto) {

                gano = true;

                System.out.println("¡Ganaste! Adivinaste el número " + secreto + " en " + intentosValidos + " intento" + (intentosValidos == 1 ? "" : "s") + ".");

            } else {

                String pista = (num < secreto) ? "mayor" : "menor";

                int restantes = MaxIntentos - intentosValidos;

                System.out.println("Incorrecto :c . El número secreto es " + pista + " que " + num + ". " +

                                   "Te quedan " + restantes + " intento" + (restantes == 1 ? "" : "s") + ".");

            }

        }



        if (!gano) {

            System.out.println("¡Perdiste! :c  El número secreto era: " + secreto + ".");

        }



        // Resumen 

        int totalFueraRango = fueraRangoB + fueraRangoA;

        System.out.println("\n=== Resumen ===");

        System.out.println("Intentos válidos usados: " + intentosValidos + " de " + MaxIntentos);

        System.out.println("Fuera de rango (menor que 1): " + fueraRangoB);

        System.out.println("Fuera de rango (mayor que 100): " + fueraRangoA);

        System.out.println("Total fuera de rango: " + totalFueraRango);

        System.out.println("Entradas no numéricas: " + noNum);



        sc.close();

    }

}