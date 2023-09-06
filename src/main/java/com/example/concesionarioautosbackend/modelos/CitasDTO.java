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
    public CitasDTO(Long idcitas, String fechaEstimada, String horaEstimada, String descripcion, String correo, String identificacionUsuario, String nombreUsuario, String correoUsuario) {
        this.idcitas = idcitas;
        this.fechaEstimada = fechaEstimada;
        this.horaEstimada = horaEstimada;
        this.descripcion = descripcion;
        this.correo = correo;
        this.identificacionUsuario = identificacionUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
    }

}
