package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.AutoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoRepositorio extends JpaRepository<AutoEntidad, Long> {
}
