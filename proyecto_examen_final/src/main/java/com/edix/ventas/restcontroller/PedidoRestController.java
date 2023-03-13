package com.edix.ventas.restcontroller;

import com.edix.ventas.beans.Cliente;
import com.edix.ventas.beans.Comercial;
import com.edix.ventas.beans.Pedido;
import com.edix.ventas.service.ClienteService;
import com.edix.ventas.service.ComercialService;
import com.edix.ventas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.service.Response;

import java.util.List;

@RestController
@RequestMapping("/rest/pedido")
public class PedidoRestController {

    @Autowired
    PedidoService peSer;
    @Autowired
    ComercialService coSer;
    @Autowired
    ClienteService cliSer;

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
    @PostMapping("/alta")
    public ResponseEntity<String> altaPedido(@RequestBody Pedido pedido) {
        try {
            Cliente cliente = cliSer.buscarUno(1);
            Comercial comercial = coSer.buscarUno(2);
            pedido.setCliente(cliente);
            pedido.setComercial(comercial);
            peSer.darAlta(pedido);
            return ResponseEntity.ok("Pedido dado de alta");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al dar de alta el pedido: " + e.getMessage());
        }
    }
    @DeleteMapping("/delete/{idPedido}")
    public String eliminarPedido(@PathVariable int idPedido){
        try{
            peSer.eliminarPedido(idPedido);
            return "Pedido eliminado";
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage() + " Error al eliminar el pedido";
        }
    }
}
