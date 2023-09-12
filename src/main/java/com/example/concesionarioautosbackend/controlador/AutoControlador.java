package com.example.concesionarioautosbackend.controlador;


import com.example.concesionarioautosbackend.servicio.AutoServicio;
import com.example.concesionarioautosbackend.servicio.ColorServicio;
import com.example.concesionarioautosbackend.servicio.MarcaAutoService;
import com.example.concesionarioautosbackend.servicio.ModeloAutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
