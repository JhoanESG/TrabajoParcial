package co.uniquindio.edu.Model;

import co.uniquindio.edu.Services.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Hotel implements ICrudCliente, ICroudHabitacion, ICroudReserva, ICroudServicio, ICroudServicioHabitacion, ICroudServicioLimpieza, ICroudServicioRestaurante, ICroudServicioSpa {
    private String nombre;
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Servicio> servicios;
    private List<Reserva> reservas;
    private List<ServicioHabitacion>serviciosHabitacion;
    private List<ServicioLimpieza>serviciosLimpieza;
    private List<ServicioRestaurante>serviciosRestaurante;
    private List<ServicioSpa>serviciosSpa;

    public Hotel(String nombre, List<Habitacion> habitaciones, List<Cliente> clientes, List<Servicio> servicios, List<Reserva> reservas) {
        this.nombre = nombre;
        this.habitaciones = habitaciones;
        this.clientes = clientes;
        this.servicios = servicios;
        this.reservas = reservas;
    }

    public Hotel() {
        
    }

    @Override
    public void crearCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente creado: " + cliente.getNombre());
    }

    @Override
    public void eliminarCliente(String dni) {
        Optional<Cliente> clienteOpt = clientes.stream()
                .filter(c -> c.getDNI().equals(dni))
                .findFirst();

        clienteOpt.ifPresent(cliente -> {
            clientes.remove(cliente);
            System.out.println("Cliente con DNI " + dni + " eliminado.");
        });
    }

    @Override
    public void modificarCliente(Cliente clienteModificado) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getDNI().equals(clienteModificado.getDNI())) {
                clientes.set(i, clienteModificado);
                System.out.println("Cliente con DNI " + clienteModificado.getDNI() + " modificado.");
                return;
            }
        }
        System.out.println("Cliente con DNI " + clienteModificado.getDNI() + " no encontrado.");
    }

    @Override
    public Cliente getCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDNI().equals(dni)) {
                System.out.println("Cliente encontrado: " + cliente.getNombre());
                return cliente;
            }
        }
        System.out.println("Cliente con DNI " + dni + " no encontrado.");
        return null;
    }
    @Override
    public void crearHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
        System.out.println("Habitación creada: " + habitacion.getNumero());
    }

    @Override
    public Habitacion obtenerHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                System.out.println("Habitación encontrada: " + numero);
                return habitacion;
            }
        }
        System.out.println("Habitación con número " + numero + " no encontrada.");
        return null;
    }

    @Override
    public void actualizarHabitacion(Habitacion habitacionModificada) {
        for (int i = 0; i < habitaciones.size(); i++) {
            Habitacion habitacion = habitaciones.get(i);
            if (habitacion.getNumero() == habitacionModificada.getNumero()) {
                habitaciones.set(i, habitacionModificada);
                System.out.println("Habitación con número " + habitacionModificada.getNumero() + " modificada.");
                return;
            }
        }
        System.out.println("Habitación con número " + habitacionModificada.getNumero() + " no encontrada.");
    }

    @Override
    public void eliminarHabitacion(int numero) {
        Optional<Habitacion> habitacionOpt = habitaciones.stream()
                .filter(h -> h.getNumero() == numero)
                .findFirst();

        habitacionOpt.ifPresent(habitacion -> {
            habitaciones.remove(habitacion);
            System.out.println("Habitación con número " + numero + " eliminada.");
        });
    }

    @Override
    public List<Habitacion> listarHabitaciones() {
        return habitaciones;
    }
    @Override
    public void crearReserva(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Reserva creada: Habitación " + reserva.getHabitacion().getNumero() +
                " desde " + reserva.getHoraEntrada() + " hasta " + reserva.getHoraSalida());
    }

    @Override
    public Reserva obtenerReserva(Habitacion habitacion, LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) &&
                    reserva.getHoraEntrada().equals(horaEntrada) &&
                    reserva.getHoraSalida().equals(horaSalida)) {
                System.out.println("Reserva encontrada: Habitación " + habitacion.getNumero());
                return reserva;
            }
        }
        System.out.println("Reserva no encontrada para la habitación " + habitacion.getNumero());
        return null;
    }

    @Override
    public void actualizarReserva(Reserva reservaModificada) {
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            if (reserva.getHabitacion().equals(reservaModificada.getHabitacion()) &&
                    reserva.getHoraEntrada().equals(reservaModificada.getHoraEntrada()) &&
                    reserva.getHoraSalida().equals(reservaModificada.getHoraSalida())) {
                reservas.set(i, reservaModificada);
                System.out.println("Reserva actualizada: Habitación " + reservaModificada.getHabitacion().getNumero());
                return;
            }
        }
        System.out.println("Reserva no encontrada para actualizar.");
    }

    @Override
    public void eliminarReserva(Habitacion habitacion, LocalDateTime horaEntrada, LocalDateTime horaSalida) {
        Optional<Reserva> reservaOpt = reservas.stream()
                .filter(r -> r.getHabitacion().equals(habitacion) &&
                        r.getHoraEntrada().equals(horaEntrada) &&
                        r.getHoraSalida().equals(horaSalida))
                .findFirst();

        reservaOpt.ifPresent(reserva -> {
            reservas.remove(reserva);
            System.out.println("Reserva eliminada: Habitación " + habitacion.getNumero());
        });
    }

    @Override
    public List<Reserva> listarReservas() {
        return reservas;
    }
    @Override
    public void crearServicio(Servicio servicio) {
        servicios.add(servicio);
        System.out.println("Servicio creado: " + servicio.getNombre());
    }

    @Override
    public Servicio obtenerServicio(String nombre) {
        for (Servicio servicio : servicios) {
            if (servicio.getNombre().equals(nombre)) {
                System.out.println("Servicio encontrado: " + nombre);
                return servicio;
            }
        }
        System.out.println("Servicio con nombre " + nombre + " no encontrado.");
        return null;
    }

    @Override
    public void actualizarServicio(Servicio servicioModificado) {
        for (int i = 0; i < servicios.size(); i++) {
            Servicio servicio = servicios.get(i);
            if (servicio.getNombre().equals(servicioModificado.getNombre())) {
                servicios.set(i, servicioModificado);
                System.out.println("Servicio con nombre " + servicioModificado.getNombre() + " modificado.");
                return;
            }
        }
        System.out.println("Servicio con nombre " + servicioModificado.getNombre() + " no encontrado.");
    }

    @Override
    public void eliminarServicio(String nombre) {
        Optional<Servicio> servicioOpt = servicios.stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst();

        servicioOpt.ifPresent(servicio -> {
            servicios.remove(servicio);
            System.out.println("Servicio con nombre " + nombre + " eliminado.");
        });
    }

    @Override
    public List<Servicio> listarServicios() {
        return servicios;
    }

    @Override
    public void crearServicioHabitacion(ServicioHabitacion servicioHabitacion) {
        serviciosHabitacion.add(servicioHabitacion);
        System.out.println("Servicio de habitación creado: " + servicioHabitacion.getNombre());
    }

    @Override
    public ServicioHabitacion obtenerServicioHabitacion(String nombre) {
        for (ServicioHabitacion servicioHabitacion : serviciosHabitacion) {
            if (servicioHabitacion.getNombre().equals(nombre)) {
                System.out.println("Servicio de habitación encontrado: " + nombre);
                return servicioHabitacion;
            }
        }
        System.out.println("Servicio de habitación con nombre " + nombre + " no encontrado.");
        return null;
    }

    @Override
    public void actualizarServicioHabitacion(ServicioHabitacion servicioHabitacionModificado) {
        for (int i = 0; i < serviciosHabitacion.size(); i++) {
            ServicioHabitacion servicioHabitacion = serviciosHabitacion.get(i);
            if (servicioHabitacion.getNombre().equals(servicioHabitacionModificado.getNombre())) {
                serviciosHabitacion.set(i, servicioHabitacionModificado);
                System.out.println("Servicio de habitación con nombre " + servicioHabitacionModificado.getNombre() + " modificado.");
                return;
            }
        }
        System.out.println("Servicio de habitación con nombre " + servicioHabitacionModificado.getNombre() + " no encontrado.");
    }

    @Override
    public void eliminarServicioHabitacion(String nombre) {
        Optional<ServicioHabitacion> servicioHabitacionOpt = serviciosHabitacion.stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst();

        servicioHabitacionOpt.ifPresent(servicioHabitacion -> {
            serviciosHabitacion.remove(servicioHabitacion);
            System.out.println("Servicio de habitación con nombre " + nombre + " eliminado.");
        });
    }

    @Override
    public List<ServicioHabitacion> listarServiciosHabitacion() {
        return serviciosHabitacion;
    }
    public void crearServicioLimpieza(ServicioLimpieza servicioLimpieza) {
        serviciosLimpieza.add(servicioLimpieza);
        System.out.println("Servicio de limpieza creado: " + servicioLimpieza.getNombre());
    }

    @Override
    public ServicioLimpieza obtenerServicioLimpieza(String nombre) {
        for (ServicioLimpieza servicioLimpieza : serviciosLimpieza) {
            if (servicioLimpieza.getNombre().equals(nombre)) {
                System.out.println("Servicio de limpieza encontrado: " + nombre);
                return servicioLimpieza;
            }
        }
        System.out.println("Servicio de limpieza con nombre " + nombre + " no encontrado.");
        return null;
    }

    @Override
    public void actualizarServicioLimpieza(ServicioLimpieza servicioLimpiezaModificado) {
        for (int i = 0; i < serviciosLimpieza.size(); i++) {
            ServicioLimpieza servicioLimpieza = serviciosLimpieza.get(i);
            if (servicioLimpieza.getNombre().equals(servicioLimpiezaModificado.getNombre())) {
                serviciosLimpieza.set(i, servicioLimpiezaModificado);
                System.out.println("Servicio de limpieza con nombre " + servicioLimpiezaModificado.getNombre() + " modificado.");
                return;
            }
        }
        System.out.println("Servicio de limpieza con nombre " + servicioLimpiezaModificado.getNombre() + " no encontrado.");
    }

    @Override
    public void eliminarServicioLimpieza(String nombre) {
        Optional<ServicioLimpieza> servicioLimpiezaOpt = serviciosLimpieza.stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst();

        servicioLimpiezaOpt.ifPresent(servicioLimpieza -> {
            serviciosLimpieza.remove(servicioLimpieza);
            System.out.println("Servicio de limpieza con nombre " + nombre + " eliminado.");
        });
    }

    @Override
    public List<ServicioLimpieza> listarServiciosLimpieza() {
        return serviciosLimpieza;
    }
    @Override
    public void crearServicioRestaurante(ServicioRestaurante servicioRestaurante) {
        serviciosRestaurante.add(servicioRestaurante);
        System.out.println("Servicio de restaurante creado: " + servicioRestaurante.getNombre());
    }

    @Override
    public ServicioRestaurante obtenerServicioRestaurante(String nombre) {
        for (ServicioRestaurante servicioRestaurante : serviciosRestaurante) {
            if (servicioRestaurante.getNombre().equals(nombre)) {
                System.out.println("Servicio de restaurante encontrado: " + nombre);
                return servicioRestaurante;
            }
        }
        System.out.println("Servicio de restaurante con nombre " + nombre + " no encontrado.");
        return null;
    }

    @Override
    public void actualizarServicioRestaurante(ServicioRestaurante servicioRestauranteModificado) {
        for (int i = 0; i < serviciosRestaurante.size(); i++) {
            ServicioRestaurante servicioRestaurante = serviciosRestaurante.get(i);
            if (servicioRestaurante.getNombre().equals(servicioRestauranteModificado.getNombre())) {
                serviciosRestaurante.set(i, servicioRestauranteModificado);
                System.out.println("Servicio de restaurante con nombre " + servicioRestauranteModificado.getNombre() + " modificado.");
                return;
            }
        }
        System.out.println("Servicio de restaurante con nombre " + servicioRestauranteModificado.getNombre() + " no encontrado.");
    }

    @Override
    public void eliminarServicioRestaurante(String nombre) {
        Optional<ServicioRestaurante> servicioRestauranteOpt = serviciosRestaurante.stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst();

        servicioRestauranteOpt.ifPresent(servicioRestaurante -> {
            serviciosRestaurante.remove(servicioRestaurante);
            System.out.println("Servicio de restaurante con nombre " + nombre + " eliminado.");
        });
    }

    @Override
    public List<ServicioRestaurante> listarServiciosRestaurante() {
        return serviciosRestaurante;
    }

    @Override
    public void crearServicioSpa(ServicioSpa servicioSpa) {
        serviciosSpa.add(servicioSpa);
        System.out.println("Servicio de spa creado: " + servicioSpa.getNombre());
    }

    @Override
    public ServicioSpa obtenerServicioSpa(String nombre) {
        for (ServicioSpa servicioSpa : serviciosSpa) {
            if (servicioSpa.getNombre().equals(nombre)) {
                System.out.println("Servicio de spa encontrado: " + nombre);
                return servicioSpa;
            }
        }
        System.out.println("Servicio de spa con nombre " + nombre + " no encontrado.");
        return null;
    }

    @Override
    public void actualizarServicioSpa(ServicioSpa servicioSpaModificado) {
        for (int i = 0; i < serviciosSpa.size(); i++) {
            ServicioSpa servicioSpa = serviciosSpa.get(i);
            if (servicioSpa.getNombre().equals(servicioSpaModificado.getNombre())) {
                serviciosSpa.set(i, servicioSpaModificado);
                System.out.println("Servicio de spa con nombre " + servicioSpaModificado.getNombre() + " modificado.");
                return;
            }
        }
        System.out.println("Servicio de spa con nombre " + servicioSpaModificado.getNombre() + " no encontrado.");
    }

    @Override
    public void eliminarServicioSpa(String nombre) {
        Optional<ServicioSpa> servicioSpaOpt = serviciosSpa.stream()
                .filter(s -> s.getNombre().equals(nombre))
                .findFirst();

        servicioSpaOpt.ifPresent(servicioSpa -> {
            serviciosSpa.remove(servicioSpa);
            System.out.println("Servicio de spa con nombre " + nombre + " eliminado.");
        });
    }

    @Override
    public List<ServicioSpa> listarServiciosSpa() {
        return serviciosSpa;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setServiciosHabitacion(List<ServicioHabitacion> serviciosHabitacion) {
        this.serviciosHabitacion = serviciosHabitacion;
    }

    public List<ServicioHabitacion> getServiciosHabitacion() {
        return serviciosHabitacion;
    }

    public void setServiciosLimpieza(List<ServicioLimpieza> serviciosLimpieza) {
    }

    public void setServiciosSpa(List<ServicioSpa> serviciosSpa) {
    }

    public void setServiciosRestaurante(List<ServicioRestaurante> serviciosRestaurante) {

    }
}

