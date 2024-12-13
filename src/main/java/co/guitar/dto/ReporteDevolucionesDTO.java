package co.guitar.dto;

import lombok.Data;

@Data
public class ReporteDevolucionesDTO{
    private String nombreCliente;
    private String apellidoCliente;
    private String motivoDevolucion;
    private String nombreProducto;
    private Long totalDevoluciones;

}
