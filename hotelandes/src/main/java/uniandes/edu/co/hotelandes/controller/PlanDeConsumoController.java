package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.PlanesDeConsumo;
import uniandes.edu.co.hotelandes.repositorio.PlanDeConsumoRepository;

@Controller
public class PlanDeConsumoController {

    @Autowired
    private PlanDeConsumoRepository planDeConsumoRepository;

    @GetMapping("/planesDeConsumo")
    public String planesDeConsumo(Model model) {
        model.addAttribute("planesDeConsumo", planDeConsumoRepository.darPlanesDeConsumo());
        return "planesDeConsumo";
    }

    @GetMapping("planesDeConsumo/new")
    public String planesDeConsumoForm(Model model) {
        model.addAttribute("planDeConsumo", new PlanesDeConsumo());
        return "planDeConsumoNuevo";
    }

    @PostMapping("planesDeConsumo/new/save")
    public String planesDeConsumoGuardar(@ModelAttribute PlanesDeConsumo planesDeConsumo) {
        planDeConsumoRepository.insertPlanDeConsumo(planesDeConsumo.getNombre(), planesDeConsumo.getDescripcion(), planesDeConsumo.getDescuento(), planesDeConsumo.getHotel().getId());
        return "redirect:/planesDeConsumo";
    }

    @GetMapping("planesDeConsumo/{id}/edit")
    public String planDeConsumoEditForm(@PathVariable("id") Integer id, Model model) {
        PlanesDeConsumo planesDeConsumo = planDeConsumoRepository.darPlanDeConsumo(id);
        if (planesDeConsumo != null) {
            model.addAttribute("planDeConsumo", planesDeConsumo);
            return "planesDeConsumoEditar";
        }
        else {
            return "redirect:/planesDeConsumo";
        }
    }
    @PostMapping("/planesDeConsumo/{id}/edit/save")
    public String planesDeConsumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute PlanesDeConsumo planesDeConsumo) {
        planDeConsumoRepository.updatePlanDeConsumo(id, planesDeConsumo.getNombre(), planesDeConsumo.getDescripcion(), planesDeConsumo.getDescuento(),  planesDeConsumo.getHotel().getId());
        return "redirect:/planesDeConsumo";
    }

    @GetMapping("/planesDeConsumo/{id}/delete")
    public String planDeConsumoEliminar(@PathVariable("id") Integer id) {
        planDeConsumoRepository.deletePlanesDeConsumo(id);
        return "redirect:/planesDeConsumo";
    }
}
