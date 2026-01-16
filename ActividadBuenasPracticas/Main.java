
package ActividadBuenasPracticas;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa que pide un entero no negativo n y muestra la suma de 1 hasta n.
 * Ejemplo: n = 5 -> 1 + 2 + 3 + 4 + 5 = 15
 */
public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = pedirEnteroNoNegativo(scanner, "Introduce un número entero no negativo (n): ");
            long suma = sumarHastaN(n);
            System.out.printf("La suma de los enteros de 1 a %d es: %d%n", n, suma);
        }
    }

    /** Solicita un entero no negativo al usuario, validando la entrada. */
    public static int pedirEnteroNoNegativo(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = scanner.nextInt();
                if (valor < 0) {
                    System.out.println("Por favor, ingresa un número mayor o igual que 0.");
                    continue;
                }
                return valor;
            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida. Debes escribir un número entero.");
                scanner.next(); // descartar el token inválido
            }
        }
    }

    /** Suma los enteros desde 1 hasta n (si n = 0, devuelve 0). */
    public static long sumarHastaN(int n) {
        long suma = 0;
        for (int i = 1; i <= n; i++) {
            suma += i;
        }
        return suma;
    }
}
