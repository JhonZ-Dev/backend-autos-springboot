package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.servicio.VentasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ventas")

public class VentasControlador {

    @Autowired
    public VentasServicio ventasService;
    @Autowired
    public UsuarioServicio usuarioService;
    @Autowired
    public AutoServicio autoService;

}
