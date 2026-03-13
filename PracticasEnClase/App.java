package PracticasEnClase;
import java.util.Scanner;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int intentos = 0;
        int limiteIntentos = 7;
        int secreto = random.nextInt(100) + 1; // 1..100
        boolean gano = false; //bandera 

        System.out.println("Adivina el número entre (1 - 100). Tienes " + limiteIntentos + " intentos.");

        while (intentos < limiteIntentos && !gano) {

            int num = obtenerNumeroValido(min, max, scanner, "Ingresa tu número: ");
            intentos++;

            if (num == secreto) {
                gano = true;
                System.out.println("¡Correcto! Adivinaste el número en " + intentos + " intentos.");
            } else if (num < secreto) {
                System.out.println("El número es mayor");
            } else {
                System.out.println("El número es menor");
            }
        }

        if (!gano) {
            System.out.println("Se acabaron los intentos. El número era: " + secreto);
        }

        scanner.close();
    }

    public static int obtenerNumeroValido(int min, int max, Scanner scanner, String mensaje) {
        int valor;

        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();

                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Número fuera de rango. Debe ser entre " + min + " y " + max);
                }
            } else {
                System.out.println("Debes ingresar un número válido.");
                scanner.next(); // limpia entrada incorrecta
            }
        }
    }
}
