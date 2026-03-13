
package ActividadRefactorFloresMarina;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*Solictar los números a sumar */
        System.out.println("Ingrese los números de las incognitas a sumar:");
        int a = pedirEntero(scanner, "a: ");
        int b = pedirEntero(scanner, "b: ");
        int c = pedirEntero(scanner, "c: ");

        /*Operacion con las incognitas introducidas por el usuario */
        int suma = a + b + c;

        /*Proceso suma y promedio */
        System.out.println("suma=" + suma);
        System.out.println("prom=" + (suma / 3.0));
    }

    private static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
}
