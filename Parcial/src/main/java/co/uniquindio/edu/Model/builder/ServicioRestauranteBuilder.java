package co.uniquindio.edu.Model.builder;

import co.uniquindio.edu.Model.ServicioHabitacion;
import co.uniquindio.edu.Model.ServicioRestaurante;

public class ServicioRestauranteBuilder extends ServicioBuilder<ServicioRestauranteBuilder> {

    @Override
    public ServicioHabitacion build() {
        return new ServicioHabitacion(nombre, precio);  // Crea y retorna la instancia de ServicioHabitacion
    }

    // Metodo self que devuelve el builder específico
    @Override
    protected ServicioRestauranteBuilder self() {
        return this;
    }
}
