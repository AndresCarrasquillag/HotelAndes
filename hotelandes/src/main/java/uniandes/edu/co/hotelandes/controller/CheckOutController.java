package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Check_out;
import uniandes.edu.co.hotelandes.repositorio.CheckOutRepository;

@Controller
public class CheckOutController {
    @Autowired
    private CheckOutRepository checkOutRepository;

    @GetMapping("/checkOuts")
    public String checkOuts(Model model){
        model.addAttribute("CheckOuts", checkOutRepository.darCHECK_OUTs());
        return "checkOuts";
    }

    @GetMapping("/checkOuts/new")
    public String checkOutForm(Model model){
        model.addAttribute("CheckOut", new Check_out());
        return "checkOutNuevo";
    }
    @PostMapping("/checkOuts/new/save")
    public String checkOutGuardar(@ModelAttribute Check_out checkOut){
        checkOutRepository.insertarCHECK_OUT(checkOut.getHoraSalida());
        return "redirect:/checkOuts";
    }

    @GetMapping("/checkOuts/{id}/edit")
    public String checkOutEditarForm(@PathVariable("id") int id, Model model){
        Check_out checkOut = checkOutRepository.darCHECK_OUT(id);
        if (checkOut!=null){
            model.addAttribute("checkOut", checkOut);
            return "checkOutEditar";

        } else{
            return "redirect:/checkOuts";
        }
    }

    @PostMapping("/checkOuts/{id}/edit/save")
    public String checkOutEditarGuardar(@PathVariable("id") int id, @ModelAttribute Check_out checkOut){
        checkOutRepository.actualizarCHECK_OUT(id, checkOut.getHoraSalida());
        return "redirect:/checkOuts";

    }


    @GetMapping("/checkOut/{id}/delete")
    public String checkOutEliminar(@PathVariable("id") int id){
        checkOutRepository.eliminarCHECK_OUT(id);
        return "redirect:/checkOuts";
    }

}