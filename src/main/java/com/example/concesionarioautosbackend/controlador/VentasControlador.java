package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.VentaDTO;
import com.example.concesionarioautosbackend.servicio.AutoServicio;
import com.example.concesionarioautosbackend.servicio.UsuarioServicio;
import com.example.concesionarioautosbackend.servicio.VentasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/obtenerTodo")
    public ResponseEntity<List<VentaDTO>> obtenerTodasLasVentas() {
        List<VentaDTO> ventas = ventasService.obtenerTodasLasVentasConDetalles();
        return ResponseEntity.ok(ventas);
    }

}
