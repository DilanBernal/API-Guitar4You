package co.guitar.dao.compra;

import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.EstadoCompra;

import java.util.List;

public interface ICompraDao {

    void registrarCompra(int idCliente, int idProducto, int cantidad);

    List<Compra> obtenerPorCliente(Cliente cliente);

    Compra obtenerPorIdCompra(int idCompra);

    List<Compra> obtenerPorEstadoCompra(EstadoCompra estadoCompra);

    boolean existePorCliente(Cliente cliente);

    void eliminarPorIdCompra(int id);

    Compra guardar(Compra compra);

    Compra actualizar(Compra compra);
}
