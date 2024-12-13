package co.guitar.dao.compra;

import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.EstadoCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompraDao implements ICompraDao {

    @Autowired
    private ICompraJpa jpa;

    @Override
    public void registrarCompra(int idCliente, int idProducto, int cantidad) {
        jpa.registrarCompra(idCliente, idProducto, cantidad);
    }

    @Override
    public List<Compra> obtenerPorCliente(Cliente cliente) {
        return jpa.findByCliente(cliente);
    }

    @Override
    public Compra obtenerPorIdCompra(int idCompra) {
        return jpa.getByIdCompra(idCompra);
    }

    @Override
    public List<Compra> obtenerPorEstadoCompra(EstadoCompra estadoCompra) {
        return jpa.findByEstadoCompra(estadoCompra);
    }

    @Override
    public boolean existePorCliente(Cliente cliente) {
        return jpa.existsByCliente(cliente);
    }

    @Override
    public void eliminarPorIdCompra(int id) {
        jpa.deleteByIdCompra(id);
    }

    @Override
    public Compra guardar(Compra compra) {
        return jpa.save(compra);
    }

    @Override
    public Compra actualizar(Compra compra) {
        return jpa.save(compra);
    }
}
