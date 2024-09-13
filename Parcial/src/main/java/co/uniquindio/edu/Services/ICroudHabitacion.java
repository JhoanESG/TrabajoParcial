package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.Habitacion;

import java.util.List;

public interface ICroudHabitacion {

    void crearHabitacion(Habitacion habitacion);
    Habitacion obtenerHabitacion(int numero);
    void actualizarHabitacion(Habitacion habitacion);
    // Eliminar una habitación por número
    void eliminarHabitacion(int numero);
    // Listar todas las habitaciones
    List<Habitacion> listarHabitaciones();
}
