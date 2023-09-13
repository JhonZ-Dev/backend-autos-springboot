package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.repositorio.CitasRepositorio;
import com.example.concesionarioautosbackend.servicio.CitasService;
import com.example.concesionarioautosbackend.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "http://localhost:4200")
public class CitasController {

    private final Logger logger = LoggerFactory.getLogger(AutoControlador.class);
    @Autowired
    public CitasService citasService;
    @Autowired
    public UsuarioServicio usuarioServicio;
    @Autowired
    public CitasRepositorio citasRepositorio;


}
