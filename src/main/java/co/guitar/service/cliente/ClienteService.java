package co.guitar.service.cliente;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.guitar.dao.cliente.IClienteDao;
import co.guitar.model.Cliente;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteDao dao;

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        String correo = cliente.getCorreoCliente();
        if(correo.length() >=5){
            dao.agregarCliente(cliente);
        }
        return null;
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
        return dao.obtenerPorCompra(idCompra);
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
}
