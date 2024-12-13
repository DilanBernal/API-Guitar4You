package co.guitar.dao.detalle;

import co.guitar.model.Cliente;
import co.guitar.model.Detallecompra;
import co.guitar.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DetalleDao implements IDetalleDao {

    @Autowired
    private IDetalleJpa jpa;

    @Override
    public List<Detallecompra> getAll() {
        return jpa.findAll();
    }

    @Override
    public List<Detallecompra> getByProduct(Producto producto) {
        // Si 'findByProducto' está definido en jpa, esta llamada sería correcta
        return jpa.findByProducto(producto);
    }

    @Override
    public Detallecompra registerDetalle(Detallecompra detalle) {
        return jpa.save(detalle);
    }

    @Override
    public List<Detallecompra> getByCliente(Cliente cliente) {
        // Necesitarías un método en jpa para obtener los detalles de la compra por cliente
        return jpa.findByCliente(cliente);
    }

    @Override
    public void deleteById(int id) {
        jpa.deleteByIdDetalleCompra(id);
    }
}
