

public class Perro extends Animal {

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " está ladrando");
    }

    public void marcarTerritorio() {
        System.out.println(getNombre() + " está alzando la patita");
    }
}