package com.example.concesionarioautosbackend.controlador;


import com.example.concesionarioautosbackend.modelos.*;
import com.example.concesionarioautosbackend.servicio.AutoServicio;
import com.example.concesionarioautosbackend.servicio.ColorServicio;
import com.example.concesionarioautosbackend.servicio.MarcaAutoService;
import com.example.concesionarioautosbackend.servicio.ModeloAutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/autos")
public class AutoControlador {

    private final Logger logger = LoggerFactory.getLogger(AutoControlador.class);

    @Autowired
    public AutoServicio autoServicio;

    @Autowired
    public ModeloAutoService modeloAutoService;
    @Autowired
    public MarcaAutoService marcaAutoService;
    @Autowired
    public ColorServicio colorServicio;

    private Long generarNumeroAleatorio() {
        // Lógica para generar el número aleatorio aquí
        return (long) (Math.random() * 100000);
    }
    @PostMapping("/insertar")
    public ResponseEntity<String> guardarUnAuto(@RequestBody AutoEntidad autoEntidad){
        String placa = autoEntidad.getPlaca();
        //verificar si existe un auto con la misma placa
        if (autoServicio.existsByPlaca(placa)) {
            logger.warn("Intento de guardar un auto con placa duplicada: {}", placa);
            return ResponseEntity.badRequest().body("Placa duplicada");
        }
        // Si la placa no está duplicada, proceder con el guardado
        autoEntidad.setId_auto(generarNumeroAleatorio());
        autoServicio.guardar(autoEntidad);
        logger.info("Auto guardado exitosamente con placa: {}", placa);
        return ResponseEntity.ok("{\"message\": \"Auto Guardado Exitosamente.\"}");
    }

    @PostMapping("/guardarNuevoAuto")
    public ResponseEntity<String>agregarAutoNuevo(@RequestBody NuevoAutoAgregar nuevoAutoAgregar) {
        String modelo = nuevoAutoAgregar.getModelo();
        String anio = nuevoAutoAgregar.getAnio();
        String color = nuevoAutoAgregar.getColor();
        String placa = nuevoAutoAgregar.getPlaca();
        String marca = nuevoAutoAgregar.getMarca();
        ModelosAutosEntidad modelosAutosEntidad = modeloAutoService.obtenerAutosModelo(modelo);
        MarcasAutosEntidad marcasAutosEntidad = marcaAutoService.obtenerAutosMarca(marca);
        ColorAutoEntidad colorAutoEntidad = colorServicio.obtenerAutosColor(color);
        if (autoServicio.existsByPlaca(placa)) {
            logger.warn("Intento de guardar un auto con placa duplicada: {}", placa);
            return ResponseEntity.badRequest().body("Placa duplicada");
        }
        if (modelosAutosEntidad == null || marcasAutosEntidad==null || colorAutoEntidad==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("modelo o marca de auto no encontrado.");
        }
        AutoEntidad autoEntidad = new AutoEntidad();
        autoEntidad.setModelosAutosEntidad(modelosAutosEntidad);
        autoEntidad.setMarcasAutosEntidad(marcasAutosEntidad);
        autoEntidad.setColorAutoEntidad(colorAutoEntidad);
        autoEntidad.setAnio(anio);
        autoEntidad.setPlaca(placa);
        autoEntidad.setId_auto(generarNumeroAleatorio());
        autoServicio.guardar(autoEntidad);
        logger.info("Auto guardado exitosamente con placa: {}", placa);

        return ResponseEntity.ok("{\"message\": \"Auto agregado correctamente.\"}");
    }

    @GetMapping("/obtener-autos")
    public List<AutoEntidad> obtenerTodos(){
        return autoServicio.obtenerTodos();
    }




}
