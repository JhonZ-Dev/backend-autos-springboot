package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.UsuarioEntidad;
import com.example.concesionarioautosbackend.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")
public class UsuarioControlador {

    //Activar los logs:_
    private final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    //llamar al servicio con la anotacion @Autowire
    @Autowired
    private UsuarioServicio usuarioServicio;

    //Generar un numero alearotrio, ya que no estamos relacionando con ID pero es ncesario un ID
    private Long generarNumeroAleatorio() {
        // Lógica para generar el número aleatorio aquí
        return (long) (Math.random() * 100000);
    }
    //metodo para guardar un usuario
    @PostMapping("/guardar")
    public ResponseEntity<String> saveUser(@RequestBody UsuarioEntidad usuarioEntidad) {
        String identificacion = usuarioEntidad.getIdentificacion();

        // Verificar si ya existe un usuario con la misma identificación
        if (usuarioServicio.existsByIdentificacion(identificacion)) {
            logger.warn("Intento de guardar un usuario con identificación duplicada: {}", identificacion);
            return ResponseEntity.badRequest().body("Identificación duplicada");
        }

        // Si la identificación no está duplicada, proceder con el guardado
        usuarioEntidad.setId_usuario(generarNumeroAleatorio());
        usuarioServicio.saveUser(usuarioEntidad);
        logger.info("Usuario guardado exitosamente con identificación: {}", identificacion);
        return ResponseEntity.ok("{\"message\": \"Usuario Guardado Exitosamente.\"}");
    }



}
