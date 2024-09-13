package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.ServicioLimpieza;
import java.util.List;

public interface ICroudServicioLimpieza {

    void crearServicioLimpieza(ServicioLimpieza servicioLimpieza);
    ServicioLimpieza obtenerServicioLimpieza(String nombre);
    void actualizarServicioLimpieza(ServicioLimpieza servicioLimpiezaModificado);
    void eliminarServicioLimpieza(String nombre);
    List<ServicioLimpieza> listarServiciosLimpieza();
}
