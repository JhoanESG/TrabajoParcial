package co.uniquindio.edu.Model;

import java.time.LocalDateTime;

public class Reserva {
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private Habitacion habitacion;

    public Reserva(LocalDateTime horaEntrada, LocalDateTime horaSalida, Habitacion habitacion) {
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.habitacion = habitacion;
    }


    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }
}
