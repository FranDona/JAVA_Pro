package com.restaurante;

public class Pago {
    public static final String BIZUM = "Bizum";
    public static final String TARJETA_CREDITO = "Tarjeta de crédito";
    public static final String EFECTIVO = "Efectivo";

    private String metodoPago;
    private double importe;

    public Pago(String metodoPago, double importe) {
        this.metodoPago = metodoPago;
        this.importe = importe;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public double getImporte() {
        return importe;
    }

    @Override
    public String toString() {
        return "Pago - Método: " + metodoPago + " - Importe: " + importe;
    }
}
