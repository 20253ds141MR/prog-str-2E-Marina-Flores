package ControlDeCalificaciones;

public class GradeService{
    public double calcularPromedio(double a, double b, double c){
        double promedio = (a+b+c)/3;
        return promedio;
    }

    public double calcularFinal(double promedio, int asistencia){
        double finalCal = (promedio * 0.7) + (asistencia * 0.3);
        return finalCal;
    }

    public String determinarEstado(double finalCal, int asistencia, boolean entregoProyecto){
        
        if (asistencia < 80){
             return "Reprobado por asistencia";
        }

        if (!entregoProyecto){
            return "Reprobado por proyecto";
        }

        if (finalCal >= 70){
            return "Aprobado";
        } else {
            return "Reprobado por calificación";
        }

    }
}