package com.edix.ventas.restcontroller;

import com.edix.ventas.beans.Pedido;
import com.edix.ventas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.Response;

import java.util.List;

@RestController
@RequestMapping("/rest/pedido")
public class PedidoRestController {

    @Autowired
    PedidoService peSer;

    @GetMapping("/todos")
    public List<Pedido> buscarTodos(){
        return peSer.buscarTodos();
    }
    @GetMapping("/buscar/uno/{idPedido}")
    public ResponseEntity<?> buscarUnPedido(@PathVariable int idPedido){
        Pedido pedido = peSer.buscarUno(idPedido);
        if(pedido != null)
            return ResponseEntity.status(HttpStatus.OK).body(pedido);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado el pedido");
    }
    @GetMapping("/buscar/cliente/{idCliente}")
    public ResponseEntity<?> buscarPorCliente(@PathVariable int idCliente){

        List<Pedido> listaPedidos = peSer.buscarPorCliente(idCliente);
        if(listaPedidos != null)
            return ResponseEntity.status(HttpStatus.OK).body(listaPedidos);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este cliente no ha hecho pedidos todavía");
    }
    @GetMapping("/buscar/comercial/{idComercial}")
    public ResponseEntity<?> buscarPorComercial(@PathVariable int idComercial){
        List<Pedido> listaComerciales = peSer.buscarPorComercial(idComercial);
        if (!listaComerciales.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(listaComerciales);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El comercial no tiene pedidos asignados");
    }
}
