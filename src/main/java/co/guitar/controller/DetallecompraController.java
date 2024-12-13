package co.guitar.controller;

import co.guitar.model.Cliente;
import co.guitar.model.Detallecompra;
import co.guitar.model.Producto;
import co.guitar.service.detalle.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle")
public class DetallecompraController {

    @Autowired
    private IDetalleService service;

    // Registrar un detalle de compra
    @PostMapping(path = "registrar")
    public ResponseEntity<Detallecompra> registrarDetalle(@RequestBody Detallecompra detalle) {
        Detallecompra detalleRegistrado = service.registrarDetalle(detalle);
        return new ResponseEntity<>(detalleRegistrado, HttpStatus.CREATED);
    }

    // Traer todos los detalles de compra
    @GetMapping
    public ResponseEntity<List<Detallecompra>> traerTodosLosDetalles() {
        List<Detallecompra> detalles = service.traerTodos();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    // Traer detalles de compra por producto
    @GetMapping(path = "/producto/{idProducto}")
    public ResponseEntity<List<Detallecompra>> traerPorProducto(@PathVariable int idProducto) {
        Producto producto = new Producto();  // Aquí se podría crear un producto con el ID si es necesario
        producto.setIdProducto(idProducto);
        List<Detallecompra> detalles = service.traerPorProducto(producto);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    // Traer detalles de compra por cliente
    @GetMapping(path = "/cliente/{idCliente}")
    public ResponseEntity<List<Detallecompra>> traerPorCliente(@PathVariable int idCliente) {
        Cliente cliente = new Cliente();  // Aquí se podría crear un cliente con el ID si es necesario
        cliente.setIdCliente(idCliente);
        List<Detallecompra> detalles = service.traerPorCliente(cliente);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    // Eliminar detalle de compra por ID
    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
