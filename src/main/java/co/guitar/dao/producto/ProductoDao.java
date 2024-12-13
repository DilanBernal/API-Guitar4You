package co.guitar.dao.producto;

import co.guitar.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDao implements IProductoDao {

    @Autowired
    private IProductoJpa jpa;

    @Override
    public List<Producto> obtenerPorIdProducto(int idProducto) {
        return jpa.findByIdProducto(idProducto);
    }

    @Override
    public List<Producto> obtenerPorNombreProducto(String nombreProducto) {
        return jpa.findByNombreProducto(nombreProducto);
    }

    @Override
    public List<Producto> obtenerPorStock(int stock) {
        return jpa.findByStock(stock);
    }

    @Override
    public List<Producto> obtenerPorVecesPedido(int vecesPedido) {
        return jpa.findByVecesPedido(vecesPedido);
    }

    @Override
    public void eliminarPorIdProducto(int idProducto) {
        jpa.deleteByIdProducto(idProducto);
    }

    @Override
    public Producto guardar(Producto producto) {
        return jpa.save(producto);
    }

    @Override
    public Producto actualizar(Producto producto) {
        return jpa.save(producto);
    }
}
