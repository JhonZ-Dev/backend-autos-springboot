package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.ColorAutoEntidad;
import com.example.concesionarioautosbackend.servicio.ColorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/color")
public class ColorControlador {

    @Autowired
    public ColorServicio colorServicio;
    @PostMapping("/insertar")
    public ColorAutoEntidad guardar(@RequestBody ColorAutoEntidad colorAutoEntidad){
        return colorServicio.guardar(colorAutoEntidad);
    }
}
