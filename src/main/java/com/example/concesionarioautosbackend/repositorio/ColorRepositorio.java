package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.ColorAutoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepositorio extends JpaRepository<ColorAutoEntidad, Long> {
    boolean existsByColor(String color);

    ColorAutoEntidad findByColor(String color);

}
