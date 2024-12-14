package co.guitar.dao.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.guitar.model.Cliente;
import co.guitar.model.Compra;
import co.guitar.model.Devolucion;

import java.util.Optional;

import org.locationtech.jts.geom.Point;

public interface IClienteJpa extends JpaRepository<Cliente, Integer> {

    Cliente findByNombreCliente(String nombreCliente);

    Optional<Cliente> findByCorreoCliente(String correo);

    Cliente findByIdCliente(int idCliente);

    Cliente findByDevolucion(Devolucion devolucion);

    Cliente findByCompras(Compra compra);

    Cliente findByUbicacionCliente(Point ubicacionCliente);

    @Query(value = "INSERT INTO cliente (nombre_cliente, apellido_cliente, correo_cliente, contrase_cliente, ubicacion_cliente) "
            +
            "VALUES (:nombreCliente, :apellidoCliente, :correoCliente, :contraseCliente, " +
            "ST_GeomFromText('POINT(:longitud :latitud)', 4326))", nativeQuery = true)
    void crearCliente(@Param("nombreCliente") String nombreCliente,
            @Param("apellidoCliente") String apellidoCliente,
            @Param("correoCliente") String correoCliente,
            @Param("contraseCliente") String contraseCliente,
            @Param("latitud") double latitud,
            @Param("longitud") double longitud);

    @Query("SELECT c FROM Cliente c WHERE ST_Distance(c.ubicacionCliente, :puntoReferencia) < :distancia")
    Cliente encontrarClientesCercanos(@Param("puntoReferencia") Point puntoReferencia,
            @Param("distancia") double distancia);

    void deleteByIdCliente(int id);
}
