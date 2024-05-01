package com.restaurante;


import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mesa> mesas = new ArrayList<>();
        MetreInteligente metre = new MetreInteligente(mesas);
        List<Reservas> reservasRealizadas = new ArrayList<>(); // Lista para almacenar las reservas realizadas

        System.out.println("Bienvenido a la aplicación de gestión de reservas y pagos.");

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Realizar una reserva");
            System.out.println("2. Ver reservas existentes");
            System.out.println("3. Ver mesas existentes");
            System.out.println("4. Añadir mesas nuevas");
            System.out.println("5. Salir");
            System.out.print("Por favor, seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Realizar una reserva
                    System.out.println("\nRealizar una reserva:");
                    System.out.println("Por favor, ingrese su nombre:");
                    String nombreCliente = scanner.nextLine();

                    System.out.println("Por favor, ingrese su número de teléfono:");
                    String telefonoCliente = scanner.nextLine();

                    System.out.println("Por favor, ingrese la fecha de la reserva (YYYY-MM-DD):");
                    LocalDate fechaReserva = LocalDate.parse(scanner.nextLine());

                    System.out.println("Por favor, ingrese el número de comensales:");
                    int numComensales = Integer.parseInt(scanner.nextLine());

                    System.out.println("Por favor, ingrese la ubicación de la mesa (interior/terraza):");
                    String ubicacionMesa = scanner.nextLine();

                    System.out.println("Por favor, ingrese el turno de comida (1-4):");
                    int turnoComida = Integer.parseInt(scanner.nextLine());

                    Clientes clientes = new Clientes(nombreCliente, telefonoCliente);
                    Reservas reservas = new Reservas(fechaReserva, turnoComida, numComensales, ubicacionMesa, clientes);

                    // Solicitar detalles del pago
                    System.out.println("Por favor, ingrese el método de pago (Bizum/Tarjeta de crédito/Efectivo):");
                    String metodoPago = scanner.nextLine();

                    System.out.println("Por favor, ingrese el importe a pagar:");
                    double importePago = Double.parseDouble(scanner.nextLine());

                    Pago pago = new Pago(metodoPago, importePago);

                    // Asignar mesa y registrar pago
                    Mesa mesaAsignada = metre.asignarMesa(reservas);
                    if (mesaAsignada != null) {
                        System.out.println("Reserva realizada correctamente. Mesa asignada: " + mesaAsignada);
                        mesaAsignada.agregarPago(importePago);
                        System.out.println("Pago registrado correctamente: " + pago);
                        System.out.println("Total pagado en la mesa " + mesaAsignada.getNumero() + ": " + mesaAsignada.getTotalPagado());

                        // Agregar la reserva realizada a la lista de reservas
                        reservasRealizadas.add(reservas);
                    } else {
                        System.out.println("Lo sentimos, no hay mesas disponibles para esa reserva.");
                    }
                    break;
                case 2:
                    // Ver reservas existentes
                    System.out.println("\nReservas existentes:");
                    for (Reservas reserva : reservasRealizadas) {
                        System.out.println(reserva);
                    }
                    break;
                    case 3:
                    // Ver mesas disponibles
                    System.out.println("\nMesas disponibles:");
                    for (Mesa mesa : mesas) {
                        boolean mesaDisponible = true;
                        for (Reservas reserva : reservasRealizadas) {
                            if (reserva.getMesa() == mesa) {
                                mesaDisponible = false;
                                break;
                            }
                        }
                        if (mesaDisponible) {
                            System.out.println("Mesa " + mesa.getNumero() + " - Capacidad: " + mesa.getCapacidad() +
                                    " - Ubicación: " + mesa.getUbicacion());
                        } else {
                            System.out.println("Mesa " + mesa.getNumero() + " - ¡Reservada!");
                        }
                    }
                    break;
                    case 4:
                    // Añadir una nueva mesa
                    System.out.println("\nAñadir una nueva mesa:");
                    System.out.println("Por favor, ingrese el número de la mesa:");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                
                    System.out.println("Por favor, ingrese la capacidad de la mesa:");
                    int capacidadMesa = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                
                    System.out.println("Por favor, ingrese la ubicación de la mesa (interior/terraza):");
                    String ubicacionMesaNueva = scanner.nextLine();
                
                    Mesa nuevaMesa = new Mesa(numeroMesa, capacidadMesa, ubicacionMesaNueva);
                    mesas.add(nuevaMesa);
                    System.out.println("Mesa añadida correctamente: " + nuevaMesa);
                    break;
                case 5:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }
}
