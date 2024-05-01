package com.restaurante;

public class Pago {
    // Constantes que representan los métodos de pago disponibles
    public static final String BIZUM = "Bizum";
    public static final String TARJETA_CREDITO = "Tarjeta de crédito";
    public static final String EFECTIVO = "Efectivo";

    // Variables de instancia para almacenar el método de pago y el importe
    private String metodoPago;
    private double importe;

    // Constructor de la clase Pago
    public Pago(String metodoPago, double importe) {
        // Inicializa las variables de instancia con los valores proporcionados
        this.metodoPago = metodoPago;
        this.importe = importe;
    }

    // Método para obtener el método de pago utilizado
    public String getMetodoPago() {
        return metodoPago;
    }

    // Método para obtener el importe del pago
    public double getImporte() {
        return importe;
    }

    // Método toString para representar el objeto Pago como una cadena
    @Override
    public String toString() {
        return "Pago - Método: " + metodoPago + " - Importe: " + importe;
    }
}
