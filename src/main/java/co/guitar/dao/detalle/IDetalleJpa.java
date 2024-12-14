package co.guitar.dao.detalle;

import org.springframework.data.jpa.repository.JpaRepository;

import co.guitar.model.Detallecompra;
import java.util.List;

import co.guitar.model.Compra;
import co.guitar.model.Detalledevolucion;
import co.guitar.model.Producto;

public interface IDetalleJpa extends JpaRepository<Detallecompra, Integer> {

    List<Detallecompra> findByIdDetalleCompra(int idDetalleCompra);

    List<Detallecompra> findByCompras(Compra compras);

    List<Detallecompra> findByProducto(Producto producto);

    List<Detallecompra> findByDetalledevolucions(Detalledevolucion detalledevolucions);


    void deleteByIdDetalleCompra(int id);
}
