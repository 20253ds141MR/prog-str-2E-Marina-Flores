package PracticasEnClase;
import java.util.Scanner;

public class Main {

    // 10) Valida el código: no nulo, no blank, exactamente 6 alfanuméricos.
    static boolean esCodigoValido(String codigo) {
        if (codigo == null || codigo.isBlank()) return false;
        // Exactamente 6 caracteres alfanuméricos (A-Z, a-z, 0-9)
        return codigo.matches("[A-Za-z0-9]{4}");
    }

    // 11) Valida si el horario está permitido según el tipo de usuario
    static boolean esHorarioPermitido(int hora, boolean esAlumno) {
        if (esAlumno) {
            return hora >= 8 && hora <= 20;   // alumnos: 8..20
        } else {
            return hora >= 10 && hora <= 18;  // externos: 10..18
        }
    }

    // Método auxiliar para imprimir el resumen final en cualquier escenario de salida
    static void imprimirResumen(int totalValidos, int totalPermitidos, int totalDenegados) {
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de registros válidos: " + totalValidos);
        System.out.println("Total permitidos: " + totalPermitidos);
        System.out.println("Total denegados: " + totalDenegados);

        double porcentaje = (totalValidos == 0)
                ? 0.0
                : (totalPermitidos * 100.0) / totalValidos;
        System.out.printf("Porcentaje de permitidos: %.2f%%\n", porcentaje);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalValidos = 0;
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {
            // 2) Pedimos Código de usuario
            System.out.print("Ingrese su usuario con 4 caracteres alfenúmericos o 'SALIR' para terminar: ");
            String codigo = sc.next(); // lee el siguiente token (palabra)

            // 3) Termina el ciclo si el código es "SALIR"
            if ("SALIR".equals(codigo)) {
                break; // salimos del while
            }

            // 4) Validación de código
            if (!esCodigoValido(codigo)) {
                System.out.println("Código inválido");
                // Si el código es inválido, no cuenta como válido y seguimos al siguiente registro
                continue; // vuelve a pedir desde el principio del loop
            }

            // Hasta aquí, el código fue válido ⇒ ya cuenta como registro válido
            totalValidos++;

            // 5) Tipo de usuario (boolean): true = alumno, false = externo
            System.out.print("Tipo de usuario (true -> alumno, false -> externo): ");
            if (!sc.hasNextBoolean()) {
                System.out.println("Tipo inválido");
                // Terminamos el programa inmediatamente, pero antes imprimimos el resumen
                imprimirResumen(totalValidos, totalPermitidos, totalDenegados);
                sc.close();
                return; // fin del programa
            }
            boolean esAlumno = sc.nextBoolean();

            // 6) Hora de entrada
            System.out.print("Hora de entrada (de 0 a 23 hrs en número entero): ");
            if (!sc.hasNextInt()) {
                System.out.println("Hora inválida");
                imprimirResumen(totalValidos, totalPermitidos, totalDenegados);
                sc.close();
                return;
            }
            int hora = sc.nextInt();

            if (hora < 0 || hora > 23) {
                System.out.println("Hora inválida");
                imprimirResumen(totalValidos, totalPermitidos, totalDenegados);
                sc.close();
                return;
            }

            // 8) Si hora >= 21 → biblioteca cerrada y termina el ciclo
            if (hora >= 21) {
                System.out.println("Biblioteca cerrada");
                break; // salimos del while, luego imprimimos el resumen
            }

            // 7) Reglas de negocio por tipo
            boolean permitido = esHorarioPermitido(hora, esAlumno);
            if (permitido) {
                totalPermitidos++;
                System.out.println("Acceso PERMITIDO");
            } else {
                totalDenegados++;
                System.out.println("Acceso DENEGADO");
            }

            System.out.println(); // línea en blanco estética
        }

        // 9) Salida requerida: resumen final
        imprimirResumen(totalValidos, totalPermitidos, totalDenegados);

        sc.close();
    }
 
}

