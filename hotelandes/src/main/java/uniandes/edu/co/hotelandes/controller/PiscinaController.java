package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Piscina;
import uniandes.edu.co.hotelandes.repositorio.PiscinaRepository;

@Controller
public class PiscinaController {
    

    @Autowired
    private PiscinaRepository piscinaRepository;

    @GetMapping("/piscinas")
    public String piscinas(Model model) {
        model.addAttribute("piscinas", piscinaRepository.darPiscinas());
        return "piscinas";
    }


    @GetMapping("/piscinas/new")
    public String piscinaForm(Model model) {
        model.addAttribute("piscina", new Piscina());
        return "piscinaNuevo";
    }

    @PostMapping("/piscinas/new/save")
    public String piscinaGuardar(@ModelAttribute Piscina piscina) {
        piscinaRepository.insertarPiscina(piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/edit")
    public String piscinaEditarForm(@PathVariable("id") Integer id, Model model) {
        Piscina piscina = piscinaRepository.darPiscina(id);
        if (piscina != null) {
            model.addAttribute("piscina", piscina);
            return "piscinaEditar";
        }

        else {
            return "redirect:/piscinas";
        }

    }

    @PostMapping("/piscinas/{id}/edit/save")
    public String piscinaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Piscina piscina) {
        piscinaRepository.actualizarPiscina(id, piscina.getProfundidad());
        return "redirect:/piscinas";
    }

    @GetMapping("/piscinas/{id}/delete")
    public String PiscinaEliminar(@PathVariable("id") Integer id) {
        piscinaRepository.eliminarPiscina(id);
        return "redirect:/piscinas";
    }
    
}

