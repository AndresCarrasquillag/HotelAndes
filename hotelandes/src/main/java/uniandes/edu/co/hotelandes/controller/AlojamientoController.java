package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Alojamiento;
import uniandes.edu.co.hotelandes.repositorio.AlojamientoRepository;

@Controller
public class AlojamientoController {
    @Autowired
    private AlojamientoRepository alojamientoRepository;

    @GetMapping("/alojamientos")
    public String alojamientos(Model model){
        model.addAttribute("Alojamientos", alojamientoRepository.darAlojamientos());
        return "alojamientos";
    }

    @GetMapping("/alojamientos/new")
    public String alojamientoForm(Model model){
        model.addAttribute("Alojamiento", new Alojamiento());
        return "alojamientoNuevo";
    }
    @PostMapping("/alojamientos/new/save")
    public String alojamientoGuardar(@ModelAttribute Alojamiento alojamiento){
        alojamientoRepository.insertarAlojamiento(alojamiento.getUsuario_id().getId(), alojamiento.getCheck_in().getId(), alojamiento.getCheck_out().getId());
        return "redirect:/alojamientos";
    }

    @GetMapping("/alojamientos/{id}/edit")
    public String alojamientoEditarForm(@PathVariable("id") int id, Model model){
        Alojamiento alojamiento = alojamientoRepository.darAlojamiento(id);
        if (alojamiento!=null){
            model.addAttribute("alojamiento", alojamiento);
            return "alojamientoEditar";

        } else{
            return "redirect:/alojamientos";
        }
    }

    @PostMapping("/alojamientos/{id}/edit/save")
    public String alojamientoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Alojamiento alojamiento){
        alojamientoRepository.updateAlojamiento(id, alojamiento.getCheck_in().getId(), alojamiento.getCheck_out().getId());
        return "redirect:/alojamientos";

    }


    @GetMapping("/alojamiento/{id}/delete")
    public String alojamientoEliminar(@PathVariable("id") int id){
        alojamientoRepository.deleteAlojamiento(id);
        return "redirect:/alojamientos";
    }

}
 