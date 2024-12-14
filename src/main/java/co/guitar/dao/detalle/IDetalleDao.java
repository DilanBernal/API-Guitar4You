package co.guitar.dao.detalle;

import java.util.List;

import co.guitar.model.Detallecompra;
import co.guitar.model.Producto;

public interface IDetalleDao {
    List<Detallecompra> getAll();

    List<Detallecompra> getByProduct(Producto prdocut);

    Detallecompra registerDetalle(Detallecompra detalle);

    void deleteById(int id);

}
