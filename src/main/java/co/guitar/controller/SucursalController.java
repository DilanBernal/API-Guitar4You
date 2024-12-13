package co.guitar.controller;

import co.guitar.model.Sucursal;
import co.guitar.service.sucursal.ISucursalService;
import org.locationtech.jts.awt.PointShapeFactory.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucursalController {

    @Autowired
    private ISucursalService service;

    // Registrar una sucursal
    @PostMapping(path = "registrar")
    public ResponseEntity<Sucursal> registrarSucursal(@RequestBody Sucursal sucursal) {
        Sucursal sucursalGuardada = service.guardar(sucursal);
        return new ResponseEntity<>(sucursalGuardada, HttpStatus.CREATED);
    }

    // Traer sucursales por ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Sucursal>> traerPorId(@PathVariable int id) {
        List<Sucursal> sucursales = service.traerPorId(id);
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }

    // Traer sucursales por nombre
    @GetMapping(path = "/nombre/{nombre}")
    public ResponseEntity<List<Sucursal>> traerPorNombre(@PathVariable String nombre) {
        List<Sucursal> sucursales = service.traerPorNombre(nombre);
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }

    // Eliminar sucursal por ID
    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<Void> eliminarSucursal(@PathVariable int id) {
        service.eliminarPorIdSucursal(id);
        return ResponseEntity.noContent().build();
    }

    // Encontrar sucursal cercana
    @PostMapping(path = "/cerca")
    public ResponseEntity<List<Sucursal>> encontrarSucursalCerca(@RequestBody Point puntoReferencia, @RequestParam double distancia) {
        List<Sucursal> sucursales = service.encontrarSucursalCerca(puntoReferencia, distancia);
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }
}
