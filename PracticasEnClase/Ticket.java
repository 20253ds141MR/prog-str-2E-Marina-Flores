package PracticasEnClase;

public class Ticket{
    public static void main(String[] args) {
        practica ticket1 = new practica();

        int cantidad = 10; // <-- cámbialo a lo que necesites
        double subtotal = ticket1.calcularSubtotal(cantidad);
        double descuentoCalculado = ticket1.calcularDescuento(subtotal);
        double total = ticket1.calcularTotal(subtotal);

        ticket1.imprimirTicket(cantidad, subtotal, total, descuentoCalculado);
    }
}
