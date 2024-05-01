package com.restaurante;

public class Clientes {
    // Atributos de cliente
    private String nombre; // Nombre del cliente
    private String telefono; // Número de teléfono del cliente

    // Constructor de la clase
    public Clientes(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Métodos de acceso para obtener los valores de los atributos
    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    // Método toString para representar el cliente como una cadena de texto
    @Override
    public String toString() {
        return "Cliente: " + nombre + " - Teléfono: " + telefono;
    }
}
