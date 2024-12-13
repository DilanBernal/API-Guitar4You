package co.guitar.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import org.springframework.data.geo.Point;

/**
 * The persistent class for the sucursal database table.
 * 
 */
@Entity
@Data
@NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sucursal")
	private int idSucursal;

	@Column(name = "nombre_sucursal")
	private String nombreSucursal;

	@Column(name = "ubicacion_sucursal")
	private Point ubicacionSucursal;

	// bi-directional many-to-one association to Devolucion
	@OneToMany(mappedBy = "sucursal")
	private List<Devolucion> devolucions;

	public Devolucion addDevolucion(Devolucion devolucion) {
		getDevolucions().add(devolucion);
		devolucion.setSucursal(this);

		return devolucion;
	}

	public Devolucion removeDevolucion(Devolucion devolucion) {
		getDevolucions().remove(devolucion);
		devolucion.setSucursal(null);

		return devolucion;
	}

}