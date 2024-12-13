package co.guitar.dao.producto;

import co.guitar.model.Producto;
import java.util.List;

public interface IProductoDao {

    List<Producto> obtenerPorIdProducto(int idProducto);

    List<Producto> obtenerPorNombreProducto(String nombreProducto);

    List<Producto> obtenerPorStock(int stock);

    List<Producto> obtenerPorVecesPedido(int vecesPedido);

    void eliminarPorIdProducto(int idProducto);

    Producto guardar(Producto producto);

    Producto actualizar(Producto producto);
}
