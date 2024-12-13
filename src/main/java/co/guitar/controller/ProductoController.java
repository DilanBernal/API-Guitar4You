package co.guitar.controller;

import co.guitar.model.Producto;
import co.guitar.service.producto.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService service;

    // Registrar un producto
    @PostMapping(path = "registrar")
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto) {
        Producto productoGuardado = service.guardar(producto);
        return new ResponseEntity<>(productoGuardado, HttpStatus.CREATED);
    }

    // Traer productos por ID
    @GetMapping(path = "/{idProducto}")
    public ResponseEntity<List<Producto>> traerPorId(@PathVariable int idProducto) {
        List<Producto> productos = service.traerPorId(idProducto);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Traer productos por nombre
    @GetMapping(path = "/nombre/{nombreProducto}")
    public ResponseEntity<List<Producto>> traerPorNombre(@PathVariable String nombreProducto) {
        List<Producto> productos = service.traerPorNombreProducto(nombreProducto);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Traer productos por stock
    @GetMapping(path = "/stock/{stock}")
    public ResponseEntity<List<Producto>> traerPorStock(@PathVariable int stock) {
        List<Producto> productos = service.traerPorStock(stock);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Traer productos por veces pedido
    @GetMapping(path = "/vecesPedido/{vecesPedido}")
    public ResponseEntity<List<Producto>> traerPorVecesPedido(@PathVariable int vecesPedido) {
        List<Producto> productos = service.obtenerPorVecesPedido(vecesPedido);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    // Eliminar un producto por ID
    @DeleteMapping(path = "delete/{idProducto}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int idProducto) {
        service.eliminarPorId(idProducto);
        return ResponseEntity.noContent().build();
    }
}
