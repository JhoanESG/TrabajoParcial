package co.uniquindio.edu.Model.builder;

import co.uniquindio.edu.Model.ServicioHabitacion;

public class ServicioSpaBuilder extends ServicioBuilder<ServicioSpaBuilder> {

    @Override
    public ServicioHabitacion build() {
        return new ServicioHabitacion(nombre, precio);  // Crea y retorna la instancia de ServicioHabitacion
    }

    // Metodo self que devuelve el builder específico
    @Override
    protected ServicioSpaBuilder self() {
        return this;
    }
}
