package co.guitar.controller;

import co.guitar.dto.ReporteDevolucionesDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Detalledevolucion;
import co.guitar.model.Devolucion;
import co.guitar.model.Sucursal;
import co.guitar.service.devolucion.IDevolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devolucion")
public class DevolucionController {

    @Autowired
    private IDevolucionService service;

    // Registrar una devolución
    @PostMapping(path = "registrar")
    public ResponseEntity<Devolucion> registrarDevolucion(@RequestBody Devolucion devolucion) {
        Devolucion devolucionGuardada = service.guardar(devolucion);
        return new ResponseEntity<>(devolucionGuardada, HttpStatus.CREATED);
    }

    // Actualizar una devolución
    @PutMapping(path = "actualizar")
    public ResponseEntity<Devolucion> actualizarDevolucion(@RequestBody Devolucion devolucion) {
        Devolucion devolucionActualizada = service.actualizar(devolucion);
        return new ResponseEntity<>(devolucionActualizada, HttpStatus.OK);
    }

    // Traer devoluciones por cliente
    @GetMapping(path = "/cliente/{idCliente}")
    public ResponseEntity<List<Devolucion>> traerPorCliente(@PathVariable int idCliente) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(idCliente);
        List<Devolucion> devoluciones = service.traerPorCliente(cliente);
        return new ResponseEntity<>(devoluciones, HttpStatus.OK);
    }

    // Traer reporte de devoluciones por mes y año
    @GetMapping(path = "/reporte/{mes}/{anio}")
    public ResponseEntity<List<ReporteDevolucionesDTO>> traerReporteDevoluciones(@PathVariable int mes, @PathVariable int anio) {
        List<ReporteDevolucionesDTO> reporte = service.traeReporteDevoluciones(mes, anio);
        return new ResponseEntity<>(reporte, HttpStatus.OK);
    }

    // Traer devoluciones por ID
    @GetMapping(path = "/{idDevolucion}")
    public ResponseEntity<Devolucion> traerPorIdDevolucion(@PathVariable int idDevolucion) {
        Devolucion devoluciones = service.traerPorIdDevolucion(idDevolucion);
        return new ResponseEntity<>(devoluciones, HttpStatus.OK);
    }

    // Traer devoluciones por sucursal
    @GetMapping(path = "/sucursal/{idSucursal}")
    public ResponseEntity<List<Devolucion>> traerPorSucursal(@PathVariable int idSucursal) {
        Sucursal sucursal = new Sucursal();
        sucursal.setIdSucursal(idSucursal);
        List<Devolucion> devoluciones = service.traerPorScurusal(sucursal);
        return new ResponseEntity<>(devoluciones, HttpStatus.OK);
    }

    // Traer devoluciones por compra
    @GetMapping(path = "/compra/{idCompra}")
    public ResponseEntity<List<Devolucion>> traerPorCompra(@PathVariable int idCompra) {
        Compra compra = new Compra();
        compra.setIdCompra(idCompra);
        List<Devolucion> devoluciones = service.traerPorCompra(compra);
        return new ResponseEntity<>(devoluciones, HttpStatus.OK);
    }

    // Traer devoluciones por detalle de devolución
    @GetMapping(path = "/detalle/{idDetalleDevolucion}")
    public ResponseEntity<List<Devolucion>> traerPorDetalle(@PathVariable int idDetalleDevolucion) {
        Detalledevolucion detalleDevolucion = new Detalledevolucion();
        detalleDevolucion.setIdDetalleDevolucion(idDetalleDevolucion);
        List<Devolucion> devoluciones = service.traerPorDetalle(detalleDevolucion);
        return new ResponseEntity<>(devoluciones, HttpStatus.OK);
    }

    // Eliminar devolución por ID
    @DeleteMapping(path = "delete/{idDevolucion}")
    public ResponseEntity<Void> eliminarDevolucion(@PathVariable int idDevolucion) {
        service.eliminarporId(idDevolucion);
        return ResponseEntity.noContent().build();
    }
}
