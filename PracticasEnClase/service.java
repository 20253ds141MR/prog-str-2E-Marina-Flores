package PracticasEnClase;
public class service {

    // válido si p > 0
    public static boolean esPrecioValido(double p) {
        return p > 0;
    }

    public static double calcularSubtotal(double subtotalActual, double precio) {
        return subtotalActual + precio;
    }

    public static double calcularDescuento(double subtotal, int metodoPago) {

        if (subtotal >= 500) {

            if (metodoPago == 1) { // efectivo
                return subtotal * 0.08;
            }

            if (metodoPago == 2) { // tarjeta
                return subtotal * 0.05;
            }
        }

        return 0.0;
    }

    public static double calcularTotal(double subtotal, double descuento) {
        return subtotal - descuento;
    }
}
