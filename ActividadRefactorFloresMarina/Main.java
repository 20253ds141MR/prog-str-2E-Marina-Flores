
package ActividadRefactorFloresMarina;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = pedirEntero(scanner, "a: ");
        int b = pedirEntero(scanner, "b: ");
        int c = pedirEntero(scanner, "c: ");

        int suma = a + b + c;

        System.out.println("suma=" + suma);
        System.out.println("prom=" + (suma / 3.0));
    }

    private static int pedirEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
}
