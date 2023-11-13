package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Servicio;
import uniandes.edu.co.hotelandes.repositorio.ServicioRepository;

@Controller
public class ServiciosController {

    @Autowired
    private ServicioRepository servicioRepository;
    
    @GetMapping("/servicios")
    public String servicios(Model model) {
       //model.addAttribute("servicios", servicioRepository.darServicios());
        return "servicios";
    }

    @GetMapping("/serviciosConsumos")
    public String serviciosConsumos(Model model, String fechaInicio, String fechaFin, String tipo_servicio, String costo1, String costo2) {
        if (fechaInicio == null || fechaInicio.equals("")) {
            fechaInicio = "1000-12-12";
        }

        if (fechaFin == null || fechaFin.equals("")) {
            fechaFin = "5000-12-12";
        }

        if (costo1 == null || costo1.equals("")) {
            costo1 = "0";
        }

        if (costo2 == null || costo2.equals("")) {
            costo2 = "999999999";
        }

        model.addAttribute("filtrosServicios", servicioRepository.darServiciosCombinado(fechaInicio, fechaFin, Integer.parseInt(costo1), Integer.parseInt(costo2), tipo_servicio));

        return "serviciosFiltro";
    }

    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String servicioGuardar(@ModelAttribute Servicio servicio) {
        servicioRepository.insertServicio(servicio.getCosto(), servicio.getTipo_servicio(),servicio.getHorario_de_servicio() );
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String servicioEditForm(@PathVariable("id") Integer id, Model model) {
        Servicio servicio = servicioRepository.darServicio(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        }
        else {
            return "redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String servicioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Servicio servicio) {
        servicioRepository.updateServicio(id, servicio.getCosto(),servicio.getTipo_servicio(),servicio.getHorario_de_servicio());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") Integer id) {
        servicioRepository.deleteServicio(id);
        return "redirect:/servicio";
    }
}
