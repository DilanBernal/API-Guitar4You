package co.guitar.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private int idCliente;

	@Column(name = "apellido_cliente")
	private String apellidoCliente;

	@Column(name = "contrase_cliente")
	private String contraseCliente;

	@Column(name = "correo_cliente")
	private String correoCliente;

	@Column(name = "nombre_cliente")
	private String nombreCliente;

	@JsonDeserialize(using = PointDeserializer.class)
	@Column(name = "ubicacion_cliente", columnDefinition = "geometry(Point, 4326)")
	private Point ubicacionCliente;

	public Point getUbicacionCliente(){
		return ubicacionCliente;
	}

	public void setUbicacionCliente(Point ubicacionCliente){
		this.ubicacionCliente = ubicacionCliente;
	}

	// bi-directional many-to-one association to Compra
	@OneToMany(mappedBy = "cliente")
	private List<Compra> compras;

	// bi-directional many-to-one association to Devolucion
	@OneToMany(mappedBy = "cliente")
	private List<Devolucion> devolucion;

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setCliente(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setCliente(null);

		return compra;
	}

	public Devolucion addDevolucion(Devolucion devolucion) {
		getDevolucion().add(devolucion);
		devolucion.setCliente(this);

		return devolucion;
	}

	public Devolucion removeDevolucion(Devolucion devolucion) {
		getDevolucion().remove(devolucion);
		devolucion.setCliente(null);

		return devolucion;
	}

}