package co.guitar.dao.sucursal;

import java.util.List;

import org.locationtech.jts.awt.PointShapeFactory.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.guitar.model.Sucursal;

public interface ISucursalJpa  extends JpaRepository<Sucursal, Integer>{

    @Query("SELECT c FROM Sucursal c WHERE ST_Distance(c.ubicacionSucursal, :puntoReferencia) < :distancia")
    List<Sucursal> encontrarClientesCercanos(@Param("puntoReferencia") Point puntoReferencia, @Param("distancia") double distancia);

    List<Sucursal> findByIdSucursal(int idSucursal);

    List<Sucursal> findByNombreSucursal(String nombreSucursal);

    void deleteByIdSucursal(int idSucursal);

}
