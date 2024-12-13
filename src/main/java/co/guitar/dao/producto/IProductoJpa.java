package co.guitar.dao.producto;

import org.springframework.data.jpa.repository.JpaRepository;

import co.guitar.model.Producto;
import java.util.List;

public interface IProductoJpa extends JpaRepository<Producto, Integer> {

    List<Producto> findByIdProducto(int idProducto);

    List<Producto> findByNombreProducto(String nombreProducto);

    List<Producto> findByStock(int stock);

    List<Producto> findByVecesPedido(int vecesPedido);

    void deleteByIdProducto(int idProducto);
}
