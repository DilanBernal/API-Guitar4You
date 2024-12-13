package co.guitar.dao.sucursal;

import co.guitar.model.Sucursal;
import org.locationtech.jts.awt.PointShapeFactory.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SucursalDao implements ISucursalDao {

    @Autowired
    private ISucursalJpa jpa;

    @Override
    public List<Sucursal> obtenerPorIdSucursal(int idSucursal) {
        return jpa.findByIdSucursal(idSucursal);
    }

    @Override
    public List<Sucursal> obtenerPorNombreSucursal(String nombreSucursal) {
        return jpa.findByNombreSucursal(nombreSucursal);
    }

    @Override
    public void eliminarPorIdSucursal(int idSucursal) {
        jpa.deleteByIdSucursal(idSucursal);
    }

    @Override
    public List<Sucursal> encontrarSucursalesCercanas(Point puntoReferencia, double distancia) {
        return jpa.encontrarClientesCercanos(puntoReferencia, distancia);
    }

    @Override
    public Sucursal guardar(Sucursal sucursal) {
        return jpa.save(sucursal);
    }

    @Override
    public Sucursal actualizar(Sucursal sucursal) {
        return jpa.save(sucursal);
    }
}
