package com.example.ra3.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ra3.entidad.Cancion;
import com.example.ra3.servicio.CancionServicio;


@Controller
public class CancionController {

	private final CancionServicio servicio;
	
    // Inyección por constructor de la implementación (CancionServicio)
    public CancionController(CancionServicio servicio) {
        this.servicio = servicio;
    }

	/**
	 * GET /entidad (listar)
	 * GET /entidad/nuevo (formulario alta)
	 * POST /entidad (crear)
	 * GET /entidad/{id}/editar (editar)
	 * POST /entidad/{id} (actualizar)
	 * POST /entidad/{id}/borrar (eliminar)
	 */
    
    @GetMapping("/entidad")
    public String listado(Model model) {
        List<Cancion> canciones = servicio.obtenerCanciones();
        model.addAttribute("listaCanciones", canciones);
        return "lista";
    }
	
}
