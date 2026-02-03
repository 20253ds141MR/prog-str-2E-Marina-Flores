package PracticasEnClase;

public class Ticket {

    public static void main (Strings []args) throws Exception{
        practica ticket1= new Ticket();//instancia de una clase
        double subtotal = ticket1.calcularSubtotal(0);
        double descuentoCalculado=ticket1.calcularDescuento(subtotal);
        double total=ticket1.calcularTotal(subtotal);
        ticket1.imprimirTicket(0, subtotal, total, descuentoCalculado);

        )
    }
}
