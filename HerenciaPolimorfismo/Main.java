

public class Main {
    public static void main(String[] args) {
        Gato botas = new Gato("Botas");
        Perro bruno = new Perro("Bruno");

        // Herencia
        botas.comer();
        botas.hacerSonido();

        System.out.println("---------------------");

        bruno.comer();
        bruno.hacerSonido();

        // Polimorfismo
        Animal[] animales = new Animal[3];
        animales[0] = new Animal("Ajolote");
        animales[1] = new Perro("Rufus");
        animales[2] = new Perro("Solovino");

        System.out.println("---------------------");
        for (Animal a : animales) {
            a.hacerSonido(); 
        }
    }
}
