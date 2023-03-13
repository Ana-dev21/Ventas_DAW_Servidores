package com.edix.ventas.controller;

import com.edix.ventas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService cServ;

    @GetMapping("/verTodos")
    public String verTodos(Model model){
        model.addAttribute("clientes", cServ.verTodos());
        return "listaClientes";
    }

    @PostMapping("/verPorCiudad")
    public String verPorCiudad(Model model, @RequestParam String ciudad){
        model.addAttribute("clientes", cServ.buscarPorCiudad(ciudad));
        return "listaClientes";
    }



}
