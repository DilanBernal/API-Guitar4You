package co.guitar.service.cliente;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.awt.PointShapeFactory.Point;

import co.guitar.model.Cliente;

public interface IClienteService {

    Cliente registrarCliente(Cliente cliente);

    List<Cliente> traerTodosLosClientes();

    Optional<Cliente> traerUnClientePorId();

    Optional<Cliente> traerUnClientePorEmail(String email);

    Cliente traerPorCompra(int idCompra);

    Cliente traerPorUbicacion(Point ubicacionCliente);

    Cliente traerClienteCercano(Point puntoReferencia, double distancia);

    void eliminarCliente(int id);
}
