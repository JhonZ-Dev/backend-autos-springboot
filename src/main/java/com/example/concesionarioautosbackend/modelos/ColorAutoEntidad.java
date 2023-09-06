package com.example.concesionarioautosbackend.modelos;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_colorAuto")
@Data
public class ColorAutoEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_color;
    @Id
    private String color;
    @CreationTimestamp
    private Time hora_ingresoColor;

    @CreationTimestamp
    private LocalDate fecha_registroColor;

}
