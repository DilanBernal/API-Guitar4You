package co.guitar.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Data
@NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private int idProducto;

	@Column(name = "descripcion_producto")
	private String descripcionProducto;

	@Column(name = "nombre_producto")
	private String nombreProducto;

	@Column(name = "precio_producto")
	private BigDecimal precioProducto;

	@Column(name = "stock")
	private int stock;

	@Column(name = "veces_pedido")
	private int vecesPedido;

	// bi-directional many-to-one association to Detallecompra
	@OneToMany(mappedBy = "producto")
	private List<Detallecompra> detallecompras;

	public Detallecompra addDetallecompra(Detallecompra detallecompra) {
		getDetallecompras().add(detallecompra);
		detallecompra.setProducto(this);

		return detallecompra;
	}

	public Detallecompra removeDetallecompra(Detallecompra detallecompra) {
		getDetallecompras().remove(detallecompra);
		detallecompra.setProducto(null);

		return detallecompra;
	}

}