package com.restaurante;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    // Atributos de la mesa
    private int numero; // Número de la mesa
    private int capacidad; // Capacidad de la mesa (número máximo de comensales)
    private String ubicacion; // Ubicación de la mesa (interior/terraza)
    private List<Reservas> reservas; // Lista de reservas asociadas a la mesa
    private double totalPagado; // Total pagado en la mesa

    // Constructor de la clase
    public Mesa(int numero, int capacidad, String ubicacion) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.reservas = new ArrayList<>(); // Inicializa la lista de reservas como una lista vacía
        this.totalPagado = 0; // Inicializa el total pagado en la mesa como cero
    }

    // Métodos de acceso para obtener los valores de los atributos
    public int getNumero() {
        return numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public List<Reservas> getReservas() {
        return reservas;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    // Método para agregar una reserva a la lista de reservas de la mesa
    public void agregarReserva(Reservas reserva) {
        reservas.add(reserva);
    }

    // Método para agregar un pago al total pagado en la mesa
    public void agregarPago(double importe) {
        totalPagado += importe;
    }

    // Método toString para representar la mesa como una cadena de texto
    @Override
    public String toString() {
        return "Mesa " + numero + " - Capacidad: " + capacidad + " - Ubicación: " + ubicacion;
    }
}
