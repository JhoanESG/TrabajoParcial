package co.uniquindio.edu.Model.builder;

import co.uniquindio.edu.Model.Habitacion;
import co.uniquindio.edu.Model.Reserva;
import co.uniquindio.edu.Model.Servicio;
import co.uniquindio.edu.Model.TipoHabitacion;

import java.util.List;

public class HabitacionBuilder {
    private int numero;
    private TipoHabitacion tipo;
    private double precio;
    private List<Servicio> servicios;
    private Reserva reserva;

    public Habitacion build() {
        return new Habitacion(numero, tipo, precio, servicios, reserva);
    }

    public HabitacionBuilder setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public HabitacionBuilder setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
        return this;
    }

    public HabitacionBuilder setPrecio(double precio) {
        this.precio = precio;
        return this;
    }

    public HabitacionBuilder setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
        return this;
    }

    public HabitacionBuilder setReserva(Reserva reserva) {
        this.reserva = reserva;
        return this;
    }


}
