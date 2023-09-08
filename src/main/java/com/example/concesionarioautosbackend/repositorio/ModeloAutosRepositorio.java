package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.ModelosAutosEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloAutosRepositorio extends JpaRepository<ModelosAutosEntidad, Long> {

    boolean existsByModelo(String modelo);

    ModelosAutosEntidad findByModelo(String modelo);
}
