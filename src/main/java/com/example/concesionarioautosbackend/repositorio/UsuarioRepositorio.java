package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.UsuarioEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, Long> {

    boolean existsByIdentificacion(String identificacion);

    UsuarioEntidad findByIdentificacion(String identificacion);
    boolean existsByCorreo(String correo);
    boolean existsByTelefono(String telefono);
    @Transactional
    @Modifying
    @Query("DELETE FROM UsuarioEntidad u WHERE u.identificacion = :identificacion")
    void deleteByIdentificacion(String identificacion);


    @Query("SELECT DISTINCT u, v.auto.placa AS placa_auto " +
            "FROM UsuarioEntidad u " +
            "INNER JOIN VentasEntidad v ON u.identificacion = v.usuario.identificacion " +
            "WHERE v.auto.placa IS NOT NULL")
    List<Object[]> obtenerUsuariosConAutos();
}
