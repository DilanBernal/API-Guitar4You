package co.guitar.dao.cliente;

import java.util.Optional;

import org.locationtech.jts.geom.Point;

import co.guitar.model.Cliente;

public interface IClienteDao {

    Cliente obtenerPorNombreCliente(String nombreCliente);

    Cliente obtenerPorCorreoCliente(String correoCliente);

    Optional<Cliente> obtenerPorIdCliente(int idCliente);

    Cliente obtenerPorDevolucion(int idDevolucion);

    Cliente obtenerPorCompra(int idCompra);

    Cliente obtenerPorUbicacion(Point ubicacionCliente);

    Cliente obtenerClientesCercanos(Point puntoReferencia, double distancia);

    void eliminarPorIdCliente(int idCliente);
}
