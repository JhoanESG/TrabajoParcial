package co.uniquindio.edu.Model.builder;

import co.uniquindio.edu.Model.Habitacion;
import co.uniquindio.edu.Model.Reserva;

import java.time.LocalDateTime;

public class ReservaBuilder {

    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Habitacion habitacion;

    public Reserva build() {
        return new Reserva(horaEntrada, horaSalida, habitacion);
    }

    public ReservaBuilder setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
        return this;
    }

    public ReservaBuilder setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
        return this;
    }

    public ReservaBuilder setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
        return this;
    }


}
