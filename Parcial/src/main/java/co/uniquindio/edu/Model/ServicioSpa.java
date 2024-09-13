package co.uniquindio.edu.Model;

public class ServicioSpa extends Servicio{
    public ServicioSpa(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void consumir() {
        System.out.println("Servicio de spa consumido.");
    }
}
