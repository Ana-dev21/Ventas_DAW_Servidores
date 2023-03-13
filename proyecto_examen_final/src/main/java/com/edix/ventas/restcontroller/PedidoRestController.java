package com.edix.ventas.restcontroller;

import com.edix.ventas.beans.Pedido;
import com.edix.ventas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/pedidos")
public class PedidoRestController {

    @Autowired
    private PedidoService pServ;

    @GetMapping("/porComercial/{id}")
    public List<Pedido> verPedidosComercial(@PathVariable("id") int idComercial) {
        return pServ.pedidosPorComercial(idComercial);
    }

    @GetMapping("/verTodos")
    public List<Pedido> verTodos(){
        return pServ.verTodos();
    }

    @PostMapping("/nuevo")
    public String hacerPedido(@RequestBody Pedido pedido){
        return (pServ.hacerPedido(pedido)==1)?"Pedido realizado":"Error en hacer pedido";
    }

    @GetMapping("/buscarPorId/{id}")
    public List<Pedido> verPedidosClienteId(@PathVariable("id") int idCliente) {
        return pServ.buscarPorCliente(idCliente);
    }

    @GetMapping("/buscarPorNombre/{nombre}")
    public ResponseEntity<?> verPedidosClienteNombre(@PathVariable("nombre") String nombre) {
        if (pServ.buscarPorNombreCliente(nombre) != null) {
            return ResponseEntity.status(302).body(pServ.buscarPorNombreCliente(nombre));
        }
        return ResponseEntity.status(404).body("No encontrado");
    }

    @GetMapping("/porFechaEntre/{fechaInicio}/{fechaFin}")
    public List<Pedido> verPedidosCliente(@PathVariable("fechaInicio") String fechaInicio,
                                          @PathVariable("fechaFin") String fechaFin){

        return pServ.buscarPorFechaEntre(fechaInicio, fechaFin);
    }


}
