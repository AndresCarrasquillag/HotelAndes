package uniandes.edu.co.hotelandes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Salon;

import uniandes.edu.co.hotelandes.modelo.Sede;

import uniandes.edu.co.hotelandes.repositorio.SalonRepository;
public class SalonController {
    @Autowired
    private SalonRepository salonRepository;

    @GetMapping("/salones")
    public String salones(Model model) {
        model.addAttribute("salones", salonRepository.darSalones());
        return "salones";
    }

    @GetMapping("/salones/new")
    public String rolForm(Model model) {
        model.addAttribute("salon", new Salon());
        return "salonNuevo";
    }

    @PostMapping("/salones/new/save")
    public String salonGuardar(@ModelAttribute Salon salon) {

        salonRepository.insertarSalon(salon.getDisponibilidad(), salon.getHora_limpieza(),salon.getTipo());

        return "redirect:/salon";
    }



    @GetMapping("/salones/{id}/edit")
    public String salonEditarForm(@PathVariable("id") Integer id, Model model) {
        Salon salon = salonRepository.darSalon(id);
        if (salon != null) {
            model.addAttribute("salon", salon);
            return "salonEditar";
        }
        else {
            return "redirect:/salon";
        }
    }


    @PostMapping("/salones/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Salon salon) {
        salonRepository.updateSalon(id, salon.getDisponibilidad(), salon.getHora_limpieza(),salon.getTipo());
        return "redirect:salon";
    }

    @GetMapping("/salones/{id}/delete")
    public String salonEliminar(@PathVariable("id") Integer id) {
        salonRepository.deleteSalon(id);
        return "redirect:/s";
    }




}

