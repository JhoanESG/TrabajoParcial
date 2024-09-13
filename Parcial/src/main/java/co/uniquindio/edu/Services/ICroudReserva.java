package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.Habitacion;
import co.uniquindio.edu.Model.Reserva;

import java.time.LocalDateTime;
import java.util.List;

public interface ICroudReserva {
    // Crear una nueva reserva
    void crearReserva(Reserva reserva);
    Reserva obtenerReserva(Habitacion habitacion, LocalDateTime horaEntrada, LocalDateTime horaSalida);
    void actualizarReserva(Reserva reservaModificada);
    void eliminarReserva(Habitacion habitacion, LocalDateTime horaEntrada, LocalDateTime horaSalida);

    // Listar todas las reservas
    List<Reserva> listarReservas();
}
