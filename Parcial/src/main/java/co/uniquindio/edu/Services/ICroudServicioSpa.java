package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.ServicioSpa;

import java.util.List;

public interface ICroudServicioSpa {
    void crearServicioSpa(ServicioSpa servicioSpa);
    ServicioSpa obtenerServicioSpa(String nombre);
    void actualizarServicioSpa(ServicioSpa servicioSpaModificado);
    void eliminarServicioSpa(String nombre);

    List<ServicioSpa> listarServiciosSpa();
}
