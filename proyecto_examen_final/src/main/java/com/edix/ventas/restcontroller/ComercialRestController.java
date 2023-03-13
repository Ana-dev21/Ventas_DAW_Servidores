package com.edix.ventas.restcontroller;

import com.edix.ventas.beans.Comercial;
import com.edix.ventas.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.Response;

import java.util.List;

@RestController
@RequestMapping("/rest/comercial")
public class ComercialRestController {

    @Autowired
    ComercialService coSer;

    @GetMapping("/todos")
    public ResponseEntity<?> buscarTodos(){
        List<Comercial> listaComerciales = coSer.buscarTodos();
        if(!listaComerciales.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(listaComerciales);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existen comerciales");
    }

    @GetMapping("/buscar/{idComercial}")
    public ResponseEntity<?> buscarComercial(@PathVariable int idComercial){
        Comercial com = coSer.buscarUno(idComercial);
        if(com != null)
            return ResponseEntity.status(200).body(com);
        else
            return ResponseEntity.status(404).body("Comercial no encontrado");
    }
    @GetMapping("/buscar/comision/{comision}")
    public ResponseEntity<?> comercialesConComision(@PathVariable double comision){
        List<Comercial> listaComerciales = coSer.conComision(comision);
        if(!listaComerciales.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(listaComerciales);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay comerciales con esta comision");
    }
    @GetMapping("/buscar/comercial/{idCliente}")
    public ResponseEntity<?> comercialesAtiendeCliente(@PathVariable int idCliente){
        List<Comercial> listaComerciales = coSer.atiendeCliente(idCliente);
        if(!listaComerciales.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(listaComerciales);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este comercial no ha atendido a ningún cliente");
    }
    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<?> comercialGestionaPedido(@PathVariable int idPedido){
        List<Comercial> listaComerciales = coSer.comercialConPedido(idPedido);
        if(!listaComerciales.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(listaComerciales);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este pedido no ha sido gestionado por ningún comercial");
    }
    @PostMapping("/add")
    public ResponseEntity<?> añadirComercial(@RequestBody Comercial comercial){
        Comercial com = coSer.addComercial(comercial);
        if(com != null)
            return ResponseEntity.status(HttpStatus.OK).body("Comercial  dado de alta");
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha podido dar de alta al comercial");
    }
    @DeleteMapping("/delete/{idComercial}")
    public String eliminarComercial(@PathVariable int idComercial){
        if(coSer.eliminarComercial(idComercial))
            return "Comercial eliminado con éxito";
        else
            return "No se ha eliminado el comercial";
    }
    @PutMapping("/editar")
    public String modificarComercial(@RequestBody Comercial comercial){
        Comercial com = coSer.modificarComercial(comercial);
        if(com != null)
            return "Comercial modificado";
        else
            return "Comercial no se ha podido modificar";
    }

}
