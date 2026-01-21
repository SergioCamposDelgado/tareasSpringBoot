package com.example.ra3.controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ra3.entidad.Cancion;
import com.example.ra3.servicio.CancionServicio;

import jakarta.validation.Valid;


@Controller
public class CancionController {

	private final CancionServicio servicio;
	
    // Inyección por constructor de la implementación (CancionServicio)
    public CancionController(CancionServicio servicio) {
        this.servicio = servicio;
    }

	/**
	 * GET /cancion (listar)
	 * GET /cancion/nuevo (formulario alta)
	 * POST /cancion (crear)
	 * GET /cancion/{id}/editar (editar)
	 * POST /cancion/{id} (actualizar)
	 * POST /cancion/{id}/borrar (eliminar)
	 */
    
    //listar
    @GetMapping("/cancion")
    public String listado(Model model) {
        List<Cancion> canciones = servicio.obtenerCanciones();
        model.addAttribute("listaCanciones", canciones);
        return "lista";
    }
    
    
    //formulario de alta
    @GetMapping("/cancion/nuevo")
    public String formularioAlta(Model model) {
        model.addAttribute("cancion", new Cancion());
        return "formulario";
    }
    
    //crear
    @PostMapping("/cancion")
    public String nuevaCancion (@Valid Cancion cancion,
            BindingResult bindingResult) {
    	
        // Si hay errores de validación, volvemos al formulario
        if (bindingResult.hasErrors()) {
            return "formulario";
        } else {

        if (cancion.getId() == null) {
            // Crear nuevo
            servicio.agregarCancion(cancion);
        } else {
            // Editar existente
        	servicio.actualizarCancion(cancion);
        }

        // PRG: redirigimos para evitar que F5 repita el POST
        return "redirect:/cancion";
        }
    }
    
    //editar
    @GetMapping("/cancion/{id}/editar")
    public String mostrarFormEditar(@PathVariable int id, Model model) {
        Cancion cancion = servicio.obtenerCancionPorId(id);
        model.addAttribute("cancion", cancion);
        return "formulario"; // mismo formulario que para crear
    }
	
}
