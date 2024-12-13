package co.guitar.service.producto;

import java.util.List;

import co.guitar.model.Producto;

public interface IProductoService {
    List<Producto> traerPorId(int idProducto);

    List<Producto> traerPorNombreProducto(String nombreProducto);

    List<Producto> traerPorStock(int stock);

    List<Producto> obtenerPorVecesPedido(int vecesPedido);

    void eliminarPorId(int idProducto);

    Producto guardar(Producto producto);

}
