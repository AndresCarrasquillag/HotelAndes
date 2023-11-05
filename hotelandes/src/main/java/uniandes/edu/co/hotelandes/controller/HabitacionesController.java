package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Habitacion;
import uniandes.edu.co.hotelandes.modelo.Sede;
import uniandes.edu.co.hotelandes.repositorio.HabitacionRepository;

@Controller
public class HabitacionesController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "habitaciones";
    }

    @GetMapping("habitaciones/new")
    public String habitacionesForm(Model model) {
        model.addAttribute("habitacion", new Habitacion());
        return "habitacionNuevo";
    }
    
    @PostMapping("habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getCapacidad(), habitacion.getCosto(), habitacion.getSede().getId(), habitacion.getTipoHabitacion().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("habitaciones/{id}/edit")
    public String habitacionEditForm(@PathVariable("id") Integer id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        if (habitacion != null) {
            model.addAttribute("habitacion", habitacion);
            return "habitacionEditar";
        }

        else {
            return "redirect:/habitaciones";
        }
    }
    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Habitacion habitacion) {
        habitacionRepository.updateHabitacion(id, habitacion.getCapacidad(), habitacion.getCosto(), habitacion.getSede().getId(), habitacion.getTipoHabitacion().getId());
        return "redirect:/habitaciones";
    }


    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") Integer id) {
        habitacionRepository.deleteHabitacion(id);
        return "redirect:/habitaciones";

        
    }
    @GetMapping("habitaciones/{id}/verIngresosForm")
    public String habitacionVerIngresosForm(@PathVariable("id") Integer id, Model model) {
        return "habitacionesIngresosForm";
    }

    @GetMapping("habitaciones/{id}/verIngresos/{fecha}")
    public String habitacionVerIngresos(@PathVariable("id") Integer id, @PathVariable("fecha") String fecha, Model model) {
        System.out.println("ID: " + id + ", Fecha: " + fecha);
        Integer valorIngreso = habitacionRepository.darIngreso(id, fecha);
        System.out.println("Ingreso: " + valorIngreso); 
        model.addAttribute("ingreso", valorIngreso);

        return "habitacionesIngresos";
    }


}

