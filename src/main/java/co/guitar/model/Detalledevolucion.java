package co.guitar.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * The persistent class for the detalledevolucion database table.
 * 
 */
@Entity
@Data
@NamedQuery(name = "Detalledevolucion.findAll", query = "SELECT d FROM Detalledevolucion d")
public class Detalledevolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_devolucion")
	private int idDetalleDevolucion;

	@Column(name = "motivo_devolucion")
	private String motivoDevolucion;

	// bi-directional many-to-one association to Detallecompra
	@ManyToOne
	@JoinColumn(name = "id_detalle_compra")
	private Detallecompra detallecompra;

	// bi-directional many-to-one association to Devolucion
	@OneToMany(mappedBy = "detalledevolucion")
	private List<Devolucion> devolucions;

	public Devolucion addDevolucion(Devolucion devolucion) {
		getDevolucions().add(devolucion);
		devolucion.setDetalledevolucion(this);

		return devolucion;
	}

	public Devolucion removeDevolucion(Devolucion devolucion) {
		getDevolucions().remove(devolucion);
		devolucion.setDetalledevolucion(null);

		return devolucion;
	}

}