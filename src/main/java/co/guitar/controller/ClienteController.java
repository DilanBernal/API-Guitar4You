package co.guitar.controller;

import co.guitar.dto.ClienteRegisterDTO;
import co.guitar.model.Cliente;
import co.guitar.service.cliente.IClienteService;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private IClienteService service;

    // Registrar un cliente
    @PostMapping(path = "registrar")
    public ResponseEntity<Cliente> registrarCliente(@RequestBody ClienteRegisterDTO clienteDTO) {
        Cliente datosCliente = service.registrarCliente(clienteDTO);
        return new ResponseEntity<>(datosCliente, HttpStatus.ACCEPTED);
    }

    // Traer todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> traerTodosLosClientes() {
        List<Cliente> clientes = service.traerTodosLosClientes();
        return new ResponseEntity<>(clientes, HttpStatus.ACCEPTED);
    }

    // Traer un cliente por ID
    @GetMapping(path = "buscarPorId/{id}")
    public ResponseEntity<Optional<Cliente>> traerUnClientePorId(@PathVariable int id) {
        Optional<Cliente> cliente = service.traerUnClientePorId(id);
        return new ResponseEntity<>(cliente, HttpStatus.ACCEPTED);
    }

    // Traer un cliente por email
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<Optional<Cliente>> traerUnClientePorEmail(@PathVariable String email) {
        Optional<Cliente> cliente = service.traerUnClientePorEmail(email);
        return new ResponseEntity<>(cliente, HttpStatus.ACCEPTED);
    }

    // Traer un cliente por ID de compra
    @GetMapping(path ="/compra/{idCompra}")
    public ResponseEntity<Cliente> traerPorCompra(@PathVariable int idCompra) {
        Cliente cliente = service.traerPorCompra(idCompra);
        return ResponseEntity.ok(cliente);
    }

    // Traer un cliente por ubicación
    @PostMapping(path = "/ubicacion")
    public ResponseEntity<Cliente> traerPorUbicacion(@RequestBody Point ubicacion) {
        Cliente cliente = service.traerPorUbicacion(ubicacion);
        return ResponseEntity.ok(cliente);
    }

    // Traer cliente cercano
    @PostMapping(path = "/cercano")
    public ResponseEntity<Cliente> traerClienteCercano(@RequestParam Point puntoReferencia, @RequestParam double distancia) {
        Cliente cliente = service.traerClienteCercano(puntoReferencia, distancia);
        return ResponseEntity.ok(cliente);
    }

    // Eliminar un cliente
    @DeleteMapping(path = "delete/12345/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable int id) {
        service.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
