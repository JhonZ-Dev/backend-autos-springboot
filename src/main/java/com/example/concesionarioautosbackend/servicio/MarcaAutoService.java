package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.MarcasAutosEntidad;
import com.example.concesionarioautosbackend.repositorio.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaAutoService {
    @Autowired
    public MarcaRepositorio marcaRepositorio;

    public MarcasAutosEntidad guardar(MarcasAutosEntidad marcasAutosEntidad){
        return marcaRepositorio.save(marcasAutosEntidad);
    }

    public List<MarcasAutosEntidad> listarMarcas() {
        return marcaRepositorio.findAll();
    }
    public boolean existsByIMarca(String marca) {
        return marcaRepositorio.existsByMarca(marca);
    }

    public MarcasAutosEntidad obtenerAutosMarca(String marca){
        return marcaRepositorio.findByMarca(marca);
    }
}
