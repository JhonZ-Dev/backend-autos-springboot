package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.VentasEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepositorio extends JpaRepository<VentasEntidad,Long> {

}
