package com.restaurante;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a la aplicación de gestión de reservas y pagos.");

        // Solicitar datos del cliente
        System.out.println("Por favor, ingrese su nombre:");
        String nombreCliente = scanner.nextLine();

        System.out.println("Por favor, ingrese su número de teléfono:");
        String telefonoCliente = scanner.nextLine();

        Clientes clientes = new Clientes(nombreCliente, telefonoCliente);

        // Solicitar detalles de la reserva
        System.out.println("Por favor, ingrese la fecha de la reserva (YYYY-MM-DD):");
        LocalDate fechaReserva = LocalDate.parse(scanner.nextLine());

        System.out.println("Por favor, ingrese el número de comensales:");
        int numComensales = Integer.parseInt(scanner.nextLine());

        System.out.println("Por favor, ingrese la ubicación de la mesa (interior/terraza):");
        String ubicacionMesa = scanner.nextLine();

        System.out.println("Por favor, ingrese el turno de comida (1-4):");
        int turnoComida = Integer.parseInt(scanner.nextLine());

        Reservas reservas = new Reservas(fechaReserva, turnoComida, numComensales, ubicacionMesa, clientes);

        // Solicitar detalles del pago
        System.out.println("Por favor, ingrese el método de pago (Bizum/Tarjeta de crédito/Efectivo):");
        String metodoPago = scanner.nextLine();

        System.out.println("Por favor, ingrese el importe a pagar:");
        double importePago = Double.parseDouble(scanner.nextLine());

        Pago pago = new Pago(metodoPago, importePago);

        // Crear algunas mesas
        Mesa mesa1 = new Mesa(1, 4, "interior");
        Mesa mesa2 = new Mesa(2, 6, "terraza");
        Mesa mesa3 = new Mesa(3, 8, "interior");

        // Crear una lista mutable de mesas
        List<Mesa> mesas = new ArrayList<>();
        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);

        // Crear un MetreInteligente con las mesas
        MetreInteligente metre = new MetreInteligente(mesas);

        // Asignar mesa y registrar pago
        Mesa mesaAsignada = metre.asignarMesa(reservas);
        if (mesaAsignada != null) {
            System.out.println("Reserva realizada correctamente. \nMesa asignada: " + mesaAsignada);
            mesaAsignada.agregarPago(importePago);
            System.out.println("Pago registrado correctamente: " + pago);
            System.out.println("Total pagado en la mesa " + mesaAsignada.getNumero() + ": " + mesaAsignada.getTotalPagado());
        } else {
            System.out.println("Lo sentimos, no hay mesas disponibles para esa reserva.");
        }

        // Cerrar el scanner
        scanner.close();
    }
}
