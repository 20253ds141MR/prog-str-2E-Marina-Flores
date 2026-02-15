package AlumnosCRUD;

public class Alumno{
    int ID;
    String nombre;
    double promedio;
    boolean activo;

    public Alumno (int ID, String nombre, double promedio){
        this.ID = ID;
        this.nombre = nombre;
        this.promedio = promedio;
        this.activo = true; 
    }
}