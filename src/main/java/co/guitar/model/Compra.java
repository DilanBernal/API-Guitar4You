package co.guitar.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the compra database table.
 * 
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@NamedQuery(name="Compra.findAll", query="SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compra")
	private int idCompra;

	@Column(name="estado_compra")
	private EstadoCompra estadoCompra;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_compra")
	private Date fechaCompra;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_entrega")
	private Date fechaEntrega;

	@Column(name="precio_total_compra")
	private BigDecimal precioTotalCompra;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Detallecompra
	@ManyToOne
	@JoinColumn(name="id_detalle_compra")
	private Detallecompra detallecompra;

	//bi-directional many-to-one association to Devolucion
	@OneToMany(mappedBy="compra")
	private List<Devolucion> devolucions;


	public Devolucion addDevolucion(Devolucion devolucion) {
		getDevolucions().add(devolucion);
		devolucion.setCompra(this);

		return devolucion;
	}

	public Devolucion removeDevolucion(Devolucion devolucion) {
		getDevolucions().remove(devolucion);
		devolucion.setCompra(null);

		return devolucion;
	}

}