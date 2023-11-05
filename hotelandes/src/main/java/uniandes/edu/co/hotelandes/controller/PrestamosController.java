package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Prestamos;
import uniandes.edu.co.hotelandes.repositorio.PrestamosRepository;


@Controller
public class PrestamosController {
    

    @Autowired
    private PrestamosRepository prestamoRepository;

    @GetMapping("/prestamos")
    public String prestamos(Model model) {
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        return "prestamos";
    }

    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model) {
        model.addAttribute("prestamo", new Prestamos());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute Prestamos prestamo) {
        prestamoRepository.insertarPrestamo( prestamo.getNombre_utensilio(),prestamo.getEstado(),prestamo.getPrecio_utensilio());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamoEditarForm(@PathVariable("id") Integer id, Model model) {
        Prestamos prestamo = prestamoRepository.darPrestamo(id);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";
        }
        else {
            return "redirect:/prestamos";
        }
    }

    @PostMapping("/prestamos/{id}/edit/save")
    public String prestamoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Prestamos prestamo) {
        prestamoRepository.actualizarPrestamo(id, prestamo.getNombre_utensilio(), prestamo.getEstado(),prestamo.getPrecio_utensilio());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/delete")
    public String PrestamoEliminar(@PathVariable("id") Integer id) {
        prestamoRepository.eliminarPrestamo(id);
        return "redirect:/prestamos";
    }
    
}
