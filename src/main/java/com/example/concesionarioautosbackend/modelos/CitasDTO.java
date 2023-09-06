package com.example.concesionarioautosbackend.modelos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CitasDTO {
    private Long idcitas;
    private String fechaEstimada;
    private String horaEstimada;
    private String descripcion;
    private String correo;
    private String identificacionUsuario;
    private String nombreUsuario;
    private String correoUsuario;

}
