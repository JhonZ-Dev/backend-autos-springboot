package com.example.concesionarioautosbackend.servicio;

import com.example.concesionarioautosbackend.modelos.VentaDTO;
import com.example.concesionarioautosbackend.modelos.VentasEntidad;
import com.example.concesionarioautosbackend.repositorio.VentasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class VentasServicio {
    @Autowired
    public VentasRepositorio ventasRepositorio;

    public VentasEntidad guardarVenta(VentasEntidad venta) {
        return ventasRepositorio.save(venta);
    }



    public List<VentaDTO> obtenerTodasLasVentasConDetalles() {
        return ventasRepositorio.findAll().stream()
                .map(venta -> {
                    VentaDTO ventaDTO = new VentaDTO();
                    ventaDTO.setId_ventas(venta.getId_ventas());
                    ventaDTO.setFechaVenta(venta.getFecha_venta());
                    ventaDTO.setPrecio(venta.getPrecio());
                    ventaDTO.setUsuario(venta.getUsuario());
                    ventaDTO.setModelos(venta.getAuto().getModelosAutosEntidad());
                    ventaDTO.setAuto(venta.getAuto());
                    return ventaDTO;
                })
                .collect(Collectors.toList());
    }
}
