package co.guitar.dao.devolucion;

import co.guitar.dto.ReporteDevolucionesDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Detalledevolucion;
import co.guitar.model.Devolucion;
import co.guitar.model.Sucursal;

import java.util.List;

public interface IDevolucionDao {

    List<Devolucion> obtenerPorCliente(Cliente cliente);

    List<ReporteDevolucionesDTO> generarReporteDevoluciones(int mes, int anio);

    List<Devolucion> obtenerPorIdDevolucion(int idDevolucion);

    List<Devolucion> obtenerPorSucursal(Sucursal sucursal);

    List<Devolucion> obtenerPorCompra(Compra compra);

    List<Devolucion> obtenerPorDetalleDevolucion(Detalledevolucion detalleDevolucion);

    void eliminarPorIdDevolucion(int idDevolucion);

    Devolucion guardar(Devolucion devolucion);

    Devolucion actualizar(Devolucion devolucion);
}
