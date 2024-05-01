package com.restaurante;

import java.time.LocalDate;

public class Reservas {
    private LocalDate fecha;
    private int turno;
    private int numComensales;
    private String ubicacion;
    private Clientes clientes;

    public Reservas(LocalDate fecha, int turno, int numComensales, String ubicacion, Clientes clientes) {
        this.fecha = fecha;
        this.turno = turno;
        this.numComensales = numComensales;
        this.ubicacion = ubicacion;
        this.clientes = clientes;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getTurno() {
        return turno;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Clientes getClientes() {
        return clientes;
    }

    @Override
    public String toString() {
        return "Reserva - Fecha: " + fecha + " - Turno: " + turno + " - Comensales: " + numComensales + " - Ubicación: " + ubicacion + " - " + clientes;
    }

    public Mesa getMesa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMesa'");
    }
}
