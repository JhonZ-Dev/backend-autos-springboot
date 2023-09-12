package com.example.concesionarioautosbackend.modelos;

import lombok.Data;

@Data

public class NuevoAutoAgregar {
    private String marca;
    private String anio;
    private String color;
    private String modelo;
    private String placa;
}
