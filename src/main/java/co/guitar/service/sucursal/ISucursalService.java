package co.guitar.service.sucursal;

import java.util.List;

import org.locationtech.jts.awt.PointShapeFactory.Point;

import co.guitar.model.Sucursal;

public interface ISucursalService {

    List<Sucursal> traerPorId(int id);

    List<Sucursal> traerPorNombre(String nombre);

    void eliminarPorIdSucursal(int id);

    List<Sucursal> encontrarSucursalCerca(Point puntoReferencia, double distancia);
    
    Sucursal guardar(Sucursal sucursal);
}
