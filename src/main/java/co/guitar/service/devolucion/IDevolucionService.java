package co.guitar.service.devolucion;

import java.util.List;

import co.guitar.dto.ReporteDevolucionesDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Detalledevolucion;
import co.guitar.model.Devolucion;
import co.guitar.model.Sucursal;

public interface IDevolucionService {

    List<Devolucion> traerPorCliente(Cliente cliente);

    List<ReporteDevolucionesDTO> traeReporteDevoluciones(int mes, int anio);

    Devolucion traerPorIdDevolucion(int idDevolucion);
    
    List<Devolucion> traerPorScurusal(Sucursal sucursal);

    List<Devolucion> traerPorCompra(Compra compra);
    
    List<Devolucion> traerPorDetalle(Detalledevolucion detalledevolucion);

    void eliminarporId(int idDevolucion);

    Devolucion guardar(Devolucion devolucion);

    Devolucion actualizar(Devolucion devolucion);

}
