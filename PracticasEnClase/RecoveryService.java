package PracticasEnClase;

public class RecoveryService {

    public static boolean esFolioValido(String folio) { 

      if (folio == null || folio.trim().isEmpty()) {
        return false;}

         return folio.length() == 6;

        // TODO:
        // - null o en blanco -> false
        // - longitud exacta 6

    } 

    public static boolean esTipoValido(int tipo) {
       return tipo == 1 || tipo == 2 || tipo ==3;

    }

    public static boolean esMinutoValido(int minutos) {
        // TODO: 1..180
     return minutos >= 1 && minutos <= 180;


    }



    public static String clasificarCarga(int minutos) {
        // TODO:
        // BAJA <= 30
        // MEDIA 31..90
        // ALTA > 90

        if (minutos <= 30){
            return "BAJA";
        } else if(minutos > 31 && minutos <90){
            return "MEDIA";
        } else {
            return "ALTA";
        }

    
    }

    public static boolean debeEscalar(int tipo, int minutos) {
        // TODO: tipo Soporte (1) y minutos > 120
       return tipo == 1 && minutos > 120;
        
    }
    
}
