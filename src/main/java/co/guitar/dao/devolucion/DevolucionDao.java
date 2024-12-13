package co.guitar.dao.devolucion;

import co.guitar.dto.ReporteDevolucionesDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Detalledevolucion;
import co.guitar.model.Devolucion;
import co.guitar.model.Sucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DevolucionDao implements IDevolucionDao {

    @Autowired
    private IDevolucionJpa jpa;

    @Override
    public List<Devolucion> obtenerPorCliente(Cliente cliente) {
        return jpa.findByCliente(cliente);
    }

    @Override
    public List<ReporteDevolucionesDTO> generarReporteDevoluciones(int mes, int anio) {
        return jpa.generarReporteDevoluciones(mes, anio);
    }

    @Override
    public List<Devolucion> obtenerPorIdDevolucion(int idDevolucion) {
        return jpa.findByIdDevolucion(idDevolucion);
    }

    @Override
    public List<Devolucion> obtenerPorSucursal(Sucursal sucursal) {
        return jpa.findBySucursal(sucursal);
    }

    @Override
    public List<Devolucion> obtenerPorCompra(Compra compra) {
        return jpa.findByCompra(compra);
    }

    @Override
    public List<Devolucion> obtenerPorDetalleDevolucion(Detalledevolucion detalleDevolucion) {
        return jpa.findByDetalledevolucion(detalleDevolucion);
    }

    @Override
    public void eliminarPorIdDevolucion(int idDevolucion) {
        jpa.deleteById(idDevolucion);
    }

    @Override
    public Devolucion guardar(Devolucion devolucion) {
        return jpa.save(devolucion);
    }

    @Override
    public Devolucion actualizar(Devolucion devolucion) {
        return jpa.save(devolucion);
    }
}
