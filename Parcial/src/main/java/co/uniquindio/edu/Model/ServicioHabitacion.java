package co.uniquindio.edu.Model;

public class ServicioHabitacion extends Servicio{


    public ServicioHabitacion(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void consumir() {
        System.out.println("Servicio de habitacion consumido.");
    }
}

