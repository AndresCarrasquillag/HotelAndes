package uniandes.edu.co.hotelandes.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.hotelandes.modelo.Consumo;
import uniandes.edu.co.hotelandes.repositorio.ConsumoRepository;

@Controller
public class ConsumosController {
    
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/fechasMayoresIngresos")
    public String fechasConMayoresIngresos(Model model) {
        model.addAttribute("fechas", consumoRepository.darFechasConMayorIngreso());
        return "fechasIngresos";
    }

    @GetMapping("/buenosClientesConsumo")
    public String buenosClientesPorConsumo(Model model) {
        model.addAttribute("buenosClientes", consumoRepository.darBuenosClientesPorConsumo());
        return "buenosClientesPorConsumo";
    }

    /**@GetMapping("/serviciosPopulares")
    public String serviciosPopulares(Model model) {
        //Collection<RespInfoConsumos> frec = consumoRepository.darServiciosPopulares();
        model.addAttribute("populares", consumoRepository.darServiciosPopulares());
        return "serviciosPopulares";
    }**/

    @GetMapping("/serviciosBajaDemanda")
    public String serviciosBajaDemanda(Model model) {
        model.addAttribute("bajaDemanda", consumoRepository.darServiciosDeBajaDemanda());
        return "serviciosBajaDemanda";
    }

    @GetMapping("/usuarios/{id}/verConsumos/{fechaInicio}/{fechaFin}")
    public String consumosPorUsuario(@PathVariable("id") Integer id, @PathVariable("fechaInicio") String fechaInicio, @PathVariable("fechaFin") String fechaFin, Model model) {
        model.addAttribute("consumo", consumoRepository.darConsumosUsuario(id, fechaInicio, fechaFin));
        return "consumoUsuario";
    }

    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumo());
        return "consumoNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute Consumo consumo) {
        consumoRepository.insertConsumo(consumo.getId(), consumo.getCosto(), consumo.getFecha_de_pago(), consumo.getDescripcion());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/edit")
    public String consumoEditarForm(@PathVariable("id") Integer id, Model model) {
        Consumo consumo = consumoRepository.darConsumo(id);
        if(consumo != null) {
            model.addAttribute("consumo", consumo);
            return "rolEditar";
        }

        else {
            return "redirect:/consumos";
        }
    }

    @PostMapping("consumos/{id}/edit/save")
    public String consumoEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Consumo consumo) {
        consumoRepository.updateConsumo(id, consumo.getCosto(), consumo.getFecha_de_pago(), consumo.getDescripcion());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") Integer id) {
        consumoRepository.deleteConsumo(id);
        return "redirect:/roles";
    }

    @GetMapping("/habitaciones/{id}/verIngresos")
    public String habitacionVerIngresos(@PathVariable("id") Integer id, Model model) {
        Integer valorIngreso = consumoRepository.darIngreso(id);
        model.addAttribute("ingreso", valorIngreso);

        return "habitacionesIngresos";
    }

    @GetMapping("/serviciosPopulares/{fechaInicio}/{fechaFin}")
    public String serviciosPopulares(@PathVariable("fechaInicio") String fechaInicio, @PathVariable("fechaFin") String fechaFin, Model model) {
        model.addAttribute("populares", consumoRepository.darServiciosPopulares(fechaInicio, fechaFin));
        return "serviciosPopulares";
    }

    @GetMapping("/serviciosPopularesForm")
    public String serviciosPopularesForm(Model model) {
        return "serviciosPopularesForm";
    }
}
