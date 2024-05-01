package com.restaurante;

import java.util.List;

public class MetreInteligente {
    // Lista de mesas disponibles para la gestión
    private List<Mesa> mesas;

    // Constructor que inicializa la lista de mesas
    public MetreInteligente(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    // Método para asignar una mesa a una reserva
    public Mesa asignarMesa(Reservas reserva) {
        Mesa mesaAsignada = null; // Variable para almacenar la mesa asignada
        // Iterar sobre cada mesa en la lista
        for (Mesa mesa : mesas) {
            // Verificar si la capacidad de la mesa es suficiente y la ubicación es compatible con la reserva
            if (mesa.getCapacidad() >= reserva.getNumComensales() && mesa.getUbicacion().equals(reserva.getUbicacion())) {
                // Variable para verificar la disponibilidad de la mesa
                boolean disponible = true;
                // Iterar sobre las reservas de la mesa para verificar si hay conflicto de fechas y turnos
                for (Reservas r : mesa.getReservas()) {
                    // Verificar si hay conflicto de fechas y turnos, ignorando el caso
                    if (r.getFecha().isEqual(reserva.getFecha()) && r.getTurno().equalsIgnoreCase(reserva.getTurno())) {
                        disponible = false; // La mesa no está disponible en esta fecha y turno
                        break;
                    }
                }
                // Si la mesa está disponible, asignarla y salir del ciclo
                if (disponible) {
                    mesaAsignada = mesa;
                    break;
                }
            }
        }
        // Devolver la mesa asignada (puede ser null si no hay mesas disponibles)
        return mesaAsignada;
    }
    
}
