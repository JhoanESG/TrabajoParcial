package co.uniquindio.edu.Model;

import java.util.List;

public class Habitacion {
    private int numero;
    private TipoHabitacion tipo;
    private double precio;
    private List<Servicio> servicios;  // Lista de servicios asociados
    private Reserva reserva;  // Asociación a una reserva

    public Habitacion(int numero, TipoHabitacion tipo, double precio, List<Servicio> servicios, Reserva reserva) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.servicios = servicios;
        this.reserva = reserva;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
