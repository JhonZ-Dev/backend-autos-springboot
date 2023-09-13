package com.example.concesionarioautosbackend.modelos;

import lombok.Data;

@Data
public class NuevaCitaRequest {
    private String identificacion;
    private String fecha_estimada;
    private String hora_estimada;
    private String correo;
    private String descripcion;
}
