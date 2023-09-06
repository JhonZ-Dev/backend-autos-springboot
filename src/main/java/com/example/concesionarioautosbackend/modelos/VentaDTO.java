package com.example.concesionarioautosbackend.modelos;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class VentaDTO {
    private Long id_ventas;
    private LocalDate fechaVenta;
    private double precio;
    private UsuarioEntidad usuario;
    private AutoEntidad auto;
    private ModelosAutosEntidad modelos;
    /*PARA ESTA CLASE SE USA UN DTO, CON EL OBJETIVO DE TRAER LOS USUARIOS CON SUS AUTOS*/
    //EJEMPLO,
    //Si se requiere mostrar el modelo del auto que le pertenece a Jhon//
    //Aqui es necesario un DTO para poder relacionar sus IDs.

}
