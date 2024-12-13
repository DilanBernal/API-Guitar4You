package co.guitar.dao.cliente;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Point;

import co.guitar.model.Cliente;

public interface IClienteDao {

    Cliente obtenerPorNombreCliente(String nombre);

    Optional<Cliente> obtenerPorCorreoCliente(String correoCliente);

    List<Cliente> obtenerTodos();

    Optional<Cliente> obtenerPorIdCliente(int idCliente);

    List<Cliente> obtenerPorDevolucion(int idDevolucion);

    Cliente obtenerPorCompra(int idCompra);

    Cliente obtenerPorUbicacion(Point ubicacionCliente);

    Cliente obtenerClientesCercanos(Point puntoReferencia, double distancia);

    void eliminarPorIdCliente(int idCliente);
}
