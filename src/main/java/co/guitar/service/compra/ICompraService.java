package co.guitar.service.compra;

import java.util.List;

import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.EstadoCompra;

public interface ICompraService {

    void registrarCompra(int idCliente, int idProducto, int cantidad);

    List<Compra> traerPorCliente(Cliente cliente);

    Compra traerPorIdCompra(int idCompra);

    List<Compra> traerPorEstadoCompra(EstadoCompra estadoCompra);

    void eliminarPorIdCompra(int id);

}
