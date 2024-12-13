package co.guitar.service.detalle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.guitar.dao.detalle.IDetalleDao;
import co.guitar.model.Cliente;
import co.guitar.model.Detallecompra;
import co.guitar.model.Producto;

public class DetalleServcie implements IDetalleService{

    @Autowired
    IDetalleDao dao;

    @Override
    public List<Detallecompra> traerTodos() {
        return dao.getAll();
    }

    @Override
    public List<Detallecompra> traerPorProducto(Producto producto) {
        return dao.getByProduct(producto);
    }

    @Override
    public Detallecompra registrarDetalle(Detallecompra detalle) {
        return dao.registerDetalle(detalle);
    }

    @Override
    public List<Detallecompra> traerPorCliente(Cliente cliente) {
        return dao.getByCliente(cliente);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

}
