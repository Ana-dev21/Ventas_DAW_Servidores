package com.edix.ventas.controller;

import com.edix.ventas.service.ComercialService;
import com.edix.ventas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/comerciales")
public class ComercialController {

    @Autowired
    private ComercialService cServ;

    @Autowired
    private PedidoService pServ;

    @GetMapping("/verTodos")
    public String verTodos(Model model){
        model.addAttribute("comerciales", cServ.verTodos());
        return "listaComerciales";
    }

    @GetMapping("/detalle/{idComercial}")
    public String verUno(Model model, @PathVariable int idComercial){
        model.addAttribute("comercial", cServ.buscarPorId(idComercial));
        model.addAttribute("totalVentas", cServ.totalVentasPorComercial(idComercial));
        model.addAttribute("pedidos", pServ.pedidosPorComercial(idComercial));
        return "verComercial";
    }
}
