package com.example.concesionarioautosbackend.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_modelos_autos")
public class ModelosAutosEntidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modelos;
    @Id
    private String modelo;

    @CreationTimestamp
    private Time horarioIngresoNuevoModelo;

    @CreationTimestamp
    private LocalDate fechaNuevoModelo;

    @JsonIgnore
    @OneToMany(mappedBy = "modelosAutosEntidad", cascade = CascadeType.ALL)
    private List<AutoEntidad> auto;
}
