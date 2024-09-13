package co.uniquindio.edu.Services;

import co.uniquindio.edu.Model.Cliente;

public interface ICrudCliente {
    void crearCliente(Cliente cliente);
    void eliminarCliente(String dni);
    void modificarCliente(Cliente cliente);
    Cliente getCliente(String dni);
}
