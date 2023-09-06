package com.example.concesionarioautosbackend.modelos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AutoDTO {
    private String modelo;
    private String marca;
    private String anio;
    private String color;
    private String placa;

}
