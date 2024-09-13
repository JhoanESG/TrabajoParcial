package co.uniquindio.edu.Model.builder;

import co.uniquindio.edu.Model.Cliente;
import co.uniquindio.edu.Model.Reserva;
import co.uniquindio.edu.Model.Servicio;

import java.util.List;

public class ClienteBuilder {
    private String nombre;
    private String DNI;
    private List<Reserva> reservas;
    private List<Servicio> servicios;


    public Cliente build() {
        return new Cliente(nombre, DNI, servicios);
    }

    public ClienteBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ClienteBuilder setDNI(String DNI) {
        this.DNI = DNI;
        return this;
    }

    public ClienteBuilder setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
        return this;
    }

    public ClienteBuilder setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
        return this;
    }
}
