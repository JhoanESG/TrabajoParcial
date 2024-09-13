package co.uniquindio.edu.Model;

import java.util.List;

public class Cliente {
    private String nombre;
    private String DNI;
    private List<Reserva> reservas;
    private List<Servicio> servicios;

    public Cliente(String nombre, String DNI, List<Servicio> servicios) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", reservas=" + reservas +
                ", servicios=" + servicios +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}

