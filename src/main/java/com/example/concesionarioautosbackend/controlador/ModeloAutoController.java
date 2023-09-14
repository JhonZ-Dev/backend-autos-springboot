package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.servicio.ModeloAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/modelo-auto")
@CrossOrigin(origins = "http://localhost:4200")
public class ModeloAutoController {

    @Autowired
    ModeloAutoService modeloAutoService;

    @PostMapping("/insertar")
    public ModelosAutosEntidad guardar(@RequestBody ModelosAutosEntidad modelosAutosEntidad){
        return modeloAutoService.guardar(modelosAutosEntidad);
    }
}
