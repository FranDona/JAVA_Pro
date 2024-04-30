package com.restaurante;

public class Clientes {
    private String nombre;
    private String telefono;

    public Clientes(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " - Teléfono: " + telefono;
    }
}
