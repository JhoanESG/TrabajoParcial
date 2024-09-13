package co.uniquindio.edu.Factory;

import co.uniquindio.edu.Model.*;
import co.uniquindio.edu.Services.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ModelFactory implements ICrudCliente, ICroudHabitacion, ICroudReserva, ICroudServicio, ICroudServicioHabitacion, ICroudServicioLimpieza, ICroudServicioRestaurante, ICroudServicioSpa{

    private static ModelFactory instance;
    private static Hotel hotel;

    private ModelFactory() {
        inicializarDatos();
    }

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }
    // Métodos para ICrudCliente
    @Override
    public void crearCliente(Cliente cliente) {
        hotel.getClientes().add(cliente);
    }
    @Override
    public Cliente getCliente(String dni) {
        return hotel.getClientes().stream()
                .filter(c -> c.getDNI().equals(dni))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void modificarCliente(Cliente clienteModificado) {
        List<Cliente> clientes = hotel.getClientes();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getDNI().equals(clienteModificado.getDNI())) {
                clientes.set(i, clienteModificado);
                return;
            }
        }
    }

    @Override
    public void eliminarCliente(String dni) {
        hotel.getClientes().removeIf(c -> c.getDNI().equals(dni));
    }
    // Métodos para ICrudHabitacion
    @Override
    public void crearHabitacion(Habitacion habitacion) {
        hotel.getHabitaciones().add(habitacion);
    }

    @Override
    public Habitacion obtenerHabitacion(int numero) {
        return hotel.getHabitaciones().stream()
                .filter(h -> h.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarHabitacion(Habitacion habitacionModificada) {
        List<Habitacion> habitaciones = hotel.getHabitaciones();
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getNumero() == habitacionModificada.getNumero()) {
                habitaciones.set(i, habitacionModificada);
                return;
            }
        }
    }

    @Override
    public void eliminarHabitacion(int numero) {
        hotel.getHabitaciones().removeIf(h -> h.getNumero() == numero);
    }

    @Override
    public List<Habitacion> listarHabitaciones() {
        return hotel.getHabitaciones();
    }
    // Métodos para ICrudReserva
    @Override
    public void crearReserva(Reserva reserva) {
        hotel.getReservas().add(reserva);
    }

    @Override
    public Reserva obtenerReserva(Habitacion habitacion, LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        return hotel.getReservas().stream()
                .filter(r -> r.getHabitacion().equals(habitacion) &&
                        r.getHoraEntrada().equals(horaEntrada) &&
                        r.getHoraSalida().equals(horaSalida))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarReserva(Reserva reservaModificada) {
        List<Reserva> reservas = hotel.getReservas();
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getHoraEntrada().equals(reservaModificada.getHoraEntrada())) {
                reservas.set(i, reservaModificada);
                return;
            }
        }
    }

    @Override
    public void eliminarReserva(Habitacion habitacion, LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        hotel.getReservas().removeIf(r -> r.getHabitacion().equals(habitacion) &&
                r.getHoraEntrada().equals(horaEntrada) &&
                r.getHoraSalida().equals(horaSalida));
    }

    @Override
    public List<Reserva> listarReservas() {
        return hotel.getReservas();
    }
    // Métodos para ICrudServicio
    @Override
    public void crearServicio(Servicio servicio) {
        hotel.getServicios().add(servicio);
    }

    @Override
    public Servicio obtenerServicio(String nombre) {
        return hotel.getServicios().stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarServicio(Servicio servicioModificado) {
        List<Servicio> servicios = hotel.getServicios();
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getNombre().equals(servicioModificado.getNombre())) {
                servicios.set(i, servicioModificado);
                return;
            }
        }
    }

    @Override
    public void eliminarServicio(String nombre) {
        hotel.getServicios().removeIf(s -> s.getNombre().equals(nombre));
    }

    @Override
    public List<Servicio> listarServicios() {
        return hotel.getServicios();
    }
    @Override
    public void crearServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        List<ServicioHabitacion> serviciosHabitacion = obtenerServiciosHabitacion();
        serviciosHabitacion.add(servicioHabitacion);
        hotel.setServiciosHabitacion(serviciosHabitacion);
    }

    @Override
    public ServicioHabitacion obtenerServicioHabitacion(String nombre) {
        return obtenerServiciosHabitacion().stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarServicioHabitacion(ServicioHabitacion servicioHabitacionModificado) {
        List<ServicioHabitacion> serviciosHabitacion = obtenerServiciosHabitacion();
        for (int i = 0; i < serviciosHabitacion.size(); i++) {
            if (serviciosHabitacion.get(i).getNombre().equals(servicioHabitacionModificado.getNombre())) {
                serviciosHabitacion.set(i, servicioHabitacionModificado);
                hotel.setServiciosHabitacion(serviciosHabitacion);
                return;
            }
        }
    }

    @Override
    public void eliminarServicioHabitacion(String nombre) {
        List<ServicioHabitacion> serviciosHabitacion = obtenerServiciosHabitacion();
        serviciosHabitacion.removeIf(s -> s.getNombre().equals(nombre));
        hotel.setServiciosHabitacion(serviciosHabitacion);
    }

    @Override
    public List<ServicioHabitacion> listarServiciosHabitacion() {
        return obtenerServiciosHabitacion();
    }

    // Metodo para obtener la lista de ServicioHabitacion desde el Hotel
    private List<ServicioHabitacion> obtenerServiciosHabitacion() {
        // Aquí se debe definir cómo acceder a la lista específica de servicios de habitación en el Hotel
        return hotel.getServicios().stream()
                .filter(s -> s instanceof ServicioHabitacion)
                .map(s -> (ServicioHabitacion) s)
                .collect(Collectors.toList());
    }
    // Métodos para ICrudServicioLimpieza
    @Override
    public void crearServicioLimpieza(ServicioLimpieza servicioLimpieza) {
        List<ServicioLimpieza> serviciosLimpieza = obtenerServiciosLimpieza();
        serviciosLimpieza.add(servicioLimpieza);
        hotel.setServiciosLimpieza(serviciosLimpieza);
    }

    @Override
    public ServicioLimpieza obtenerServicioLimpieza(String nombre) {
        return obtenerServiciosLimpieza().stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarServicioLimpieza(ServicioLimpieza servicioLimpiezaModificado) {
        List<ServicioLimpieza> serviciosLimpieza = obtenerServiciosLimpieza();
        for (int i = 0; i < serviciosLimpieza.size(); i++) {
            if (serviciosLimpieza.get(i).getNombre().equals(servicioLimpiezaModificado.getNombre())) {
                serviciosLimpieza.set(i, servicioLimpiezaModificado);
                hotel.setServiciosLimpieza(serviciosLimpieza);
                return;
            }
        }
    }

    @Override
    public void eliminarServicioLimpieza(String nombre) {
        List<ServicioLimpieza> serviciosLimpieza = obtenerServiciosLimpieza();
        serviciosLimpieza.removeIf(s -> s.getNombre().equals(nombre));
        hotel.setServiciosLimpieza(serviciosLimpieza);
    }

    @Override
    public List<ServicioLimpieza> listarServiciosLimpieza() {
        return obtenerServiciosLimpieza();
    }

    // Metodo  para obtener la lista de ServicioLimpieza desde el Hotel
    private List<ServicioLimpieza> obtenerServiciosLimpieza() {
        return hotel.getServicios().stream()
                .filter(s -> s instanceof ServicioLimpieza)
                .map(s -> (ServicioLimpieza) s)
                .collect(Collectors.toList());
    }
    // Métodos para ICrudServicioRestaurante
    @Override
    public void crearServicioRestaurante(ServicioRestaurante servicioRestaurante) {
        List<ServicioRestaurante> serviciosRestaurante = obtenerServiciosRestaurante();
        serviciosRestaurante.add(servicioRestaurante);
        hotel.setServiciosRestaurante(serviciosRestaurante);
    }

    @Override
    public ServicioRestaurante obtenerServicioRestaurante(String nombre) {
        return obtenerServiciosRestaurante().stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarServicioRestaurante(ServicioRestaurante servicioRestauranteModificado) {
        List<ServicioRestaurante> serviciosRestaurante = obtenerServiciosRestaurante();
        for (int i = 0; i < serviciosRestaurante.size(); i++) {
            if (serviciosRestaurante.get(i).getNombre().equals(servicioRestauranteModificado.getNombre())) {
                serviciosRestaurante.set(i, servicioRestauranteModificado);
                hotel.setServiciosRestaurante(serviciosRestaurante);
                return;
            }
        }
    }

    @Override
    public void eliminarServicioRestaurante(String nombre) {
        List<ServicioRestaurante> serviciosRestaurante = obtenerServiciosRestaurante();
        serviciosRestaurante.removeIf(s -> s.getNombre().equals(nombre));
        hotel.setServiciosRestaurante(serviciosRestaurante);
    }

    @Override
    public List<ServicioRestaurante> listarServiciosRestaurante() {
        return obtenerServiciosRestaurante();
    }

    // Metodo para obtener la lista de ServicioRestaurante desde el Hotel
    private List<ServicioRestaurante> obtenerServiciosRestaurante() {
        return hotel.getServicios().stream()
                .filter(s -> s instanceof ServicioRestaurante)
                .map(s -> (ServicioRestaurante) s)
                .collect(Collectors.toList());
    }
    // Métodos para ICrudServicioSpa
    @Override
    public void crearServicioSpa(ServicioSpa servicioSpa) {
        List<ServicioSpa> serviciosSpa = obtenerServiciosSpa();
        serviciosSpa.add(servicioSpa);
        hotel.setServiciosSpa(serviciosSpa);
    }

    @Override
    public ServicioSpa obtenerServicioSpa(String nombre) {
        return obtenerServiciosSpa().stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizarServicioSpa(ServicioSpa servicioSpaModificado) {
        List<ServicioSpa> serviciosSpa = obtenerServiciosSpa();
        for (int i = 0; i < serviciosSpa.size(); i++) {
            if (serviciosSpa.get(i).getNombre().equals(servicioSpaModificado.getNombre())) {
                serviciosSpa.set(i, servicioSpaModificado);
                hotel.setServiciosSpa(serviciosSpa);
                return;
            }
        }
    }

    @Override
    public void eliminarServicioSpa(String nombre) {
        List<ServicioSpa> serviciosSpa = obtenerServiciosSpa();
        serviciosSpa.removeIf(s -> s.getNombre().equals(nombre));
        hotel.setServiciosSpa(serviciosSpa);
    }

    @Override
    public List<ServicioSpa> listarServiciosSpa() {
        return obtenerServiciosSpa();
    }

    // Metodo para obtener la lista de ServicioSpa desde el Hotel
    private List<ServicioSpa> obtenerServiciosSpa() {
        return hotel.getServicios().stream()
                .filter(s -> s instanceof ServicioSpa)
                .map(s -> (ServicioSpa) s)
                .collect(Collectors.toList());
    }

    //ejemplo public String calcularTotalPasajeros(String placa) {
    //        return empresaTransporte.calcularTotalPasajeros(placa);
    //    }

    private static void inicializarDatos(){
        //hotel = new Hotel("Hotel del señor ", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()); OPCIONAL
        hotel= new Hotel();
        hotel.setNombre("Hotel del señor");

        // Servicios
        ServicioHabitacion servicioHabitacion1 = new ServicioHabitacion("WiFi", 10.0);
        ServicioHabitacion servicioHabitacion2 = new ServicioHabitacion("Minibar", 15.0);
        ServicioHabitacion servicioHabitacion3 = new ServicioHabitacion("Desayuno incluido", 20.0);

        ServicioLimpieza servicioLimpieza1 = new ServicioLimpieza("Limpieza diaria", 25.0);
        ServicioLimpieza servicioLimpieza2 = new ServicioLimpieza("Limpieza profunda", 50.0);

        ServicioRestaurante servicioRestaurante1 = new ServicioRestaurante("Cena gourmet", 50.0);
        ServicioRestaurante servicioRestaurante2 = new ServicioRestaurante("Almuerzo buffet", 30.0);

        ServicioSpa servicioSpa1 = new ServicioSpa("Masaje relajante", 80.0);
        ServicioSpa servicioSpa2 = new ServicioSpa("Tratamiento facial", 70.0);

        // Agregar servicios al hotel
        hotel.getServicios().add(servicioHabitacion1);
        hotel.getServicios().add(servicioHabitacion2);
        hotel.getServicios().add(servicioHabitacion3);
        hotel.getServicios().add(servicioLimpieza1);
        hotel.getServicios().add(servicioLimpieza2);
        hotel.getServicios().add(servicioRestaurante1);
        hotel.getServicios().add(servicioRestaurante2);
        hotel.getServicios().add(servicioSpa1);
        hotel.getServicios().add(servicioSpa2);

        // Habitaciones
        List<Servicio> serviciosHabitacion1 = Arrays.asList(servicioHabitacion1, servicioLimpieza1, servicioRestaurante1);
        List<Servicio> serviciosHabitacion2 = Arrays.asList(servicioHabitacion2, servicioLimpieza2, servicioRestaurante2);
        List<Servicio> serviciosHabitacion3 = Arrays.asList(servicioHabitacion3, servicioSpa1);
        List<Servicio> serviciosHabitacion4 = Arrays.asList(servicioLimpieza1, servicioSpa2);

        Habitacion habitacion1 = new Habitacion(101, TipoHabitacion.SIMPLE, 100.0, serviciosHabitacion1, null);
        Habitacion habitacion2 = new Habitacion(102, TipoHabitacion.DOBLE, 150.0, serviciosHabitacion2, null);
        Habitacion habitacion3 = new Habitacion(201, TipoHabitacion.SUITE, 300.0, serviciosHabitacion3, null);
        Habitacion habitacion4 = new Habitacion(202, TipoHabitacion.DOBLE, 500.0, serviciosHabitacion4, null);

        hotel.getHabitaciones().add(habitacion1);
        hotel.getHabitaciones().add(habitacion2);
        hotel.getHabitaciones().add(habitacion3);
        hotel.getHabitaciones().add(habitacion4);

        // Clientes
        Cliente cliente1 = new Cliente("Juan Pérez", "12345678A", new ArrayList<>());
        Cliente cliente2 = new Cliente("María López", "87654321B", new ArrayList<>());
        Cliente cliente3 = new Cliente("Carlos Fernández", "11223344C", new ArrayList<>());
        Cliente cliente4 = new Cliente("Ana Gómez", "55667788D", new ArrayList<>());
        Cliente cliente5 = new Cliente("Luis Martínez", "99887766E", new ArrayList<>());

        hotel.getClientes().add(cliente1);
        hotel.getClientes().add(cliente2);
        hotel.getClientes().add(cliente3);
        hotel.getClientes().add(cliente4);
        hotel.getClientes().add(cliente5);

        // Reservas
        Reserva reserva1 = new Reserva(LocalDateTime.of(2024, 10, 1, 14, 0), LocalDateTime.of(2024, 10, 5, 12, 0), habitacion1);
        Reserva reserva2 = new Reserva(LocalDateTime.of(2024, 10, 10, 14, 0), LocalDateTime.of(2024, 10, 15, 12, 0), habitacion2);
        Reserva reserva3 = new Reserva(LocalDateTime.of(2024, 11, 1, 14, 0), LocalDateTime.of(2024, 11, 7, 12, 0), habitacion3);
        Reserva reserva4 = new Reserva(LocalDateTime.of(2024, 11, 10, 14, 0), LocalDateTime.of(2024, 11, 15, 12, 0), habitacion4);
        Reserva reserva5 = new Reserva(LocalDateTime.of(2024, 12, 1, 14, 0), LocalDateTime.of(2024, 12, 5, 12, 0), habitacion1);

        hotel.getReservas().add(reserva1);
        hotel.getReservas().add(reserva2);
        hotel.getReservas().add(reserva3);
        hotel.getReservas().add(reserva4);
        hotel.getReservas().add(reserva5);

        // Asignación de reservas a habitaciones
        habitacion1.setReserva(reserva1);
        habitacion2.setReserva(reserva2);
        habitacion3.setReserva(reserva3);
        habitacion4.setReserva(reserva4);

        // Asignación de servicios a clientes
        cliente1.getServicios().add(servicioHabitacion1);
        cliente1.getServicios().add(servicioSpa1);

        cliente2.getServicios().add(servicioRestaurante1);
        cliente2.getServicios().add(servicioLimpieza2);

        cliente3.getServicios().add(servicioHabitacion2);
        cliente3.getServicios().add(servicioSpa2);

        cliente4.getServicios().add(servicioHabitacion3);
        cliente4.getServicios().add(servicioRestaurante2);

        cliente5.getServicios().add(servicioLimpieza1);
        cliente5.getServicios().add(servicioSpa1);

        // Asignación de clientes a reservas
        reserva1.getHabitacion().setReserva(reserva1);
        reserva2.getHabitacion().setReserva(reserva2);
        reserva3.getHabitacion().setReserva(reserva3);
        reserva4.getHabitacion().setReserva(reserva4);

    }

}
