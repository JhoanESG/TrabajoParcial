package co.uniquindio.edu.Model.builder;

import co.uniquindio.edu.Model.Servicio;

public abstract class ServicioBuilder<T extends ServicioBuilder<T>> {
    protected String nombre;
    protected double precio;

    public T nombre(String nombre) {
        this.nombre = nombre;
        return self();
    }

    public T precio(double precio) {
        this.precio = precio;
        return self();
    }

    // Metodo abstracto que asegura que las subclases devuelvan su propia instancia
    protected abstract T self();

    // Metodo abstracto build para que las subclases implementen la creación del objeto
    public abstract Servicio build();
}
