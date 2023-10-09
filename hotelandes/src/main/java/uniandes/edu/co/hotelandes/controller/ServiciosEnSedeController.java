package uniandes.edu.co.hotelandes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Sede;
import uniandes.edu.co.hotelandes.modelo.Servicio;
import uniandes.edu.co.hotelandes.modelo.ServicioEnSede;
import uniandes.edu.co.hotelandes.modelo.ServicioEnSedePK;
import uniandes.edu.co.hotelandes.repositorio.SedeRepository;
import uniandes.edu.co.hotelandes.repositorio.ServicioEnSedeRepository;
import uniandes.edu.co.hotelandes.repositorio.ServicioRepository;

@Controller
public class ServiciosEnSedeController {

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private SedeRepository sedeRepository;

    @Autowired
    private ServicioEnSedeRepository servicioEnSedeRepository;

    @GetMapping("/serviciosEnSede/new")
    public String serviciosEnSedeForm(Model model) {
        model.addAttribute("servicios", servicioRepository.darServicios());
        model.addAttribute("sedes", sedeRepository.darSedes());
        return "serviciosEnSedeNuevo";
    }

    @PostMapping("/serviciosEnSede/new/save")
    public String serviciosEnSedeGuardar(@ModelAttribute("servicios_id") Integer idServicios, @ModelAttribute("sedes_id") Integer idSedes) {

        Servicio servicio = servicioRepository.darServicio(idServicios);
        Sede sede = sedeRepository.darSede(idSedes);
        ServicioEnSedePK pk = new ServicioEnSedePK(servicio, sede);
        ServicioEnSede servicioEnSede = new ServicioEnSede();
        servicioEnSede.setPk(pk);
        servicioEnSedeRepository.insertServicioEnSede(servicioEnSede.getPk().getId_servicio().getId(), servicioEnSede.getPk().getId_sede().getId());
        return "redirect:/serviciosEnSede";
    }
    
}
