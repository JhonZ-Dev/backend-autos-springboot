package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.AutoDTO;
import com.example.concesionarioautosbackend.modelos.AutoEntidad;
import com.example.concesionarioautosbackend.repositorio.AutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutoServicio {
    @Autowired
    public AutoRepositorio autoRepositorio;

    public AutoEntidad guardar(AutoEntidad autoEntidad ){
        return autoRepositorio.save(autoEntidad);
    }
    public AutoEntidad obtenerAutoPorId(Long id_auto) {
        return autoRepositorio.findById(id_auto).orElse(null);
    }

    public boolean existsByPlaca(String placa){
        return autoRepositorio.existsByPlaca(placa);
    }

    public AutoEntidad obtenerAutoPorPlaca(String placa){
        return autoRepositorio.findByPlaca(placa);
    }

    public long contarAutosRegistradosEnFecha(LocalDate fecha) {
        return autoRepositorio.countByFechaRegistroAuto(fecha);
    }

    public List<AutoEntidad> obtenerTodos(){
        return autoRepositorio.findAll();
    }
    public List<AutoEntidad> obtenerAutosSQL(){
        return autoRepositorio.obtenerAutos();
    }

    public List<AutoDTO> obtenerAutosConDetalles(){
        return autoRepositorio.obtenerAutosConDetalles();
    }

    public void eliminar (String placa){
        autoRepositorio.deleteByPlaca(placa);
    }



}
