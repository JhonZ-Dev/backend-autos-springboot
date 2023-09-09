package com.example.concesionarioautosbackend.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/usuarios")
public class UsuarioControlador {

    //Activar los logs:_
    private final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    

}
