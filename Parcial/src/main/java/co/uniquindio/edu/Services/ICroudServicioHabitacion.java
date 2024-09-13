package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.ServicioHabitacion;

import java.util.List;

public interface ICroudServicioHabitacion {
    void crearServicioHabitacion(ServicioHabitacion servicioHabitacion);
    ServicioHabitacion obtenerServicioHabitacion(String nombre);
    void actualizarServicioHabitacion(ServicioHabitacion servicioHabitacionModificado);
    // Eliminar un servicio de habitación por nombre
    void eliminarServicioHabitacion(String nombre);
    List<ServicioHabitacion> listarServiciosHabitacion();
}
