package uniandes.edu.co.hotelandes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.hotelandes.modelo.Carta;
import uniandes.edu.co.hotelandes.modelo.Producto;
import uniandes.edu.co.hotelandes.modelo.ProductosEnCarta;
import uniandes.edu.co.hotelandes.modelo.ProductosEnCartaPK;
import uniandes.edu.co.hotelandes.repositorio.CartaRepository;
import uniandes.edu.co.hotelandes.repositorio.ProductoEnCartaRepository;
import uniandes.edu.co.hotelandes.repositorio.ProductoRepository;

@Controller
public class ProductosEnCartaController {

    @Autowired
    private CartaRepository cartaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductoEnCartaRepository productosEnCartaRepository;

    @GetMapping("/ProductoEnCarta/new")
    public String productosEnCartaForm(Model model) {
        model.addAttribute("productos", productoRepository.darProductos());
        model.addAttribute("cartas", cartaRepository.darCartas());
        return "productoEnCartaNuevo";
    }

    @PostMapping("/productosEnCarta/new/save")
    public String productosEnCartaGuardar(@ModelAttribute("producto_id") Integer idProducto,
            @ModelAttribute("carta_id") Integer idCarta) {

        Carta carta = cartaRepository.darCarta(idCarta);
        Producto producto = productoRepository.darProducto(idProducto);
        ProductosEnCartaPK pk = new ProductosEnCartaPK(carta, producto);
        ProductosEnCarta productosEnCarta = new ProductosEnCarta();
        productosEnCarta.setPk(pk);
        productosEnCartaRepository.insertProductoEnCarta(productosEnCarta.getPk().getCartas_id().getId(), productosEnCarta.getPk().getProducto_id().getId());
        return "redirect:/productos";
    }
}