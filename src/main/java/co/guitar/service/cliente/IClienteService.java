package co.guitar.service.cliente;

import java.util.List;
import java.util.Optional;
import org.locationtech.jts.geom.Point;

import co.guitar.dto.ClienteRegisterDTO;
import co.guitar.model.Cliente;

public interface IClienteService {

    Cliente registrarCliente(ClienteRegisterDTO clienteDto);

    List<Cliente> traerTodosLosClientes();

    Optional<Cliente> traerUnClientePorId(int id);

    Optional<Cliente> traerUnClientePorEmail(String email);

    Cliente traerPorCompra(int idCompra);

    Cliente traerPorDevolucion(int idDevolucion);

    Cliente traerPorUbicacion(Point ubicacionCliente);

    Cliente traerClienteCercano(Point puntoReferencia, double distancia);

    void eliminarCliente(int id);
}
