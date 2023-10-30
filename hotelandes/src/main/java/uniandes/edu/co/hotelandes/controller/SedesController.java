package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Sede;
import uniandes.edu.co.hotelandes.repositorio.SedeRepository;

@Controller
public class SedesController {
    @Autowired
    private SedeRepository sedeRepository;

    @GetMapping("/sedes")
    public String sedes(Model model) {
        model.addAttribute("sedes", sedeRepository.darSedes());
        return "sedes";
    }

    @GetMapping("/sedes/new")
    public String sedeForm(Model model) {
        model.addAttribute("sedes", new Sede());
        return "sedeNuevo";
    }

    @PostMapping("/sedes/new/save")
    public String sedeGuardar(@ModelAttribute Sede sede) {
        sedeRepository.insertSede(sede.getNombre(), sede.getTelefono(), sede.getDireccion());
        return "redirect:/sedes";
    }

    @GetMapping("/sedes/{id}/edit")
    public String sedeEditarForm(@PathVariable("id") Integer id, Model model) {
        Sede sede = sedeRepository.darSede(id);
        if (sede != null) {
            model.addAttribute("sede", sede);
            return "sedesEditar";
        }
        else {
            return "redirect:/sedes";
        }
    }

    @PostMapping("/sedes/{id}/edit/save")
    public String sedeEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Sede sede) {
        sedeRepository.updateSede(id, sede.getNombre(), sede.getTelefono(), sede.getDireccion());
        return "redirect:/sedes";
    }

    @GetMapping("/sedes/{id}/delete")
    public String sedeEliminar(@PathVariable("id") Integer id) {
        sedeRepository.deleteSede(id);
        return "redirect:/sedes";
    }
}
