package com.restaurante;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int numero;
    private int capacidad;
    private String ubicacion;
    private List<Reservas> reservas;
    private double totalPagado;

    public Mesa(int numero, int capacidad, String ubicacion) {
        this.numero = numero;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.reservas = new ArrayList<>();
        this.totalPagado = 0;
    }

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

    public void agregarReserva(Reservas reserva) {
        reservas.add(reserva);
    }

    public void agregarPago(double importe) {
        totalPagado += importe;
    }

    @Override
    public String toString() {
        return "Mesa " + numero + " - Capacidad: " + capacidad + " - Ubicación: " + ubicacion;
    }
}
