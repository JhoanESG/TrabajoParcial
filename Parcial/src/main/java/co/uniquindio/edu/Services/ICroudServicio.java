package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.Servicio;

import java.util.List;

public interface ICroudServicio {
    void crearServicio(Servicio servicio);
    Servicio obtenerServicio(String nombre);
    void actualizarServicio(Servicio servicioModificado);
    void eliminarServicio(String nombre);
    List<Servicio> listarServicios();
}
