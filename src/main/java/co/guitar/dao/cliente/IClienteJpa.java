package co.guitar.dao.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.guitar.model.Cliente;

import java.util.List;
import java.util.Optional;

import org.locationtech.jts.geom.Point;


public interface IClienteJpa extends JpaRepository<Cliente, Integer>{
    
    Cliente findByNombreCliente(String nombreCliente);

    Optional<Cliente> findByCorreoCliente(String correo);

    Cliente findByIdCliente(int idCliente);

    List<Cliente> findByDevolucion(int idDevolucion);

    Cliente findByCompras(int idCompra);

    Cliente findByUbicacionCliente(Point ubicacionCliente);

    @Query("SELECT c FROM Cliente c WHERE ST_Distance(c.ubicacionCliente, :puntoReferencia) < :distancia")
    Cliente encontrarClientesCercanos(@Param("puntoReferencia") Point puntoReferencia, @Param("distancia") double distancia);

    void deleteByIdCliente(int id);
}
