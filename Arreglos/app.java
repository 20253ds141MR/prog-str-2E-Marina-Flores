package Arreglos;

import java.util.Scanner;

public class app {

    static persona[] personas = new persona[20];
    static Scanner sc = new Scanner(System.in);

    public static void main (String []args) throws Exception{
       
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    alta();
                    break;
            
                case 2:
                    buscarID(); 
                    break;

                case 3:
                    bajaLogica();
                    break;

                case 4:
                    listaAct();
                    break;
                
                case 5:
                    actualizarName();
                    break;
                
                case 0:
                    System.out.println("-------Saliendo del programa-------");
                    break;
                default:
                    System.out.println("Opción inválida, eliga un número dentro del menú");
            }
        } 
        while (opcion != 0);
    }

    static void mostrarMenu(){

        System.out.println("\n ----Menú----");
        System.out.println("1) Alta");
        System.out.println("2) Buscar por el ID");
        System.out.println("3) Baja lógica");
        System.out.println("4)Lista de activas");
        System.out.println("5) Actualizar nombre mediante el ID");
        System.out.println("0) Salir");
        System.out.println("Seleccione una opción: " );
    }

    //OPCION 1
    static void alta(){
        System.out.println("ID:  ");
        int ID = sc.nextInt();
        sc.nextLine(); 

        if (ID <= 0){
            System.out.println("ID inválido");
            return;
        }

        if (buscarID(ID) != -1){
            System.out.println("ID repetido");
            return;
        }

        System.out.println("Nombre: ");
        String nombre = sc.nextLine();

        if (nombre.trim().isEmpty()){
            System.out.println("Nombre vacío");
            return;
        }

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null){
                personas[i] = new persona(ID, nombre);
                System.out.println("Persona registrada");
                return;
            }
        }

        System.out.println("Arreglo lleno");
    }

    //OPCION 2
    static void buscarID(){
        System.out.println("ID de la persona que desea encontrar: ");
        int ID = sc.nextInt();
        sc.nextLine(); 

        for (persona p : personas) {
            if (p != null && p.getID() == ID && p.isActiva()){
                System.out.println("Persona encontrada: " + p);
                return;
            }
        }
        System.out.println("Persona no encontrada");
    }

    //OPCION 3
    static void bajaLogica(){
        System.out.println("ID a buscar: ");
        int ID = sc.nextInt();
        sc.nextLine(); 

        for (persona p : personas){
            if (p != null && p.getID() == ID && p.isActiva()){
                p.setActiva(false);
                System.out.println("Persona dada de baja");
                return;
            }
        }

        System.out.println("Persona no encontrada");
    }
    
    //OPCION 5
    static void actualizarName(){

        System.out.println("ID a actualizarse");
        int ID = sc.nextInt();
        sc.nextLine();

        for (persona p: personas){
            if (p != null && p.getID() == ID && p.isActiva()){
                System.out.println("Nuevo nombre: ");
                String nombre = sc.nextLine();

                if (nombre.trim().isEmpty()){
                    System.out.println("Nombre vació");
                    return;
                }

                p.setNombre(nombre);
                System.out.println("Nombre actualizado correctamente");
                return;
            }
        }
        System.out.println("Persona activa no encontrada");
    }

    static void listaAct(){
        System.out.println("\n---Lista de personas activas---");
        boolean pEx = false;

        for (persona p: personas){
            if (p != null && p.isActiva()){
                System.out.println(p);
                pEx = true;
            }
        }

        if (!pEx){
            System.out.println("No se encuentran personas activas");
        }
    }

    //AUXILIAR DE VALIDACION    
    static int buscarID(int ID){
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getID() == ID){
                return i;
            }
        }
        return -1;
    }
}
