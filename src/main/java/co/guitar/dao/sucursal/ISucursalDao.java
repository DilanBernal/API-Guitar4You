package co.guitar.dao.sucursal;

import co.guitar.model.Sucursal;
import org.locationtech.jts.awt.PointShapeFactory.Point;

import java.util.List;

public interface ISucursalDao {

    List<Sucursal> obtenerPorIdSucursal(int idSucursal);

    List<Sucursal> obtenerPorNombreSucursal(String nombreSucursal);

    void eliminarPorIdSucursal(int idSucursal);

    List<Sucursal> encontrarSucursalesCercanas(Point puntoReferencia, double distancia);

    Sucursal guardar(Sucursal sucursal);

    Sucursal actualizar(Sucursal sucursal);
}
