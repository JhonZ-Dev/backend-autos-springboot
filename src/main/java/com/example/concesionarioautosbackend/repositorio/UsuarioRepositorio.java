package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.UsuarioEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, Long> {
}
