package co.guitar.service.detalle;

import java.util.List;

import co.guitar.model.Detallecompra;
import co.guitar.model.Producto;

public interface IDetalleService {

    List<Detallecompra> traerTodos();

    List<Detallecompra> traerPorProducto(Producto producto);

    Detallecompra registrarDetalle(Detallecompra detalle);

    void deleteById(int id);

}
