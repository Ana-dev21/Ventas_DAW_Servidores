package com.edix.ventas.controller;

import com.edix.ventas.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Access;

@Controller
public class HomeController {

    @Autowired
    private ComercialService cServ;

    @RequestMapping("/")
    public String home(){
        return "index";
    }


}
