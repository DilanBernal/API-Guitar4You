package co.guitar.service.sucursal;

import java.util.List;

import org.locationtech.jts.awt.PointShapeFactory.Point;
import org.springframework.beans.factory.annotation.Autowired;

import co.guitar.dao.sucursal.ISucursalDao;
import co.guitar.model.Sucursal;

public class SucursalService implements ISucursalService {

    @Autowired
    ISucursalDao dao;

    @Override
    public List<Sucursal> traerPorId(int id) {
        return dao.obtenerPorIdSucursal(id);
    }

    @Override
    public List<Sucursal> traerPorNombre(String nombre) {
        return dao.obtenerPorNombreSucursal(nombre);
    }

    @Override
    public void eliminarPorIdSucursal(int id) {
        dao.eliminarPorIdSucursal(id);
    }

    @Override
    public List<Sucursal> encontrarSucursalCerca(Point puntoReferencia, double distancia) {
        return dao.encontrarSucursalesCercanas(puntoReferencia, distancia);
    }

    @Override
    public Sucursal guardar(Sucursal sucursal) {
        return dao.guardar(sucursal);
    }

}
