package co.guitar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Setter
public class CompraRequestDTO {
    private int idCliente;
    private int idProducto;
    private int cantidad;

}
