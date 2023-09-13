package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.CitasEntidad;
import com.example.concesionarioautosbackend.modelos.NuevaCitaRequest;
import com.example.concesionarioautosbackend.modelos.UsuarioEntidad;
import com.example.concesionarioautosbackend.repositorio.CitasRepositorio;
import com.example.concesionarioautosbackend.servicio.CitasService;
import com.example.concesionarioautosbackend.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/guardar-cita")
    public ResponseEntity<String> agregarCita(@RequestBody NuevaCitaRequest request){
        String identificacion= request.getIdentificacion();
        String fechaCita = request.getFecha_estimada();
        String horaEstimada = request.getHora_estimada();
        String correo= request.getCorreo();
        String descripcion= request.getDescripcion();
        UsuarioEntidad usuario = usuarioServicio.obtenerUsuarioPorIdentificacion(identificacion);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado.");
        }
        CitasEntidad citas = new CitasEntidad();
        citas.setUsuario(usuario);
        citas.setFecha_estimada(fechaCita);
        citas.setHora_estimada(horaEstimada);
        citas.setCorreo(correo);
        citas.setDescripcion(descripcion);
        citasService.generarCita(citas);
        return ResponseEntity.ok("{\"message\": \"Cita agregada correctamente.\"}");
    }
}
