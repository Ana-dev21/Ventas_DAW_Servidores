package com.edix.ventas.controller;

import com.edix.ventas.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comerciales")
public class ComercialController {

    @Autowired
    private ComercialService cServ;

    @RequestMapping("/verTodos")
    public String verTodos(Model model){
        model.addAttribute("comerciales", cServ.verTodos());
        return "listaComerciales";
    }
}
