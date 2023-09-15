package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.MarcasAutosEntidad;
import com.example.concesionarioautosbackend.servicio.MarcaAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/marcas")
public class MarcaAutoController {
    @Autowired
    public MarcaAutoService marcaAutoService;

    @PostMapping("/insertar")
    public MarcasAutosEntidad guardar(@RequestBody MarcasAutosEntidad marcasAutosEntidad){
        return marcaAutoService.guardar(marcasAutosEntidad);
    }
    @GetMapping("/traerMarcas")
    public List<MarcasAutosEntidad> listarModelos() {
        return marcaAutoService.listarMarcas();
    }
}
