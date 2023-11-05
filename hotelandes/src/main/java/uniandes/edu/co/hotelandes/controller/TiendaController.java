package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Tienda;
import uniandes.edu.co.hotelandes.repositorio.TiendaRepository;

@Controller
public class TiendaController {
    

    @Autowired
    private TiendaRepository tiendaRepository;

    @GetMapping("/tiendas")
    public String tiendas(Model model) {
        model.addAttribute("tiendas", tiendaRepository.darTiendas());
        return "tiendas";
    }

    @GetMapping("/tiendas/new")
    public String tiendaForm(Model model) {
        model.addAttribute("tienda", new Tienda());
        return "tiendaNuevo";
    }

    @PostMapping("/tiendas/new/save")
    public String tiendaGuardar(@ModelAttribute Tienda tienda) {
        tiendaRepository.insertarTienda(tienda.getNombre());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/edit")
    public String tiendaEditarForm(@PathVariable("id") Integer id, Model model) {
        Tienda tienda = tiendaRepository.darTienda(id);
        if (tienda != null) {
            model.addAttribute("tienda", tienda);
            return "tiendaEditar";
        }

        else {
            return "redirect:/tiendas";
        }

    }

    @PostMapping("/tiendas/{id}/edit/save")
    public String tiendaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Tienda tienda) {
        tiendaRepository.updateTiendas(id, tienda.getNombre());
        return "redirect:/tiendas";
    }

    @GetMapping("/tiendas/{id}/delete")
    public String TiendaEliminar(@PathVariable("id") Integer id) {
        tiendaRepository.deleteTiendas(id);
        return "redirect:/tiendas";
    }
    
}

