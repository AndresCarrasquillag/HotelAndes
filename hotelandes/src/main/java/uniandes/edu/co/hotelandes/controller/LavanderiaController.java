package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Lavanderia;
import uniandes.edu.co.hotelandes.repositorio.LavanderiaRepository;

@Controller
public class LavanderiaController {
    

    @Autowired
    private LavanderiaRepository lavanderiaRepository;

    @GetMapping("/lavanderias")
    public String lavanderias(Model model) {
        model.addAttribute("lavanderias", lavanderiaRepository.darLavanderias());
        return "lavanderias";
    }

    @GetMapping("/lavanderias/new")
    public String lavanderiaForm(Model model) {
        model.addAttribute("lavanderia", new Lavanderia());
        return "lavanderiaNuevo";
    }

    @PostMapping("/lavanderias/new/save")
    public String lavanderiaGuardar(@ModelAttribute Lavanderia lavanderia) {
        lavanderiaRepository.insertarLavanderia( lavanderia.getPrecioPorPrenda(),lavanderia.getCantidadPrenda());
        return "redirect:/lavanderias";
    }

    @GetMapping("/lavanderias/{id}/edit")
    public String lavanderiaEditarForm(@PathVariable("id") Integer id, Model model) {
        Lavanderia lavanderia = lavanderiaRepository.darLavanderia(id);
        if (lavanderia != null) {
            model.addAttribute("lavanderia", lavanderia);
            return "lavanderiaEditar";
        }

        else {
            return "redirect:/lavanderias";
        }

    }

    @PostMapping("/lavanderias/{id}/edit/save")
    public String lavanderiaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Lavanderia lavanderia) {
        lavanderiaRepository.actualizarLavanderia(id, lavanderia.getCantidadPrenda(), lavanderia.getPrecioPorPrenda());
        return "redirect:/lavanderias";
    }

    @GetMapping("/lavanderias/{id}/delete")
    public String LavanderiaEliminar(@PathVariable("id") Integer id) {
        lavanderiaRepository.eliminarLavanderia(id);
        return "redirect:/lavanderias";
    }
    
}
