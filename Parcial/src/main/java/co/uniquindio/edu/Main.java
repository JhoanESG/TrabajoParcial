package co.uniquindio.edu;

import co.uniquindio.edu.Factory.ModelFactory;
import co.uniquindio.edu.Model.*;
import co.uniquindio.edu.Services.ICrudCliente;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * Metodo principal que inicia la aplicación.
     * Crea la empresa de transporte y muestra el menú principal.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        //calcularTotalPasajeros(modelFactory); //aca se llaman los metodos?
//    System.out.println(hotel.toString());

        // Inicializar datos de ejemplo
        inicializarDatosEjemplo(modelFactory);
        //operaciones con cruds
        crudCliente(modelFactory);
        crudHabitacion(modelFactory);
        crudReserva(modelFactory);
        crudServicio(modelFactory);
        crudServicioHabitacion(modelFactory);
        crudServicioLimpieza(modelFactory);
        crudServicioRestaurante(modelFactory);
        crudServicioSpa(modelFactory);
    }


    private static void inicializarDatosEjemplo(ModelFactory modelFactory) {
        // Crear y agregar un cliente de ejemplo
        Cliente cliente = new Cliente("Juan Pérez", "12345678A", new ArrayList<>());
        modelFactory.crearCliente(cliente);

        // Crear y agregar una habitación de ejemplo
        Habitacion habitacion = new Habitacion(101, TipoHabitacion.SIMPLE, 150.0, new ArrayList<>(), null);
        modelFactory.crearHabitacion(habitacion);

        // Crear y agregar una reserva de ejemplo
        Reserva reserva = new Reserva(LocalDateTime.now(), LocalDateTime.now().plusDays(1), habitacion);
        modelFactory.crearReserva(reserva);

        // Crear y agregar un servicio de ejemplo
        Servicio servicio = new ServicioHabitacion("Wi-Fi", 20.0);
        modelFactory.crearServicio(servicio);
    }

    private static void crudCliente(ModelFactory modelFactory) {
        // Crear un cliente
        Cliente nuevoCliente = new Cliente("Ana García", "87654321B", new ArrayList<>());
        modelFactory.crearCliente(nuevoCliente);

        // Obtener un cliente
        Cliente clienteObtenido = modelFactory.getCliente("87654321B");
        System.out.println("Cliente obtenido: " + clienteObtenido);

        // Modificar un cliente
        nuevoCliente.setNombre("Ana García López");
        modelFactory.modificarCliente(nuevoCliente);

        // Eliminar un cliente
        modelFactory.eliminarCliente("87654321B");
        System.out.println("Cliente eliminado: " + (modelFactory.getCliente("87654321B") == null));
    }

    private static void crudHabitacion(ModelFactory modelFactory) {
        // Crear una habitación
        Habitacion nuevaHabitacion = new Habitacion(102, TipoHabitacion.DOBLE, 100.0, new ArrayList<>(), null);
        modelFactory.crearHabitacion(nuevaHabitacion);

        // Obtener una habitación
        Habitacion habitacionObtenida = modelFactory.obtenerHabitacion(102);
        System.out.println("Habitación obtenida: " + habitacionObtenida);

        // Modificar una habitación
        nuevaHabitacion.setPrecio(120.0);
        modelFactory.actualizarHabitacion(nuevaHabitacion);

        // Eliminar una habitación
        modelFactory.eliminarHabitacion(102);
        System.out.println("Habitación eliminada: " + (modelFactory.obtenerHabitacion(102) == null));
    }

    private static void crudReserva(ModelFactory modelFactory) {
        // Crear una reserva
        Habitacion habitacion = modelFactory.obtenerHabitacion(101);
        Reserva nuevaReserva = new Reserva(LocalDateTime.now(), LocalDateTime.now().plusDays(2), habitacion);
        modelFactory.crearReserva(nuevaReserva);

        // Obtener una reserva
        Reserva reservaObtenida = modelFactory.obtenerReserva(habitacion, LocalDateTime.now(), LocalDateTime.now().plusDays(2));
        System.out.println("Reserva obtenida: " + reservaObtenida);

        // Modificar una reserva
        nuevaReserva.setHoraSalida(LocalDateTime.now().plusDays(3));
        modelFactory.actualizarReserva(nuevaReserva);

        // Eliminar una reserva
        modelFactory.eliminarReserva(habitacion, LocalDateTime.now(), LocalDateTime.now().plusDays(3));
        System.out.println("Reserva eliminada: " + (modelFactory.obtenerReserva(habitacion, LocalDateTime.now(), LocalDateTime.now().plusDays(3)) == null));
    }

    private static void crudServicio(ModelFactory modelFactory) {
        // Crear un servicio
        Servicio nuevoServicio = new ServicioHabitacion("Desayuno", 30.0);
        modelFactory.crearServicio(nuevoServicio);

        // Obtener un servicio
        Servicio servicioObtenido = modelFactory.obtenerServicio("Desayuno");
        System.out.println("Servicio obtenido: " + servicioObtenido);

        // Modificar un servicio
        nuevoServicio.setPrecio(35.0);
        modelFactory.actualizarServicio(nuevoServicio);

        // Eliminar un servicio
        modelFactory.eliminarServicio("Desayuno");
        System.out.println("Servicio eliminado: " + (modelFactory.obtenerServicio("Desayuno") == null));
    }

    private static void crudServicioHabitacion(ModelFactory modelFactory) {
        // Crear un servicio de habitación
        ServicioHabitacion nuevoServicioHabitacion = new ServicioHabitacion("Minibar", 18.0);
        modelFactory.crearServicioHabitacion(nuevoServicioHabitacion);

        // Obtener un servicio de habitación
        ServicioHabitacion servicioHabitacionObtenido = modelFactory.obtenerServicioHabitacion("Minibar");
        System.out.println("Servicio de habitación obtenido: " + servicioHabitacionObtenido);

        // Modificar un servicio de habitación
        nuevoServicioHabitacion.setPrecio(18.9);
        modelFactory.actualizarServicioHabitacion(nuevoServicioHabitacion);

        // Eliminar un servicio de habitación
        modelFactory.eliminarServicioHabitacion("Minibar");
        System.out.println("Servicio de habitación eliminado: " + (modelFactory.obtenerServicioHabitacion("Minibar") == null));
    }

    private static void crudServicioLimpieza(ModelFactory modelFactory) {
        // Crear un servicio de limpieza
        ServicioLimpieza nuevoServicioLimpieza = new ServicioLimpieza("Limpieza diaria", 45.0);
        modelFactory.crearServicioLimpieza(nuevoServicioLimpieza);

        // Obtener un servicio de limpieza
        ServicioLimpieza servicioLimpiezaObtenido = modelFactory.obtenerServicioLimpieza("Limpieza diaria");
        System.out.println("Servicio de limpieza obtenido: " + servicioLimpiezaObtenido);

        // Modificar un servicio de limpieza
        nuevoServicioLimpieza.setPrecio(45.9);
        modelFactory.actualizarServicioLimpieza(nuevoServicioLimpieza);

        // Eliminar un servicio de limpieza
        modelFactory.eliminarServicioLimpieza("Limpieza diaria");
        System.out.println("Servicio de limpieza eliminado: " + (modelFactory.obtenerServicioLimpieza("Limpieza diaria") == null));
    }

    private static void crudServicioRestaurante(ModelFactory modelFactory) {
        // Crear un servicio de restaurante
        ServicioRestaurante nuevoServicioRestaurante = new ServicioRestaurante("Cena gourmet", 23.0);
        modelFactory.crearServicioRestaurante(nuevoServicioRestaurante);

        // Obtener un servicio de restaurante
        ServicioRestaurante servicioRestauranteObtenido = modelFactory.obtenerServicioRestaurante("Cena gourmet");
        System.out.println("Servicio de restaurante obtenido: " + servicioRestauranteObtenido);

        // Modificar un servicio de restaurante
        nuevoServicioRestaurante.setPrecio(23.8);
        modelFactory.actualizarServicioRestaurante(nuevoServicioRestaurante);

        // Eliminar un servicio de restaurante
        modelFactory.eliminarServicioRestaurante("Cena gourmet");
        System.out.println("Servicio de restaurante eliminado: " + (modelFactory.obtenerServicioRestaurante("Cena gourmet") == null));
    }

    private static void crudServicioSpa(ModelFactory modelFactory) {
        // Crear un servicio de spa
        ServicioSpa nuevoServicioSpa = new ServicioSpa("Masaje relajante", 27.0);
        modelFactory.crearServicioSpa(nuevoServicioSpa);

        // Obtener un servicio de spa
        ServicioSpa servicioSpaObtenido = modelFactory.obtenerServicioSpa("Masaje relajante");
        System.out.println("Servicio de spa obtenido: " + servicioSpaObtenido);

        // Modificar un servicio de spa
        nuevoServicioSpa.setPrecio(27.9);
        modelFactory.actualizarServicioSpa(nuevoServicioSpa);

        // Eliminar un servicio de spa
        modelFactory.eliminarServicioSpa("Masaje relajante");
        System.out.println("Servicio de spa eliminado: " + (modelFactory.obtenerServicioSpa("Masaje Relajante") == null));
    }
}

//ejemplo private static void calcularTotalPasajeros(ModelFactory modelFactory) {
////        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo");
//        String placa = "qwe232";
//
//        String mensaje = modelFactory.calcularTotalPasajeros(placa);
//    }

        // Menú principal para gestionar las operaciones del hotel
//        private static void menuPrincipal(Hotel hotel) {
//            String option;
//            do {
//                option = JOptionPane.showInputDialog("Bienvenido al Menú de gestión:\n\n"
//                        + "1. Crear cliente y su reserva.\n"
//                        + "2. Calcular total de clientes en una habitación.\n"
//                        + "3. Mostrar lista de habitaciones con servicios incluidos.\n"
//                        + "4. Obtener número de clientes con más de 2 reservas.\n"
//                        + "5. Encontrar reservas dentro de un rango de fechas.\n"
//                        + "6. Calcular el precio de una reserva.\n\n"
//                        + "0. Salir");
//
//                switch (option) {
//                    case "1":
//                        crearClienteYReserva(hotel);
//                        break;
//                    case "2":
//                        calcularTotalClientesEnHabitacion(hotel);
//                        break;
//                    case "3":
//                        mostrarHabitacionesConServicios(hotel);
//                        break;
//                    case "4":
//                        obtenerClientesConMasDe2Reservas(hotel);
//                        break;
//                    case "5":
//                        encontrarReservasPorRangoDeFechas(hotel);
//                        break;
//                    case "6":
//                        calcularPrecioReserva(hotel);
//                        break;
//                    case "0":
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(null, "Opción no válida.");
//                }
//            } while (!option.equals("0"));
//        }
//
//        private static void crearClienteYReserva(Hotel hotel) {
//            // Crear un cliente
//            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
//            String DNI = JOptionPane.showInputDialog("Ingrese el DNI del cliente:");
//            Cliente cliente = new Cliente(nombre, DNI, new ArrayList<>());
//
//            // Crear una habitación
//            int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la habitación:"));
//            Habitacion habitacion = hotel.obtenerHabitacion(numeroHabitacion);
//
//            // Crear una reserva
//            LocalDateTime horaEntrada = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la hora de entrada (YYYY-MM-DDTHH:MM:SS):"));
//            LocalDateTime horaSalida = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la hora de salida (YYYY-MM-DDTHH:MM:SS):"));
//            Reserva reserva = new Reserva(horaEntrada, horaSalida, habitacion);
//
//            // Agregar la reserva al cliente y la habitación
//            cliente.getReservas().add(reserva);
//            habitacion.setReserva(reserva);
//
//            // Agregar el cliente al hotel
//            hotel.agregarCliente(cliente);
//            hotel.agregarReserva(reserva);
//
//            JOptionPane.showMessageDialog(null, "Cliente y reserva creados exitosamente.");
//        }
//
//        private static void calcularTotalClientesEnHabitacion(Hotel hotel) {
//            int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la habitación:"));
//            Habitacion habitacion = hotel.obtenerHabitacion(numeroHabitacion);
//
//            if (habitacion == null) {
//                JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
//                return;
//            }
//
//            int totalClientes = 0;
//            for (Reserva reserva : hotel.getReservas()) {
//                if (reserva.getHabitacion().equals(habitacion)) {
//                    totalClientes++;
//                }
//            }
//
//            JOptionPane.showMessageDialog(null, "Total de clientes en la habitación " + numeroHabitacion + ": " + totalClientes);
//        }
//
//        private static void mostrarHabitacionesConServicios(Hotel hotel) {
//            StringBuilder resultado = new StringBuilder("Habitaciones con servicios incluidos:\n");
//            for (Habitacion habitacion : hotel.getHabitaciones()) {
//                resultado.append("Habitación ").append(habitacion.getNumero()).append(": ");
//                if (habitacion.getServicios().isEmpty()) {
//                    resultado.append("No tiene servicios incluidos.\n");
//                } else {
//                    resultado.append("Servicios: ");
//                    for (Servicio servicio : habitacion.getServicios()) {
//                        resultado.append(servicio.getNombre()).append(", ");
//                    }
//                    resultado.setLength(resultado.length() - 2); // Eliminar la última coma y espacio
//                    resultado.append("\n");
//                }
//            }
//            JOptionPane.showMessageDialog(null, resultado.toString());
//        }
//
//        private static void obtenerClientesConMasDe2Reservas(Hotel hotel) {
//            List<Cliente> clientesConMasDe2Reservas = new ArrayList<>();
//            for (Cliente cliente : hotel.getClientes()) {
//                if (cliente.getReservas().size() > 2) {
//                    clientesConMasDe2Reservas.add(cliente);
//                }
//            }
//
//            StringBuilder resultado = new StringBuilder("Clientes con más de 2 reservas:\n");
//            for (Cliente cliente : clientesConMasDe2Reservas) {
//                resultado.append(cliente.getNombre()).append(" (DNI: ").append(cliente.getDNI()).append(")\n");
//            }
//
//            if (clientesConMasDe2Reservas.isEmpty()) {
//                resultado.append("No hay clientes con más de 2 reservas.");
//            }
//
//            JOptionPane.showMessageDialog(null, resultado.toString());
//        }
//
//        private static void encontrarReservasPorRangoDeFechas(Hotel hotel) {
//            LocalDateTime fechaInicio = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la fecha de inicio (YYYY-MM-DDTHH:MM:SS):"));
//            LocalDateTime fechaFin = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la fecha de fin (YYYY-MM-DDTHH:MM:SS):"));
//
//            StringBuilder resultado = new StringBuilder("Reservas dentro del rango de fechas:\n");
//            for (Reserva reserva : hotel.getReservas()) {
//                if ((reserva.getHoraEntrada().isAfter(fechaInicio) || reserva.getHoraEntrada().isEqual(fechaInicio)) &&
//                        (reserva.getHoraSalida().isBefore(fechaFin) || reserva.getHoraSalida().isEqual(fechaFin))) {
//                    resultado.append("Habitación: ").append(reserva.getHabitacion().getNumero())
//                            .append(", Entrada: ").append(reserva.getHoraEntrada())
//                            .append(", Salida: ").append(reserva.getHoraSalida())
//                            .append("\n");
//                }
//            }
//
//            if (resultado.length() == "Reservas dentro del rango de fechas:\n".length()) {
//                resultado.append("No hay reservas en el rango de fechas.");
//            }
//
//            JOptionPane.showMessageDialog(null, resultado.toString());
//        }
//
//        private static void calcularPrecioReserva(Hotel hotel) {
//            int numeroHabitacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de la habitación:"));
//            Habitacion habitacion = hotel.obtenerHabitacion(numeroHabitacion);
//
//            if (habitacion == null) {
//                JOptionPane.showMessageDialog(null, "Habitación no encontrada.");
//                return;
//            }
//
//            LocalDateTime horaEntrada = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la hora de entrada (YYYY-MM-DDTHH:MM:SS):"));
//            LocalDateTime horaSalida = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la hora de salida (YYYY-MM-DDTHH:MM:SS):"));
//
//            Reserva reserva = new Reserva(horaEntrada, horaSalida, habitacion);
//            long duracionEnHoras = java.time.Duration.between(horaEntrada, horaSalida).toHours();
//            double precio = habitacion.getPrecio() * (duracionEnHoras / 24.0); // Precio por día
//
//            JOptionPane.showMessageDialog(null, "El precio de la reserva es: " + precio);
//        }
