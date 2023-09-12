package com.example.concesionarioautosbackend.controlador;


import com.example.concesionarioautosbackend.modelos.AutoEntidad;
import com.example.concesionarioautosbackend.servicio.AutoServicio;
import com.example.concesionarioautosbackend.servicio.ColorServicio;
import com.example.concesionarioautosbackend.servicio.MarcaAutoService;
import com.example.concesionarioautosbackend.servicio.ModeloAutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}
