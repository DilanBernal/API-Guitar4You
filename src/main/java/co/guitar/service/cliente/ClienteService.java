package co.guitar.service.cliente;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.guitar.dao.cliente.IClienteDao;
import co.guitar.dao.compra.ICompraDao;
import co.guitar.dao.devolucion.IDevolucionDao;
import co.guitar.dto.ClienteRegisterDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Devolucion;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteDao dao;

    @Autowired
    private ICompraDao daoCompra;
    @Autowired
    private IDevolucionDao daoDevolucion;

    @Override
    public Cliente registrarCliente(ClienteRegisterDTO clienteDTO) {

        Coordinate coordinate = new Coordinate(clienteDTO.getLongitude(), clienteDTO.getLatitude());

        Point ubicacionCliente = new GeometryFactory().createPoint(coordinate);

        Cliente cliente = new Cliente();

        cliente.setNombreCliente(clienteDTO.getNombreCliente());
        cliente.setApellidoCliente(clienteDTO.getApellidoCliente());
        cliente.setContraseCliente(clienteDTO.getContraseCliente());
        cliente.setCorreoCliente(clienteDTO.getCorreoCliente());
        cliente.setUbicacionCliente(ubicacionCliente);

        return dao.agregarCliente(cliente);
    }

    @Override
    public List<Cliente> traerTodosLosClientes() {
        return dao.obtenerTodos();
    }

    @Override
    public Optional<Cliente> traerUnClientePorId(int id) {
        return dao.obtenerPorIdCliente(id);
    }

    @Override
    public Optional<Cliente> traerUnClientePorEmail(String email) {
        return dao.obtenerPorCorreoCliente(email);
    }

    @Override
    public Cliente traerPorCompra(int idCompra) {
        Compra data = daoCompra.obtenerPorIdCompra(idCompra);

        return dao.obtenerPorCompra(data);
    }

    @Override
    public Cliente traerPorUbicacion(Point ubicacionCliente) {
        return dao.obtenerPorUbicacion(ubicacionCliente);
    }

    @Override
    public Cliente traerClienteCercano(Point puntoReferencia, double distancia) {
        return dao.obtenerClientesCercanos(puntoReferencia, distancia);
    }

    @Override
    public void eliminarCliente(int id) {
        dao.eliminarPorIdCliente(id);
    }

    @Override
    public Cliente traerPorDevolucion(int idDevolucion) {
        Devolucion data = daoDevolucion.obtenerPorIdDevolucion(idDevolucion);

        return dao.obtenerPorDevolucion(data);
    }
}
