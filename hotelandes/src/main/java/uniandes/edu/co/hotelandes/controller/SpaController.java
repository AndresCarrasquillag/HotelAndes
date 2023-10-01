package uniandes.edu.co.hotelandes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelandes.modelo.Spa;
import uniandes.edu.co.hotelandes.repositorio.SpaRepository;

@Controller
public class SpaController {
    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String Spas(Model model){
        model.addAttribute("spas", spaRepository.darSpas());
        return "Spas";
    }


    @GetMapping("/spas/new")
    public String spasForm(Model model){
        model.addAttribute("spa", new Spa());
        return "spaNuevo";
    }



    @GetMapping("/spas/{id}/edit")
    public String spaEditarForm(@PathVariable("id") int id, Model model){
        Spa spa = spaRepository.darSpa(id);
        if (spa!=null){
            model.addAttribute("spa", spa);
            return "spaEditar";

        } else{
            return "redirect:/spas";
        }
    }


    @PostMapping("/spas/{id}/edit/save")
    public String spaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Spa spa){
        spaRepository.updateSpa(id, spa.getDuracion(), spa.getTipo_servicio());
        return "redirect:/spas";

    }


    @GetMapping("/spas/{id}/delete")
    public String spaEliminar(@PathVariable("id") int id){
        spaRepository.deleteSpa(id);
        return "redirect:/spas";
    }


    
}
