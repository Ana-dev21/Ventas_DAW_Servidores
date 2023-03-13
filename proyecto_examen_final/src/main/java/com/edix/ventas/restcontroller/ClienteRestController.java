package com.edix.ventas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.edix.ventas.beans.Cliente;
import com.edix.ventas.service.ClienteService;
import springfox.documentation.service.Response;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteRestController {

	@Autowired
	ClienteService cliService;

	@GetMapping("/todos")
	public List<Cliente> verTodos() {
		return cliService.verTodos();
	}

	@GetMapping("/buscar/{id}")
	public Cliente buscarUno(@PathVariable int id) {
		return cliService.buscarUno(id);
	}

	@GetMapping("/buscar/ciudad/{ciudad}")
	public ResponseEntity<?> ClientesPorCiudad(@PathVariable String ciudad) {

		List<Cliente> listaCiudad = cliService.ClientesPorCiudad(ciudad);
		if (!listaCiudad.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(cliService.ClientesPorCiudad(ciudad));
		else
			return ResponseEntity.status(404).body("No hay clientes en esta ciudad");
	}

	@GetMapping("/buscar/pedidos/{idCliente}")
	public ResponseEntity<?> conPedidos(@PathVariable int idCliente) {

		List<Cliente> listaPedidos = cliService.conPedidos(idCliente);
		if (!listaPedidos.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(cliService.conPedidos(idCliente));
		else
			return ResponseEntity.status(404).body("Este cliente no tiene pedidos");
	}

	@GetMapping("/buscar/categoria/{categoria}")
	public ResponseEntity<?> buscarCategorias(@PathVariable int categoria) {

		List<Cliente> listaCategoria = cliService.buscarCategoria(categoria);
		if (!listaCategoria.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(cliService.buscarCategoria(categoria));
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin categoria asignada");
	}

	@GetMapping("/comercial/{idComercial}")
	public ResponseEntity<?> clienteConComercial(@PathVariable int idComercial) {

		List<Cliente> conComerciales = cliService.conComerciales(idComercial);
		if (!conComerciales.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(cliService.conComerciales(idComercial));
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este cliente no ha sigo gestionado por ningún comercial");
	}
	@PostMapping("/add")
	public String añadirCliente(@RequestBody Cliente cliente){
		if(cliService.addCliente(cliente)!= null)
			return "Cliente dado de alta";
		else
			return "El cliente no se ha podido dar de alta";

	}
	@DeleteMapping("/delete/{idCliente}")
	public String eliminarCliente(@PathVariable int idCliente){
		if(cliService.deleteCliente(idCliente))
			return "Cliente eliminado";
		else
			return "Cliente no eliminado";
	}
	@PutMapping("/modificar")
	public String modificarCliente(@RequestBody Cliente cliente){
		boolean modificado = false;
		Cliente cli = cliService.modificarCliente(cliente);
		if(cli != null) {
			modificado = true;
			return "Cliente modificado";
		}else
			return "Cliente no modificado";
	}
}
