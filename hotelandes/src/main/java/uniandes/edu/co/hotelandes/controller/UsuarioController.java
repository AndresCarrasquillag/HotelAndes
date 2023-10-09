package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelandes.modelo.Usuario;
import uniandes.edu.co.hotelandes.repositorio.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.darUsuarios());
        return "ususarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarioNuevo";
    }

    @PostMapping("/usuarios/new/save")
    public String usuariosGuardar(@ModelAttribute Usuario usuario) {
        usuarioRepository.insertUsuario(usuario.getUser(), usuario.getPassword(), usuario.getNombre(), usuario.getTelefono());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEditarForm(@PathVariable("id") Integer id, Model model) {
        Usuario usuario = usuarioRepository.darUsuario(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "usuarioEditar";
        }

        else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/usuarios/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Usuario usuario) {
        usuarioRepository.updateUsuarios(id, usuario.getUser(), usuario.getPassword(), usuario.getNombre(), usuario.getTelefono());
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/{id}/delete")
    public String UsuarioEliminar(@PathVariable("id") Integer id) {
        usuarioRepository.deleteUsuario(id);
        return "redirect:/usuarios";
    }
}
