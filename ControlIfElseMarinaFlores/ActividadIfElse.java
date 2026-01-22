package ControlIfElseMarinaFlores;

import.java.util;

public class ActividadIfElse{
    public static void main {Strings []args}{
        Scanner sc= new scanner(System.in);
int edad = sc.nextInt();
   if (edad <0 || edad > 120){
      System.out.println("Edad inválida");
      return;
   }
       boolean est= sc.nextBoolean();
       int = tarifa;

       if (edad <12) tarifa=50;
       else 
        if(edad <= 17) tarifa = est ? 60:80;
       else tarifa = est ? 90:120;

       System.out.println("Edad ingresada " + edad);
       System.out.println("Es estudiante: " + est);
       System.out.println("Tarifa final: " + tarifa);
    }
}