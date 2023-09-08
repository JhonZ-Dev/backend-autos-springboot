package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.ColorAutoEntidad;
import com.example.concesionarioautosbackend.repositorio.ColorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServicio {
    @Autowired
    public ColorRepositorio colorRepositorio;

    public ColorAutoEntidad guardar(ColorAutoEntidad colorAutoEntidad){
        return colorRepositorio.save(colorAutoEntidad);
    }

    public List<ColorAutoEntidad> listarColores() {
        return colorRepositorio.findAll();
    }
    public boolean existsByColor(String color) {
        return colorRepositorio.existsByColor(color);
    }

    public ColorAutoEntidad obtenerAutosColor(String color){
        return colorRepositorio.findByColor(color);
    }
}
