package co.guitar.service.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.guitar.dao.producto.IProductoDao;
import co.guitar.model.Producto;

public class ProductoService implements IProductoService{


    @Autowired
    IProductoDao dao;

    @Override
    public List<Producto> traerPorId(int idProducto) {
        return dao.obtenerPorIdProducto(idProducto);
    }

    @Override
    public List<Producto> traerPorNombreProducto(String nombreProducto) {
        return dao.obtenerPorNombreProducto(nombreProducto);
    }

    @Override
    public List<Producto> traerPorStock(int stock) {
        return dao.obtenerPorStock(stock);
    }

    @Override
    public List<Producto> obtenerPorVecesPedido(int vecesPedido) {
        return dao.obtenerPorVecesPedido(vecesPedido);
    }

    @Override
    public void eliminarPorId(int idProducto) {
        dao.eliminarPorIdProducto(idProducto);
    }

    @Override
    public Producto guardar(Producto producto) {
        return dao.guardar(producto);
    }



}
