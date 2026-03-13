package Biblioteca;
import java.util.Scanner;


public class ControlBiblioteca {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalRegistrosValidos = 0;   // Solo los que pasaron validación de código
        int totalPermitidos = 0;
        int totalDenegados = 0;

        while (true) {
            System.out.print("Código de usuario (6 chars, alfanumérico) o SALIR: ");
            // FALTA: 1) Leer el código con nextLine()
            String codigo = sc.nextLine();
             
            // FALTA: 2) Terminar el ciclo si el código es exactamente "SALIR"
            if ("SALIR".equals(codigo)){
                break;
            }

            // Validación de código (no null, no vacío/blank, largo 6, alfanumérico)
            // Si falla: imprimir "Código inválido" y continuar con el siguiente registro
            if (!esCodigoValido(codigo)) {
                System.out.println("Código inválido");
                continue;
            }

            // FALTA: 4) Incrementar el total de registros válidos
            totalRegistrosValidos++;

            // --- Tipo de usuario (boolean) ---
            System.out.print("Tipo de usuario (true = alumno, false = externo): ");
            // Si no es boolean: imprimir "Tipo inválido" y terminar el programa con return
            if (!sc.hasNextBoolean()) {
                System.out.println("Tipo inválido");
                sc.close();
                return;
            }
            // FALTA: 6) Leer el boolean
            boolean esAlumno = sc.hasNextBoolean() ;
            sc.nextLine(); // consumir salto de línea tras nextBoolean

            // --- Hora de entrada (int 0..23) ---
            System.out.print("Hora de entrada (0..23): ");
            // Si no es int: imprimir "Hora inválida" y terminar con return
            if (!sc.hasNextInt()) {
                System.out.println("Hora inválida");
                sc.close();
                return;
            }
            // FALTA: 8) Leer el int
            int hora = sc.nextInt();
            sc.nextLine(); // consumir salto de línea tras nextInt

            // Si es int pero fuera de 0..23: imprimir "Hora inválida" y return
            // FALTA: 9) Validar rango 0..23
            if (hora < 0 || hora > 23 ) {
                System.out.println("Hora inválida");
                sc.close();
                return;
            }

            // Regla 8: Si hora >= 21 -> "Biblioteca cerrada" y break (termina el ciclo)
            
            if (hora >= 21) {
                System.out.println("Biblioteca cerrada");
                break;
            }

            // Reglas 7 (horario permitido):
            // Alumnos: 8..20
            // Externos: 10..18
            // FALTA: 11) Usar esHorarioPermitido(hora, esAlumno)
            boolean permitido = esHorarioPermitido(hora, esAlumno) ;

            // FALTA: 12) Sumar a permitidos/denegados e imprimir el resultado
            if (permitido) {
                totalPermitidos++;
                System.out.println("Acceso permitido");
        
            } else {
                // sumar a denegados e imprimir "Acceso denegado"
               totalDenegados++;
               System.out.println("Acceso denegado");
            }
        }

        // --- Salida requerida ---
        System.out.println("---- Resumen ----");
        // FALTA: 13) Imprimir totales: válidos, permitidos, denegados
        System.out.println("Total de registros válidos: "+ totalRegistrosValidos);
        System.out.println("Total de permitidos: " + totalPermitidos);
        System.out.println("Total denegados: " + totalDenegados);

        // Porcentaje de permitidos (2 decimales).
        // Nota: se calcula sobre (permitidos + denegados) para evitar incluir el cierre por biblioteca.
        int denom = totalPermitidos + totalDenegados;
        double porcentaje = (denom == 0) ? 0.0 : (100.0 * totalPermitidos / denom);

        // FALTA: 14) Imprimir porcentaje con 2 decimales (usa printf)
        System.out.println("Porcentaje permitidos: " + porcentaje);
        sc.close();
    }

    // 10) static boolean esCodigoValido(String codigo)
    static boolean esCodigoValido(String codigo) {
        // Reglas:
        // - No null
        // - No vacío/blank
        // - Longitud EXACTA: 6 caracteres
        // - Solo alfanumérico (A-Z, a-z, 0-9)

        // FALTA A: checar null
        if (codigo == null) return false;

        // FALTA B: trim y checar que no quede vacío/blank
        String trimmed = codigo.trim() ;
        if (trimmed.isEmpty()) return false;

        // FALTA C: longitud exacta 6
        if (trimmed.length()!=6) return false;

        // FALTA D: patrón alfanumérico exacto 6 chars
        return trimmed.matches("[A-Za-z0-9]{6}") ;
    }

    // 11) static boolean esHorarioPermitido(int hora, boolean esAlumno)
    static boolean esHorarioPermitido(int hora, boolean esAlumno) {
        // Alumnos: 8..20
        // Externos: 10..18

        // FALTA E: devolver condición correcta para alumnos
        if (esAlumno) {
            return hora >= 8 && hora < 20;
        } else {
            // FALTA F: devolver condición correcta para externos
            return hora >= 10 && hora <= 18 ;
        }
    }
}