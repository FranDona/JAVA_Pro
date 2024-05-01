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
            System.out.println("[1] Realizar una reserva");
            System.out.println("[2] Ver reservas existentes");
            System.out.println("---------------------------");
            System.out.println("[3]. Ver mesas disponibles");
            System.out.println("[4]. Añadir nuevas mesas");
            System.out.println("---------------------------");
            System.out.println("[5]. Salir");
            System.out.print("Por favor, seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
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
                    
                    // Mostrar mesas disponibles
                    System.out.println("Mesas disponibles:");
                    boolean hayMesasDisponibles = false;
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
                            hayMesasDisponibles = true;
                        }
                    }
                    if (!hayMesasDisponibles) {
                        System.out.println("Sin espacio disponible actualmente. Intentelo más tarde");
                        break;
                    }

                    // Seleccionar el número de mesa a reservar
                    System.out.println("Por favor, seleccione el número de mesa que desea reservar:");
                    int mesaSeleccionada = Integer.parseInt(scanner.nextLine());

                    // Seleccionar el turno de la comida
                    System.out.println("Por favor, ingrese el turno de comida (Almuerzo/Cena):");
                    String turno = scanner.nextLine();

                    Clientes clientes = new Clientes(nombreCliente, telefonoCliente);
                    Reservas reserva = new Reservas(fechaReserva, turno, numComensales, clientes, mesaSeleccionada);

                    // Solicitar detalles del pago
                    System.out.println("Por favor, ingrese el método de pago (Bizum/Tarjeta de crédito/Efectivo):");
                    String metodoPago = scanner.nextLine();

                    // Importe a pagar en la comida
                    System.out.println("Por favor, ingrese el importe a pagar:");
                    double importePago = Double.parseDouble(scanner.nextLine());

                    Pago pago = new Pago(metodoPago, importePago);

                    // Asignar mesa y registrar pago
                    Mesa mesaAsignada = metre.asignarMesa(reserva);
                    if (mesaAsignada != null) {
                        System.out.println("Reserva realizada correctamente. Mesa asignada: " + mesaAsignada);
                        mesaAsignada.agregarPago(importePago);
                        System.out.println("Pago registrado correctamente: " + pago);
                        System.out.println("Total pagado en la mesa " + mesaAsignada.getNumero() + ": " + mesaAsignada.getTotalPagado());

                        // Agregar la reserva realizada a la lista de reservas
                        reservasRealizadas.add(reserva);
                    } else {
                        System.out.println("\n\n-> Lo sentimos, no hay mesas disponibles para esa reserva. <-");
                    }
                    break;
                case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                    // Ver reservas existentes
                    System.out.println("\nReservas existentes:");
                    if (reservasRealizadas.isEmpty()) {
                        System.out.println("No hay reservas existentes. Prueba a añadir nuevas reservas");
                    } else {
                        for (Reservas reservas : reservasRealizadas) {
                            System.out.println(reservas);
                        }
                    }
                    break;
                    case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    // Mostrar mesas disponibles
                    System.out.println("Mesas disponibles:");
                    boolean hayMesasDisponibles2 = false;
                    for (Mesa mesa : mesas) {
                        boolean mesaDisponible = true;
                        for (Reservas reservas : reservasRealizadas) {
                            if (reservas.getMesa() == mesa) {
                                mesaDisponible = false;
                                break;
                            }
                        }
                        if (mesaDisponible) {
                            System.out.println("Mesa " + mesa.getNumero() + " - Capacidad: " + mesa.getCapacidad() +
                                    " - Ubicación: " + mesa.getUbicacion());
                            hayMesasDisponibles2 = true;
                        }
                    }
                
                    // Verificar si hay mesas disponibles
                    if (!hayMesasDisponibles2) {
                        System.out.println("Sin mesas disponibles actualmente. Pruebe a añadir nuevas mesas");
                    }
                    break;                
                case 4:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                    // Añadir nuevas mesas
                    System.out.println("\nAñadir nuevas mesas:");
                    System.out.println("Por favor, ingrese el número de la mesa:");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.println("Por favor, ingrese la capacidad de la mesa:");
                    int capacidadMesa = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    System.out.println("Por favor, ingrese la ubicación de la mesa (interior/terraza):");
                    String ubicacionMesa = scanner.nextLine();

                    Mesa nuevaMesa = new Mesa(numeroMesa, capacidadMesa, ubicacionMesa);
                    mesas.add(nuevaMesa);
                    System.out.println("\n\nMesa añadida correctamente: \n" + nuevaMesa);
                    break;
                case 5:            
                System.out.print("\033[H\033[2J");
                System.out.flush();
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
