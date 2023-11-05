package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Rol;
import uniandes.edu.co.hotelandes.repositorio.RolRepository;

@Controller
public class RolesController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/roles")
    public String roles(Model model) {
        model.addAttribute("roles", rolRepository.darRoles());
        return "roles";
    }

    @GetMapping("/roles/new")
    public String rolForm(Model model) {
        model.addAttribute("rol", new Rol());
        return "rolNuevo";
    }

    @PostMapping("/roles/new/save")
    public String rolGuardar(@ModelAttribute Rol rol) {
        rolRepository.insertarRol(rol.getRol(), rol.getDescripcion());
        return "redirect:/roles";
    }

    @GetMapping("/roles/{id}/edit")
    public String rolEditarForm(@PathVariable("id") Integer id, Model model) {
        Rol rol = rolRepository.darRol(id);
        if (rol != null) {
            model.addAttribute("rol", rol);
            return "rolEditar";
        }

        else {
            return "redirect:/roles";
        }

    }

    @PostMapping("/roles/{id}/edit/save")
    public String rolEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Rol rol) {
        rolRepository.updateRol(id, rol.getDescripcion());
        return "redirect:/roles";
    }

    @GetMapping("/roles/{id}/delete")
    public String RolEliminar(@PathVariable("id") Integer id) {
        rolRepository.deleteRol(id);
        return "redirect:/roles";
    }
    
}
