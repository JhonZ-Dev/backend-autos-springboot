package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.ModelosAutosEntidad;
import com.example.concesionarioautosbackend.repositorio.ModeloAutosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloAutoService {

    @Autowired
    public ModeloAutosRepositorio modeloAutosRepositorio;

    public ModelosAutosEntidad guardar(ModelosAutosEntidad modelosAutosEntidad){
        return modeloAutosRepositorio.save(modelosAutosEntidad);
    }
}
