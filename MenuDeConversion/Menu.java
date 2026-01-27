package MenuDeConversion;
import java.util.Scanner;


public class Menu{

    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        int opcion;

        //Contador
        int cAF = 0;
        int fAC = 0;
        int kmaMillas = 0;
        int millasaKm= 0;


        do{
            System.out.println("\n--------Menu de Conversiones-------");
            System.out.println("Seleccione una opción númerica (1 al 5)");
            System.out.println("1) C° a F°");
            System.out.println("2) F° a C°");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");

            while(!sc.hasNextInt()){
                System.out.println("Opción inválida, por favor seleccione un número dentro del menú");
                sc.next();
            }

            opcion = sc.nextInt();

            if(opcion < 1|| opcion > 5){
                System.out.println("Opción fuera de rango");
                continue;
            }

            double valor;

            if(opcion !=5){
                System.out.println("Ingrese el valor a convertir: ");
                while(!sc.hasNextDouble()){
                    System.out.println("Dato inválido. Favor de ingresar un número: ");
                    sc.next();
                }
                valor = sc.nextDouble();
            } else {
                break;
            }

            double resultado;

            switch (opcion){
                case 1:
                    resultado = (valor * 9/5) +32;
                    System.out.println(valor + " C° = " + resultado + " F° ");
                    cAF++;
                    break;

                case 2:
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println(valor + " F° = " + resultado + " C°");
                    fAC++;
                    break;
                
                case 3:
                    resultado = valor * 0.6213;
                    System.out.println(valor + " km = " + resultado + " millas ");
                    kmaMillas++;
                    break;

                case 4:
                    resultado = valor / 0.6213;
                    System.out.println(valor + " millas = " + resultado + " km ");
                    millasaKm++;
                    break;
            }

        }  while (opcion!=5);

            int total = cAF + fAC + kmaMillas + millasaKm;

            System.out.println("---Resumen---");
            System.out.println("Total de conversiones: " + total);
            System.out.println("Celsius a Fahrenhai: " + cAF);
            System.out.println("Fahrenhai a Celsius: "+ fAC);
            System.out.println("Kilometros a millas: " + kmaMillas);
            System.out.println("Millas a kilometros " + millasaKm);
            System.out.println("¡Vuelva pronto!");

            sc.close();
    }
}