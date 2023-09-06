package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.CitasDTO;
import com.example.concesionarioautosbackend.modelos.CitasEntidad;
import com.example.concesionarioautosbackend.repositorio.CitasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CitasService {
    @Autowired
    public CitasRepositorio citasRepositorio;

    public CitasEntidad generarCita(CitasEntidad citasEntidad){
        return  citasRepositorio.save(citasEntidad);
    }

    public List<CitasEntidad> obtenerCitas(){
        return citasRepositorio.findAll().stream()
                .map(cita ->{
                    CitasEntidad request = new CitasEntidad();
                    request.setUsuario(request.getUsuario());
                    request.setDescripcion(request.getDescripcion());
                    request.setCorreo(request.getCorreo());
                    request.setHora_estimada(request.getHora_estimada());
                    request.setFecha_estimada(request.getFecha_estimada());
                    return request;
                }).collect(Collectors.toList());
    }

    public List<CitasEntidad> findAllCitas(){
        return citasRepositorio.findAllCitas();
    }
    // Método para obtener todas las citas y mapearlas a DTOs
    public List<CitasDTO> obtenerTodasLasCitas() {
        List<CitasEntidad> citasEntidades = citasRepositorio.findAll();
        return citasEntidades.stream()
                .map(this::mapCitasEntidadToDto)
                .collect(Collectors.toList());
    }

    private CitasDTO mapCitasEntidadToDto(CitasEntidad cita) {
        return new CitasDTO(
                cita.getIdcitas(),
                cita.getFecha_estimada(),
                cita.getHora_estimada(),
                cita.getDescripcion(),
                cita.getCorreo(),
                cita.getUsuario().getIdentificacion(),
                cita.getUsuario().getNombre(),
                cita.getUsuario().getCorreo()
        );
    }

    public CitasEntidad obtenerCitaPorId(Long idcitas){
        return citasRepositorio.findByIdcitas(idcitas);
    }

    public CitasDTO obtenerCitaDTOPorId(Long id) {
        CitasEntidad cita = citasRepositorio.findById(id).orElse(null);

        if (cita != null) {
            // Aquí debes convertir la entidad CitasEntidad a CitasDTO
            // Puedes usar algún mapeo o construir manualmente el DTO
            CitasDTO citaDTO = new CitasDTO(
                    cita.getIdcitas(),
                    cita.getFecha_estimada(),
                    cita.getHora_estimada(),
                    cita.getDescripcion(),
                    cita.getCorreo(),
                    cita.getUsuario().getIdentificacion(),
                    cita.getUsuario().getNombre(),
                    cita.getUsuario().getCorreo()
            );
            return citaDTO;
        } else {
            return null;
        }
    }

    public void deleteByIdcitas(Long idcitas){
        citasRepositorio.deleteByIdcitas(idcitas);
    }
}
