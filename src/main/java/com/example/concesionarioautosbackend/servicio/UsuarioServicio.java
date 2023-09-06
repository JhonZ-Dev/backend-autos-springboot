package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.UsuarioEntidad;
import com.example.concesionarioautosbackend.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioServicio {
    @Autowired
    public UsuarioRepositorio usuarioRepositorio;
    /*Metodo para guardar un usuario*/
    public UsuarioEntidad saveUser(UsuarioEntidad usuarioEntidad) {
        return usuarioRepositorio.save(usuarioEntidad);
    }
    /*Obtener usuario por id*/

    public UsuarioEntidad obtenerUsuarioPorId(Long id_usuario) {
        return usuarioRepositorio.findById(id_usuario).orElse(null);
    }
    public boolean existsByIdentificacion(String identificacion) {
        return usuarioRepositorio.existsByIdentificacion(identificacion);
    }

    public boolean exsiteConCorreo(String correo){
        return usuarioRepositorio.existsByCorreo(correo);
    }

    public boolean existeConTelefono(String telefono){
        return usuarioRepositorio.existsByTelefono(telefono);
    }

    public UsuarioEntidad obtenerUsuarioPorIdentificacion(String identificacion){
        return usuarioRepositorio.findByIdentificacion(identificacion);
    }

    public List<UsuarioEntidad> obtenerTodos(){
        return usuarioRepositorio.findAll();
    }



    public void eliminar(String cedula){
        usuarioRepositorio.deleteByIdentificacion(cedula);
    }


    public List<Object[]> obtenerUsuariosConAutos(){
        return usuarioRepositorio.obtenerUsuariosConAutos();
    }


}
