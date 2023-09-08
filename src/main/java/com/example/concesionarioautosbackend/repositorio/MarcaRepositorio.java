package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.MarcasAutosEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepositorio extends JpaRepository<MarcasAutosEntidad, Long> {
    boolean existsByMarca(String marca);

    MarcasAutosEntidad findByMarca(String marca);
}
