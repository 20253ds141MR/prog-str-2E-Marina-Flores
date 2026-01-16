import java.util.Scanner;

public class Main3 {

    /**
     * Método principal que muestra un menú en consola permitiendo elegir distintas operaciones.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calcularIMC(scanner);
                    break;
                case 2:
                    areaRectangulo(scanner);
                    break;
                case 3:
                    convertirCelsiusAFahrenheit(scanner);
                    break;
                case 4:
                    areaCirculo(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }

        } while (choice != 5);

        scanner.close();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC) de una persona ingresando peso en Kg y altura en metros
     */

    public static void calcularIMC(Scanner scanner) {
        System.out.print("Ingresa tu peso en kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Ingresa tu estatura en metros: ");
        double estatura = scanner.nextDouble();

        double imc = peso / (estatura * estatura);

        System.out.println("Tu IMC es: " + imc);
    }

    /**
     * Calcula el área de un rectángulo usando su base y altura
     */

    public static void areaRectangulo(Scanner scanner) {
        System.out.print("Ingresa la base: ");
        double base = scanner.nextDouble();

        System.out.print("Ingresa la altura: ");
        double altura = scanner.nextDouble();

        double area = base * altura;

        System.out.println("El área del rectángulo es: " + area);
    }

    /**
     * Convierte una temperatura de grados Celsius a Fahrenheit
     */

    public static void convertirCelsiusAFahrenheit(Scanner scanner) {
        System.out.print("Ingresa los grados Celsius: ");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("Equivale a " + fahrenheit + " °F");
    }

    /**
     * Calcula el área de un círculo a partir de su radio 
     */
    public static void areaCirculo(Scanner scanner) {
        System.out.print("Ingresa el radio: ");
        double radio = scanner.nextDouble();

        double area = Math.PI * radio * radio;

        System.out.println("El área del círculo es: " + area);
    }
}
