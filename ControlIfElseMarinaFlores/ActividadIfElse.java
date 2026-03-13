package ControlIfElseMarinaFlores;

import java.util.Scanner;

public class ActividadIfElse {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.print("Ingresa tu edad: ");
        int edad = sc.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            sc.close();
            return ;
        }

        System.out.print("¿Eres estudiante? (true/false): ");
        boolean est = sc.nextBoolean();

        int tarifa;

        if (edad < 12) {
            tarifa = 50;
        } else if (edad <= 17) {
            tarifa = est ? 60 : 80;
        } else {
            tarifa = est ? 90 : 120;
        }

        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + est);
        System.out.println("Tarifa final: $" + tarifa);

        sc.close();
    }
}
