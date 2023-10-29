package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.TipoHabitacion;
import uniandes.edu.co.hotelandes.repositorio.TipoHabitacionRepository;

@Controller
public class TiposHabitacionController {
    
    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposHabitacion")
    public String tiposHabitacion(Model model) {
        model.addAttribute("tiposHabitacion", tipoHabitacionRepository.darTiposHabitacion());
        return "tiposHabitacion";
    }

    @GetMapping("/tiposHabitacion/new")
    public String tiposHabitacionesForm(Model model) {
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionNuevo";
    }

    @PostMapping("/tiposHabitacion/new/save")
    public String tipoHabitacionGuardar(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.insertTipoHabitacion(tipoHabitacion.getDescripcion(), tipoHabitacion.getNombre_tipo());
        return "redirect:/tiposHabitacion";
    }

    @GetMapping("/tiposHabitaciones/{id}/edit")
    public String tipoHabitacionEditarForm(@PathVariable("id") Integer id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if (tipoHabitacion != null) {
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "tipoHabitacionEditar";
        }
        else {
            return "redirect:/tiposHabitacion";
        }
    }

    @PostMapping("/tiposHabitaciones/{id}/edit/save")
    public String tiposHabitacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.updateTipoHabitacion(id, tipoHabitacion.getDescripcion(), tipoHabitacion.getNombre_tipo());
        return "redirect:/tiposHabitaciones";
    }

    @GetMapping("/tiposHabitaciones/{id}/delete")
    public String tipoHabitacionEliminar(@PathVariable("id") Integer id) {
        tipoHabitacionRepository.deleteTipoHabiatcion(id);
        return "redirect:/tiposHabitacion";
    }
}
