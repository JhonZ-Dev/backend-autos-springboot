package com.example.concesionarioautosbackend.modelos;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_marcasAutos")
@Data
public class MarcasAutosEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_marca;
    @Id
    private String marca;
    @CreationTimestamp
    private Time hora_ingresoMarcas;
    @CreationTimestamp
    private LocalDate fecha_registroMarcas;
}
