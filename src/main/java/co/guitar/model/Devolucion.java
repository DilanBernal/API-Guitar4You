package co.guitar.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the devolucion database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Devolucion.findAll", query="SELECT d FROM Devolucion d")
public class Devolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_devolucion")
	private int idDevolucion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_devolucion")
	private Date fechaDevolucion;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="id_compra")
	private Compra compra;

	//bi-directional many-to-one association to Detalledevolucion
	@ManyToOne
	@JoinColumn(name="id_detalle_devolucion")
	private Detalledevolucion detalledevolucion;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="id_sucursal")
	private Sucursal sucursal;

}