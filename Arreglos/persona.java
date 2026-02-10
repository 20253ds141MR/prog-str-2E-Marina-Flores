package Arreglos;

public class persona {
   private int ID;
   private String nombre;
   private boolean activa;

   public persona(){
   }

   public persona(int ID, String nombre){
      this.ID= ID;
      this.nombre=nombre;
      this.activa= true;
   }

   public int getID(){
      return ID;
   }

   public void setID(int ID){
      this.ID = ID;
   }

   public String getNombre(){
      return nombre;
   }

   public void setNombre(String nombre){
      this.nombre=nombre;
   }

   public boolean isActiva(){
      return activa;
   }

   public void setActiva(boolean activa){
      this.activa= activa;
   }

   @Override
public String toString() {
    return "\n--- Persona encontrada ---\n" +
           "ID: " + ID + "\n" +
           "Nombre: " + nombre + "\n" +
           "Activa: " + activa + "\n";
}

}