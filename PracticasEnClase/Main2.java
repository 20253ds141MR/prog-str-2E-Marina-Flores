package PracticasEnClase;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalValidos = 0;
        int totalSoporte = 0, totalCobranza = 0, totalVentas = 0;
        int totalBaja = 0, totalMedia = 0, totalAlta = 0;
        int sumaMinutos = 0;

        while (true) {
            System.out.print("Escriba el número de Folio a 6 carácteres o FIN para salir:"); 
            String folio = sc.nextLine();

            if (folio.equalsIgnoreCase("FIN")) break;

            if (!RecoveryService.esFolioValido(folio)) {
                System.out.println("Folio inválido");
                continue;
            }

            System.out.print("Tipo (1=Soporte, 2=Cobranza, 3=Ventas): ");
            if (!sc.hasNextInt()) {
                System.out.println("Tipo inválido");
                return;
            }
            int tipo = sc.nextInt();

            if (!RecoveryService.esTipoValido(tipo)) {
                System.out.println("Tipo inválido");
                continue;
            }

            System.out.print("Minutos (1..180): ");
            if (!sc.hasNextInt()) {
                System.out.println("Minutos inválidos");
                return;
            }
            int minutos = sc.nextInt();

            if (!RecoveryService.esMinutoValido(minutos)) {
                System.out.println("Minutos inválidos");
                continue;
            }

            // Ticket válido
            totalValidos++;
            sumaMinutos += minutos;

            if (tipo == 1) {
                totalSoporte++;
            }
            else if (tipo == 2) {
                totalCobranza++;}

            else totalVentas++;

            String carga = RecoveryService.clasificarCarga(minutos);
            if (carga.equals("BAJA")) totalBaja++;
            else if (carga.equals("MEDIA")) totalMedia++;
            else totalAlta++;

            if (!RecoveryService.debeEscalar(tipo, minutos)) {
                System.out.println("ESCALADO");
                break;
            }
            sc.close();
        }

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Tickets válidos: " + totalValidos);
        System.out.println("Soporte: " + totalSoporte);
        System.out.println("Cobranza: " + totalCobranza);
        System.out.println("Ventas: " + totalVentas);
        System.out.println("Carga BAJA: " + totalBaja);
        System.out.println("Carga MEDIA: " + totalMedia);
        System.out.println("Carga ALTA: " + totalAlta);

        double promedio = (totalValidos == 0) ? 0.0 : (sumaMinutos * 1.0 / totalValidos);
        System.out.printf("Promedio minutos: %.2f\n", promedio);
    }
}