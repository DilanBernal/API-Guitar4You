package co.guitar.dto;

import lombok.Data;

@Data
public class ClienteRegisterDTO {
    private String nombreCliente;
    private String apellidoCliente;
    private String correoCliente;
    private String contraseCliente;
    private double latitude;
    private double longitude;
}
