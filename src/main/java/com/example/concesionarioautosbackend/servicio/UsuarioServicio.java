package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.UsuarioEntidad;
import com.example.concesionarioautosbackend.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
