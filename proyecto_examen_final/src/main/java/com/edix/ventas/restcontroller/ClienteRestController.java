package com.edix.ventas.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.ventas.service.ClienteService;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteRestController {
	
	@Autowired
	ClienteService clServ;


	@GetMapping("/verTodos")
	public ResponseEntity<?> verTodos() {
		if (clServ.verTodos() != null) {
			return ResponseEntity.status(302).body(clServ.verTodos());
		}
		return ResponseEntity.status(404).body("No encontrado");
	}

	@GetMapping("/verUno/{id}")
	public ResponseEntity<?> verUno(@PathVariable("id") int idCliente) {
		if (clServ.buscarPorId(idCliente) == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El cliente no existe");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(clServ.buscarPorId(idCliente));
	}
	@GetMapping("/verPorCategoria/{categoria}")
	public ResponseEntity<?> verPorCategoria(@PathVariable("categoria") int categoria) {
		if (clServ.buscarPorCategoria(categoria) != null) {
			return ResponseEntity.status(302).body(clServ.buscarPorCategoria(categoria));
		}
		return ResponseEntity.status(404).body("No existe la categoría");
	}

}
