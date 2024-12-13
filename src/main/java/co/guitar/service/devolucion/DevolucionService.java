package co.guitar.service.devolucion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.guitar.dao.devolucion.IDevolucionDao;
import co.guitar.dto.ReporteDevolucionesDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Detalledevolucion;
import co.guitar.model.Devolucion;
import co.guitar.model.Sucursal;

public class DevolucionService implements IDevolucionService {

    @Autowired
    IDevolucionDao dao;

    @Override
    public List<Devolucion> traerPorCliente(Cliente cliente) {
        return dao.obtenerPorCliente(cliente);
    }

    @Override
    public List<ReporteDevolucionesDTO> traeReporteDevoluciones(int mes, int anio) {
        return dao.generarReporteDevoluciones(mes, anio);
    }

    @Override
    public List<Devolucion> traerPorIdDevolucion(int idDevolucion) {
        return dao.obtenerPorIdDevolucion(idDevolucion);
    }

    @Override
    public List<Devolucion> traerPorScurusal(Sucursal sucursal) {
        return dao.obtenerPorSucursal(sucursal);
    }

    @Override
    public List<Devolucion> traerPorCompra(Compra compra) {
        return dao.obtenerPorCompra(compra);
    }

    @Override
    public List<Devolucion> traerPorDetalle(Detalledevolucion detalledevolucion) {
        return dao.obtenerPorDetalleDevolucion(detalledevolucion);
    }

    @Override
    public void eliminarporId(int idDevolucion) {
        dao.eliminarPorIdDevolucion(idDevolucion);
    }

    @Override
    public Devolucion guardar(Devolucion devolucion) {
        return dao.guardar(devolucion);
    }

    @Override
    public Devolucion actualizar(Devolucion devolucion) {
        return dao.actualizar(devolucion);
    }

}
