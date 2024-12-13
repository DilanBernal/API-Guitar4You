package co.guitar.dao.compra;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.EstadoCompra;

import java.util.List;

public interface ICompraJpa extends JpaRepository<Compra, Integer> {

    @Procedure(name = "registrarCompra")
    void registrarCompra(int idCliente, int idProducto, int cantidad);

    List<Compra> findByCliente(Cliente cliente);

    Compra getByIdCompra(int idCompra);

    List<Compra> findByEstadoCompra(EstadoCompra estadoCompra);

    boolean existsByCliente(Cliente cliente);

    void deleteByIdCompra(int id);

}
