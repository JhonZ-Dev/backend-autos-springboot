package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.AutoEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AutoRepositorio extends JpaRepository<AutoEntidad, Long> {



    @Query("SELECT COUNT(a) FROM AutoEntidad a WHERE a.fecha_registroAuto = :fecha")
    long countByFechaRegistroAuto(@Param("fecha") LocalDate fecha);


    boolean existsByPlaca(String placa);
    AutoEntidad findByPlaca(String placa);

    @Query("SELECT a FROM AutoEntidad a " +
            "INNER JOIN FETCH a.modelosAutosEntidad m " +
            "INNER JOIN FETCH a.colorAutoEntidad c " +
            "INNER JOIN FETCH a.marcasAutosEntidad ma " +
            "WHERE a.placa IS NOT NULL")
    List<AutoEntidad> obtenerAutos();

    @Query("SELECT NEW com.example.v3_u3_proyecto.entidades.AutoDTO(" +
            "a.placa, a.anio, m.modelo, c.color, ma.marca) " +
            "FROM AutoEntidad a " +
            "JOIN a.modelosAutosEntidad m " +
            "JOIN a.colorAutoEntidad c " +
            "JOIN a.marcasAutosEntidad ma " +
            "WHERE a.placa IS NOT NULL")
    List<AutoDTO> obtenerAutosConDetalles();





    @Transactional
    @Modifying
    @Query(value = "DELETE FROM auto_entidad WHERE placa = ?1", nativeQuery = true)
    void deleteByPlaca(String placa);
}
