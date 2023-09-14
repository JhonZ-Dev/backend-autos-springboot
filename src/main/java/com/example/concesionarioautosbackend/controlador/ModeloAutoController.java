package com.example.concesionarioautosbackend.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modelo-auto")
@CrossOrigin(origins = "http://localhost:4200")
public class ModeloAutoController {

    @Autowired
    ModeloAutoService modeloAutoService;
}
