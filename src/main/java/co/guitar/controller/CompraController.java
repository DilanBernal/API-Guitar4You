package co.guitar.controller;

import co.guitar.dto.CompraRequestDTO;
import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.EstadoCompra;
import co.guitar.service.compra.ICompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compras")
public class CompraController {

    @Autowired
    private ICompraService service;

    // Registrar una compra
    @PostMapping()
    public ResponseEntity<Void> registrarCompra(@RequestBody CompraRequestDTO compraReques) {

        service.registrarCompra(compraReques.getIdCliente(), compraReques.getIdProducto(), compraReques.getCantidad());

        return ResponseEntity.ok().build();
    }

    // Obtener compras por cliente
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<Compra>> traerPorCliente(@PathVariable int idCliente) {
        Cliente cliente = new Cliente(); // Crear cliente basado en el idCliente
        cliente.setIdCliente(idCliente); // Asume que hay un setter para idCliente
        List<Compra> compras = service.traerPorCliente(cliente);
        return ResponseEntity.ok(compras);
    }

    // Obtener compra por ID
    @GetMapping("/{idCompra}")
    public ResponseEntity<Compra> traerPorIdCompra(@PathVariable int idCompra) {
        Compra compra = service.traerPorIdCompra(idCompra);
        return ResponseEntity.ok(compra);
    }

    // Obtener compras por estado
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Compra>> traerPorEstadoCompra(@PathVariable EstadoCompra estado) {
        List<Compra> compras = service.traerPorEstadoCompra(estado);
        return ResponseEntity.ok(compras);
    }

    // Eliminar una compra por ID
    @DeleteMapping("/{idCompra}")
    public ResponseEntity<Void> eliminarPorIdCompra(@PathVariable int idCompra) {
        service.eliminarPorIdCompra(idCompra);
        return ResponseEntity.noContent().build();
    }
}
