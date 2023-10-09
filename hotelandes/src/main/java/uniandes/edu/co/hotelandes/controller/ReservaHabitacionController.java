package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Habitacion;
import uniandes.edu.co.hotelandes.modelo.Reserva;
import uniandes.edu.co.hotelandes.modelo.ReservaHabitacion;
import uniandes.edu.co.hotelandes.modelo.ReservaHabitacionPK;
import uniandes.edu.co.hotelandes.repositorio.HabitacionRepository;
import uniandes.edu.co.hotelandes.repositorio.ReservaHabitacionRepository;
import uniandes.edu.co.hotelandes.repositorio.ReservaRepository;

@Controller
public class ReservaHabitacionController {
    
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ReservaHabitacionRepository reservaHabitacionRepository;

    @GetMapping("/reservasHabitacion/new")
    public String reservaHabitacion(Model model) {
        model.addAttribute("reservas", reservaRepository.darReservas());
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "reservaHabitacionNuevo";
    }

    @PostMapping("/reservasHabitacion/new/save")
    public String reservaHabitacionGuardar(@ModelAttribute("reserva_id") Integer reserva_id, @ModelAttribute("habitacion_id") Integer habitacion_id) {

        Reserva reserva = reservaRepository.darReserva(reserva_id);
        Habitacion habitacion = habitacionRepository.darHabitacion(habitacion_id);
        ReservaHabitacionPK pk = new ReservaHabitacionPK(habitacion, reserva);
        ReservaHabitacion reservaHabitacion = new ReservaHabitacion();
        reservaHabitacion.setPk(pk);
        reservaHabitacionRepository.insertReservaHabitacion(reservaHabitacion.getPk().getId_habitacion().getId(), reservaHabitacion.getPk().getId_reserva().getId());
        return "redirect:/reservasHabitacion";
    }
}
