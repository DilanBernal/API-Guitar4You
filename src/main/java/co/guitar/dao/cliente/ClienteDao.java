package co.guitar.dao.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Devolucion;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Point;

@Repository
public class ClienteDao implements IClienteDao {

    @Autowired
    private IClienteJpa jpa;


    @Override
    public Cliente obtenerPorNombreCliente(String nombreCliente) {
        return jpa.findByNombreCliente(nombreCliente);
    }

    @Override
    public Optional<Cliente> obtenerPorCorreoCliente(String correoCliente) {
        return jpa.findByCorreoCliente(correoCliente);
    }

    @Override
    public Optional<Cliente> obtenerPorIdCliente(int idCliente) {
        return Optional.ofNullable(jpa.findByIdCliente(idCliente));
    }

    @Override
    public Cliente obtenerPorDevolucion(Devolucion devolucion) {
        return jpa.findByDevolucion(devolucion);
    }

    @Override
    public Cliente obtenerPorCompra(Compra compra) {
        return jpa.findByCompras(compra);
    }

    @Override
    public Cliente obtenerPorUbicacion(Point ubicacionCliente) {
        return jpa.findByUbicacionCliente(ubicacionCliente);
    }

    @Override
    public Cliente obtenerClientesCercanos(Point puntoReferencia, double distancia) {
        return jpa.encontrarClientesCercanos(puntoReferencia, distancia);
    }

    @Override
    public void eliminarPorIdCliente(int idCliente) {
        jpa.deleteByIdCliente(idCliente);
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return jpa.findAll();
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return jpa.save(cliente);
    }

}
