package uniandes.edu.co.hotelandes.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HotelandesController {
    @RequestMapping("/")
    public String index(){
        return "index";
        
    }
}
