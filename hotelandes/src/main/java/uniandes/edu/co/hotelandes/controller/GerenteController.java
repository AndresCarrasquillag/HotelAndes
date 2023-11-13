package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.repositorio.ProductoEnCartaRepository;
import uniandes.edu.co.hotelandes.repositorio.ProductoRepository;
import uniandes.edu.co.hotelandes.repositorio.UsuarioRepository;

@Controller
public class GerenteController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/gerente")
    public String gerenteLogIn(Model model) {
        return "consolaGerenteLogIn";
    }

    @GetMapping("/gerente/{usuario}/{contraseña}")
    public String gerente(@PathVariable("usuario") String usuario, @PathVariable("contraseña") String contraseña, Model model) {
        int vartemp = usuarioRepository.logIn(usuario, contraseña);
        if ( vartemp != -1 && vartemp ==100000){
            model.addAttribute("rol", usuarioRepository.logIn(usuario, contraseña));
            return "consolaGerente";
        }
        return "malIngresoGerente";
        
    }

    @GetMapping("/gerente/clientesExcelentes")
    public String clientesExcelentes(){
        return "clientesExcelentesFiltrar";
    }

    @GetMapping("/clientesExcelentes/estanciaTrimestral")
    public String clientesExcelentesEstanciaTrimestral(Model model){
        model.addAttribute("clientes", usuarioRepository.estanciasTrimestrales());
        return "clientesExcelentesEstancia";
    }


    @GetMapping("/gerente/clientesExcelentes/porServicio/")
    public String clientesExcelentesServicio(Model model){
        model.addAttribute("clientes", usuarioRepository.estanciasTrimestrales());
        return "clientesExcelentesEstancia";
    }
}