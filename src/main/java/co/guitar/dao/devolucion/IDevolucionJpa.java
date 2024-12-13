package co.guitar.dao.devolucion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import co.guitar.dto.ReporteDevolucionesDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Detalledevolucion;
import co.guitar.model.Devolucion;
import co.guitar.model.Sucursal;

import java.util.List;

public interface IDevolucionJpa extends JpaRepository<Devolucion, Integer> {

    List<Devolucion> findByCliente(Cliente cliente);

    @Procedure(name = "generarReporteDevoluciones")
    List<ReporteDevolucionesDTO> generarReporteDevoluciones(@Param("mes") int mes, @Param("anio") int anio);

    List<Devolucion> findByIdDevolucion(int idDevolucion);

    List<Devolucion> findBySucursal(Sucursal sucursal);

    List<Devolucion> findByCompra(Compra compra);

    List<Devolucion> findByDetalledevolucion(Detalledevolucion detalledevolucion);

    void deleteById(int id);
}
