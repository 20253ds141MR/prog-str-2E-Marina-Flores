package PracticasEnClase;

public class practica {
    private static final double DESCUENTO = 0.10;
    private static final double PRECIO = 10.0;

    public practica() { }

    public double calcularSubtotal(int cantidad) {
        return cantidad * PRECIO;
    }

    public double calcularDescuento(double subtotal){
        return subtotal * DESCUENTO;
    }

    public double calcularTotal(double subtotal){
        return subtotal - calcularDescuento(subtotal);
    }

    // Opción A: imprimir recibiendo todos los datos
    public void imprimirTicket(int cantidad, double subtotal, double total, double descuento){
        System.out.println("--Ticket--");
        System.out.println("Cantidad de productos: " + cantidad);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Descuento: " + descuento);
        System.out.println("Total del ticket: " + total);
        System.out.println("---------------");
    }

}