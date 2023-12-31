package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.MarcasAutosEntidad;
import com.example.concesionarioautosbackend.servicio.MarcaAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private Long generarNumeroAleatorio() {
        // Lógica para generar el número aleatorio aquí
        return (long) (Math.random() * 100000);
    }
    @PostMapping("/guardarMarca")
    public ResponseEntity<String> saveModelo(@RequestBody MarcasAutosEntidad marcasAutosEntidad) {
        marcasAutosEntidad.setId_marca(generarNumeroAleatorio());
        marcaAutoService.guardar(marcasAutosEntidad);
        return ResponseEntity.ok("{\"message\": \"Marca Guardada Exitosamente.\"}");
    }
}
