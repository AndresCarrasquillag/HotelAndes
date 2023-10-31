package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Carta;
import uniandes.edu.co.hotelandes.repositorio.CartaRepository;

@Controller
public class CartasController {
    @Autowired
    private CartaRepository cartaRepository;

@PostMapping("/cartas/new/save")
public String cartaGuardar(@ModelAttribute Carta carta){
    cartaRepository.save(carta); 
    return "redirect:/cartas";
}

    
    @GetMapping("/cartas")
    public String cartas(Model model){
        model.addAttribute("cartas", cartaRepository.darCartas());
        return "cartas";
    }

    @GetMapping("/cartas/new")
    public String cartaForm(Model model){
        model.addAttribute("carta", new Carta());
        return "cartaNuevo";
    }
    

    @GetMapping("/cartas/{id}/edit")
    public String cartaEditarForm(@PathVariable("id") int id, Model model){
        Carta carta = cartaRepository.darCarta(id);
        if (carta!=null){
            model.addAttribute("carta", carta);
            return "cartaEditar";

        } else{
            return "redirect:/cartas";
        }
    }



    @GetMapping("/cartas/{id}/delete")
    public String cartaEliminar(@PathVariable("id") int id){
        cartaRepository.eliminarCarta(id);
        return "redirect:/cartas";
    }


}
 