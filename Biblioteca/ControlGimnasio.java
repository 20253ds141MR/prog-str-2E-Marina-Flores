package Biblioteca;
import java.util.Scanner;

public class ControlGimnasio {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalRegistrosValidos = 0;   // Solo los que pasaron validación de código
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {
            System.out.print("Folio de usuario (6 chars alfanuméricos) o SALIR: ");
            // FALTA 1: leer el código con nextLine()
            String codigo = sc.nextLine();

            // FALTA 2: si el código es "SALIR", terminar el ciclo (break)
            if("SALIR".equals(codigo)){
                break;
            }

            // Validación de código (no null, no vacío/blank, largo 6, alfanumérico)
            // Si falla: imprimir "Código inválido" y continuar (continue)
            if (!esCodigoValido(codigo)) {
                System.out.println("Código inválido");
                continue;
            }

            // FALTA 4: incrementar totalRegistrosValidos
            totalRegistrosValidos++;

            // --- Tipo de usuario (boolean) ---
            System.out.print("Tipo de usuario (true = alumno, false = externo): ");
            // Si NO es boolean: "Tipo inválido" y terminar programa con return
            if (!sc.hasNextBoolean()) {
                System.out.println("Tipo inválido");
                sc.close();
                return;
            }
            // FALTA 6: leer el boolean con nextBoolean
            boolean esAlumno = sc.hasNextBoolean();
            sc.nextLine(); // consumir salto de línea tras nextBoolean

            // --- Hora de entrada (int 0..23) ---
            System.out.print("Hora de entrada (0..23): ");
            // Si NO es int: "Hora inválida" y return
            if (!sc.hasNextInt()) {
                System.out.println("Hora inválida");
                sc.close();
                return;
            }
            // FALTA 8: leer la hora con nextInt
            int hora = sc.nextInt();
            sc.nextLine(); // consumir salto de línea tras nextInt

            // Si es int pero fuera de 0..23: "Hora inválida" y return
            if (hora < 0 || hora > 23) {
                System.out.println("Hora inválida");
                sc.close();
                return;
            }

            // Regla: si hora >= 21 -> "Gimnasio cerrado" y break
            if (hora >= 21) {
                System.out.println("Gimnasio cerrado");
                break;
            }

            // Reglas de negocio (idénticas):
            // Alumnos: 8..20
            // Externos: 10..18
            // FALTA 11: calcular permitido con esHorarioPermitido(hora, esAlumno)
            boolean permitido = esHorarioPermitido(hora, esAlumno);

            // FALTA 12: sumar a permitidos/denegados e imprimir resultado
            if (permitido) {
                totalPermitidos++;
                System.out.println("Acceso permitido");
            } else {
                totalDenegados++;
                System.out.println("Acceso denegado");
            }
        }

        // --- Resumen final ---
        System.out.println("---- Resumen (Gimnasio) ----");
        // FALTA 13: imprimir totales de válidos, permitidos y denegados
        // Ejemplo: System.out.println("Total registros válidos: " + totalRegistrosValidos);
       System.out.println("Total de permisos válidos: " + totalRegistrosValidos);
       System.out.println("Accesos permitidos: " + totalPermitidos);
       System.out.println("Accesos denegados: " + totalDenegados);

        // Porcentaje de permitidos (2 decimales), sobre los evaluados (permitidos + denegados)
        int evaluados = totalPermitidos + totalDenegados;
        double porcentaje = (evaluados == 0) ? 0.0 : (100.0 * totalPermitidos / evaluados);

        // FALTA 14: imprimir porcentaje con 2 decimales usando printf
        // Ejemplo: System.out.printf("Porcentaje permitidos: %.2f%%%n", porcentaje);
        System.out.println("Porcentaje de personas admitidas: " + porcentaje);
        sc.close();
    }

    // 10) static boolean esCodigoValido(String codigo)
    static boolean esCodigoValido(String codigo) {
        // - No null
        // - No vacío/blank
        // - Longitud EXACTA: 6
        // - Solo alfanumérico (A-Z, a-z, 0-9)

        // FALTA A: null check
        if (codigo == null ) return false;

        // FALTA B: trim y validar vacío/blank
        String trimmed = codigo ;
        if (trimmed.isEmpty()) return false;

        // FALTA C: longitud exacta 6
        if (trimmed.length() !=6) return false;

        // FALTA D: patrón alfanumérico exacto 6
        return trimmed.matches("[A-Za-z0-9]{6}")  ;
    }

    // 11) static boolean esHorarioPermitido(int hora, boolean esAlumno)
    static boolean esHorarioPermitido(int hora, boolean esAlumno) {
        // Alumnos: 8..20
        // Externos: 10..18
        // FALTA E: condición para alumnos
        if (esAlumno ) {
            return hora >= 8 && hora <= 20 ;
        } else {
            // FALTA F: condición para externos
            return hora >= 10 && hora <= 18  ;
        }
    }
}