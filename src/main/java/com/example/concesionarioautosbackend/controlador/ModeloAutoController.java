package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.ModelosAutosEntidad;
import com.example.concesionarioautosbackend.servicio.ModeloAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/traer-todos")
    public List<ModelosAutosEntidad> listarModelos() {
        return modeloAutoService.listarModelos();
    }

    @PostMapping("/guardarModelo")
    public ResponseEntity<String> saveModelo(@RequestBody ModelosAutosEntidad modelosAutosEntidad) {
        modelosAutosEntidad.setId_modelos(generarNumeroAleatorio());
        modeloAutoService.guardar(modelosAutosEntidad);
        return ResponseEntity.ok("{\"message\": \"Modelo Guardado Exitosamente.\"}");
    }
    private Long generarNumeroAleatorio() {
        // Lógica para generar el número aleatorio aquí
        return (long) (Math.random() * 100000);
    }

    /*Con estos estamos haciendo el CRUD*/

}
