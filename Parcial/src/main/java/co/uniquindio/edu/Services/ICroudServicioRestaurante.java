package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.ServicioRestaurante;

import java.util.List;

public interface ICroudServicioRestaurante {
    void crearServicioRestaurante(ServicioRestaurante servicioRestaurante);
    ServicioRestaurante obtenerServicioRestaurante(String nombre);
    void actualizarServicioRestaurante(ServicioRestaurante servicioRestauranteModificado);
    void eliminarServicioRestaurante(String nombre);
    List<ServicioRestaurante> listarServiciosRestaurante();
}
