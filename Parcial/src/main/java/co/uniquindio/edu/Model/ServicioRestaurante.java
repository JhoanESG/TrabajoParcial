package co.uniquindio.edu.Model;

public class ServicioRestaurante extends Servicio{

    public ServicioRestaurante(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void consumir() {
        System.out.println("Servicio de restaurante consumido.");
    }
}
