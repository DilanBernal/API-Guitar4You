package co.guitar.dao.cliente;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Point;

import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Devolucion;

public interface IClienteDao {

    Cliente agregarCliente(Cliente cliente);

    Cliente obtenerPorNombreCliente(String nombre);

    Optional<Cliente> obtenerPorCorreoCliente(String correoCliente);

    List<Cliente> obtenerTodos();

    Optional<Cliente> obtenerPorIdCliente(int idCliente);

    Cliente obtenerPorDevolucion(Devolucion devolucion);

    Cliente obtenerPorCompra(Compra compra);

    Cliente obtenerPorUbicacion(Point ubicacionCliente);

    Cliente obtenerClientesCercanos(Point puntoReferencia, double distancia);

    void eliminarPorIdCliente(int idCliente);
}
