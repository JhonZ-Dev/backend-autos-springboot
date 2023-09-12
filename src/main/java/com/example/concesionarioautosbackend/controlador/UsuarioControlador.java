package com.example.concesionarioautosbackend.controlador;

import com.example.concesionarioautosbackend.modelos.UsuarioEntidad;
import com.example.concesionarioautosbackend.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //metodo para obtener los usuario --GET
    @GetMapping("/obtenerUsuarios")
    public List<UsuarioEntidad> obtenerUsuario(){
        return usuarioServicio.obtenerTodos();
    }

    //metodo para traer un usuario por identificacion
    @GetMapping("/usuariosByIdentificacion/{identificacion}")
    public UsuarioEntidad obtenerUsuarioPorCedula(@PathVariable String identificacion){
        return usuarioServicio.obtenerUsuarioPorIdentificacion(identificacion);
    }

    //metodo para actualizar un usuario --UPDATE
    @PutMapping("/actualizar/{cedula}")
    public ResponseEntity<String> updateUser(@PathVariable String cedula, @RequestBody UsuarioEntidad usuarioEntidad) {
        UsuarioEntidad usuarioExistente = usuarioServicio.obtenerUsuarioPorIdentificacion(cedula);

        // Verificar si el usuario con el ID proporcionado existe
        if (usuarioExistente == null) {
            logger.warn("Intento de actualizar un usuario inexistente con identificación: {}", cedula);
            return ResponseEntity.notFound().build();
        }
        //mantener el id generado
        usuarioEntidad.setId_usuario(usuarioExistente.getId_usuario());
        //usuarioEntidad.setIdentificacion(cedula);
        usuarioServicio.saveUser(usuarioEntidad);
        logger.info("Usuario actualizado exitosamente con ID: {}", cedula);
        return ResponseEntity.ok("{\"message\": \"Usuario Actualizado Exitosamente.\"}");
    }

    //eliminar por id
    @DeleteMapping("/eliminar/{cedula}")
    public void eliminarUnUsuarioPorIden(@PathVariable String cedula){
        usuarioServicio.eliminar(cedula);
    }

    //METODO PARA VERIFICAR UN USUARIO POR CORREO
    @GetMapping("/verificarCorreo/{correo}")
    public ResponseEntity<Boolean> verificarCorreo(@PathVariable String correo) {
        boolean existe = usuarioServicio.exsiteConCorreo(correo);
        return ResponseEntity.ok(existe);
    }
    //metodo para verificar un usuario por su celular
    @GetMapping("/verificarTelefono/{telefono}")
    public ResponseEntity<Boolean> verificarTelefono(@PathVariable String telefono) {
        boolean existe = usuarioServicio.existeConTelefono(telefono);
        return ResponseEntity.ok(existe);
    }
    //Obtener los usuarios con sus autos
    @GetMapping("/usuariosConAutos")
    public List<Object[]> obtenerUsuariosConAutos(){
        return usuarioServicio.obtenerUsuariosConAutos();
    }







}
