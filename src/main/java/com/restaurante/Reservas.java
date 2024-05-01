package com.restaurante;

import java.time.LocalDate;

public class Reservas {
    private LocalDate fecha;
    private String turno;
    private int numComensales;
    private String ubicacion;
    private Clientes clientes;
    private Mesa mesa;

    public Reservas(LocalDate fecha, String turno, int numComensales, String ubicacion, Clientes clientes, Mesa mesa) {
        this.fecha = fecha;
        this.turno = turno;
        this.numComensales = numComensales;
        this.ubicacion = ubicacion;
        this.clientes = clientes;
        this.mesa = mesa;

    }





    public Reservas(LocalDate fechaReserva, String turno2, int numComensales2, Clientes clientes2,
            int mesaSeleccionada) {
        //TODO Auto-generated constructor stub
    }





    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTurno() {
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

}
