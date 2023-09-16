package com.example.concesionarioautosbackend.controlador;


import java.time.LocalDate;
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

    @PostMapping("/insertar")
    public ResponseEntity<String> agregarVenta(@RequestBody NuevaVentaRequest request) {
        String identificacion=request.getIdentificacion();
        String placa=request.getPlaca();
        double precio = request.getPrecio();
        LocalDate fechaVenta = request.getFecha_venta();

        UsuarioEntidad usuario = usuarioService.obtenerUsuarioPorIdentificacion(identificacion);
        AutoEntidad auto = autoService.obtenerAutoPorPlaca(placa);

        if (usuario == null || auto == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario o auto no encontrado.");
        }

        VentasEntidad venta = new VentasEntidad();
        venta.setUsuario(usuario);
        venta.setAuto(auto);
        venta.setPrecio(precio);
        venta.setFecha_venta(fechaVenta);

        ventasService.guardarVenta(venta);

        return ResponseEntity.ok("{\"message\": \"Venta agregada correctamente.\"}");

    }

}
