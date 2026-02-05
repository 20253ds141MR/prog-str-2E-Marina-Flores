package IPO;

public class Calculos {

    private final double IVA = 0.16;
    private final double baseEstandar = 50.0;
    private final double baseExpress = 90.0;

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zoneRemote) {
        double base = (tipoServicio == 1) ? baseEstandar : baseExpress;
        double costoPeso = 12.0 * pesoKg;
        double costoDistancia;
        if (distanciaKm <= 50) {
            costoDistancia = 20.0;
        } else if (distanciaKm <= 200) {
            costoDistancia = 60.0;
        } else {
            costoDistancia = 120.0;
        }
        double subtotal = base + costoPeso + costoDistancia;
        if (zoneRemote) subtotal = subtotal * 1.10;
        if (subtotal < 0) subtotal = 0;
        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        double iva = subtotal * IVA;
        if (iva < 0) iva = 0;
        return iva;
    }

    public double calcularTotal(double subtotal, double iva) {
        double total = subtotal + iva;
        if (total < 0) total = 0;
        return total;
    }
}