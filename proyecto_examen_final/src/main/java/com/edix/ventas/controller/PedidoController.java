package com.edix.ventas.controller;

import com.edix.ventas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pServ;

    @GetMapping("/verTodos")
    public String verTodos(Model model){
        model.addAttribute("pedidos", pServ.verTodos());
        return "listaPedidos";
    }

    @PostMapping("/verPorCliente")
    public String verPorCliente(Model model, @RequestParam int idCliente){
        model.addAttribute("pedidos", pServ.buscarPorCliente(idCliente));
        return "listaPedidos";
    }

    @PostMapping("/verPorFecha")
    public String verPorFecha(Model model, @RequestParam String fecha){
        model.addAttribute("pedidos", pServ.pedidosPorFecha(fecha));
        return "listaPedidos";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
