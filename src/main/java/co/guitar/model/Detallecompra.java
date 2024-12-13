package co.guitar.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the detallecompra database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Detallecompra.findAll", query="SELECT d FROM Detallecompra d")
public class Detallecompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_detalle_compra")
	private int idDetalleCompra;

	@Column(name="cantidad_producto")
	private int cantidadProducto;

	@Column(name="total_productos")
	private BigDecimal totalProductos;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="detallecompra")
	private List<Compra> compras;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;

	//bi-directional many-to-one association to Detalledevolucion
	@OneToMany(mappedBy="detallecompra")
	private List<Detalledevolucion> detalledevolucions;

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setDetallecompra(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setDetallecompra(null);

		return compra;
	}

	public Detalledevolucion addDetalledevolucion(Detalledevolucion detalledevolucion) {
		getDetalledevolucions().add(detalledevolucion);
		detalledevolucion.setDetallecompra(this);

		return detalledevolucion;
	}

	public Detalledevolucion removeDetalledevolucion(Detalledevolucion detalledevolucion) {
		getDetalledevolucions().remove(detalledevolucion);
		detalledevolucion.setDetallecompra(null);

		return detalledevolucion;
	}

}