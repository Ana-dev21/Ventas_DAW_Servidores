package com.edix.ventas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.ventas.beans.Cliente;
import com.edix.ventas.service.ClienteService;

@RestController
@RequestMapping("/rest/cliente")
public class ClienteRestController {
	
	@Autowired
	ClienteService cliService;
	
	
	@GetMapping("/todos")
	public List<Cliente> verTodos(){
		return cliService.verTodos();
		
	}
}
