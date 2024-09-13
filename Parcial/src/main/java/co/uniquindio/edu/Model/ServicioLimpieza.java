package co.uniquindio.edu.Model;

public class ServicioLimpieza extends Servicio{

    public ServicioLimpieza(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public void consumir() {
        System.out.println("Servicio de limpieza consumido.");
    }
}
