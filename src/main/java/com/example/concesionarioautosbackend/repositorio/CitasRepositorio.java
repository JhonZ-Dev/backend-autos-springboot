package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.CitasEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitasRepositorio extends JpaRepository<CitasEntidad, Long> {
}
