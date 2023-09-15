package com.example.concesionarioautosbackend.modelos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NuevaVentaRequest {

    private double precio;
    private LocalDate fecha_venta;
    private String identificacion;
    private String placa;
}
