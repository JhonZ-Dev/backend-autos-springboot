package com.example.concesionarioautosbackend.repositorio;

import com.example.concesionarioautosbackend.modelos.CitasEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitasRepositorio extends JpaRepository<CitasEntidad, Long> {
    @Query(value = "SELECT * FROM tbl_citas", nativeQuery = true)
    List<CitasEntidad> findAllCitas();

    CitasEntidad findByIdcitas(Long idcitas);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM tbl_citas WHERE idcitas = ?1", nativeQuery = true)
    void deleteByIdcitas(Long idcitas);
}
