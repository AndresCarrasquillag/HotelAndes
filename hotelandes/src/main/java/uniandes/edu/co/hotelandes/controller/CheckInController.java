package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Check_In;
import uniandes.edu.co.hotelandes.repositorio.CheckInRepository;

@Controller
public class CheckInController {
    @Autowired
    private CheckInRepository checkInRepository;

    @GetMapping("/checkIns")
    public String checkIns(Model model){
        model.addAttribute("CheckIns", checkInRepository.darCHECK_INs());
        return "checkIns";
    }

    @GetMapping("/checkIns/new")
    public String checkInForm(Model model){
        model.addAttribute("CheckIn", new Check_In());
        return "checkInNuevo";
    }
    @PostMapping("/checkIns/new/save")
    public String checkInGuardar(@ModelAttribute Check_In checkIn){
        checkInRepository.insertarCHECK_IN(checkIn.getHoraEntrada());
        return "redirect:/checkIns";
    }

    @GetMapping("/checkIns/{id}/edit")
    public String checkInEditarForm(@PathVariable("id") int id, Model model){
        Check_In checkIn = checkInRepository.darCHECK_IN(id);
        if (checkIn!=null){
            model.addAttribute("checkIn", checkIn);
            return "checkInEditar";

        } else{
            return "redirect:/checkIns";
        }
    }

    @PostMapping("/checkIns/{id}/edit/save")
    public String checkInEditarGuardar(@PathVariable("id") int id, @ModelAttribute Check_In checkIn){
        checkInRepository.actualizarCHECK_IN(id, checkIn.getHoraEntrada());
        return "redirect:/checkIns";

    }


    @GetMapping("/checkIn/{id}/delete")
    public String checkInEliminar(@PathVariable("id") int id){
        checkInRepository.eliminarCHECK_IN(id);
        return "redirect:/checkIns";
    }

}
 