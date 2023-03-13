package com.edix.ventas.restcontroller;

import com.edix.ventas.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/comercial")
public class ComercialRestController {

    @Autowired
    private ComercialService cServ;

    @GetMapping("/verUno/{id}")
    public ResponseEntity<?> verUno(@PathVariable("id") int idComercial) {
        if (cServ.buscarPorId(idComercial) != null) {
            return ResponseEntity.status(302).body(cServ.buscarPorId(idComercial));
        }
        return ResponseEntity.status(404).body("El comercial no existe");
    }

    @GetMapping("/todos")
    public ResponseEntity<?> verTodos(){
        if (cServ.verTodos() != null) {
            return ResponseEntity.status(302).body(cServ.verTodos());
        }
        return ResponseEntity.status(404).body("No hemos encontrado comerciales");
    }

    @GetMapping("verPorComision/{comision}")
    public ResponseEntity<?> verPorComision(double comision) {
        if (cServ.buscarPorComisionMayor(comision) != null) {
            return ResponseEntity.status(302).body(cServ.buscarPorComisionMayor(comision));
        }
        return ResponseEntity.status(404).body("No existe la comisión");
    }

}

