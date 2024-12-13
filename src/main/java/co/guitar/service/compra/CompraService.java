package co.guitar.service.compra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.guitar.dao.compra.ICompraDao;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.EstadoCompra;

@Service
public class CompraService implements ICompraService {

    @Autowired
    ICompraDao dao;

    @Override
    public void registrarCompra(int idCliente, int idProducto, int cantidad) {
        dao.registrarCompra(idCliente, idProducto, cantidad);
    }

    @Override
    public List<Compra> traerPorCliente(Cliente cliente) {
        return dao.obtenerPorCliente(cliente);
    }

    @Override
    public Compra traerPorIdCompra(int idCompra) {
        return dao.obtenerPorIdCompra(idCompra);
    }

    @Override
    public List<Compra> traerPorEstadoCompra(EstadoCompra estadoCompra) {
        return dao.obtenerPorEstadoCompra(estadoCompra);
    }

    @Override
    public void eliminarPorIdCompra(int id) {
        dao.eliminarPorIdCompra(id);
    }

}
