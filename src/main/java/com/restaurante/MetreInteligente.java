package com.restaurante;

import java.util.List;

public class MetreInteligente {
    private List<Mesa> mesas;

    public MetreInteligente(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Mesa asignarMesa(Reservas reserva) {
        for (Mesa mesa : mesas) {
            if (mesa.getCapacidad() >= reserva.getNumComensales() && mesa.getUbicacion().equals(reserva.getUbicacion())) {
                boolean disponible = true;
                for (Reservas r : mesa.getReservas()) {
                    if (r.getFecha().isEqual(reserva.getFecha()) && r.getTurno() == reserva.getTurno()) {
                        disponible = false;
                        break;
                    }
                }
                if (disponible) {
                    mesa.agregarReserva(reserva);
                    return mesa;
                }
            }
        }
        return null;
    }
}
