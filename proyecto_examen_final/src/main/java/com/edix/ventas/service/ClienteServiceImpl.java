package com.edix.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ventas.beans.Cliente;
import com.edix.ventas.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository cliRepo;
	
	/**
	 * Ver todos los clientes
	 */
	@Override
	public List<Cliente> verTodos() {
		
		return cliRepo.findAll();
	}
	
	/**
	 * Ver los clientes de la ciudad pasada por parámetro
	 */
	@Override
	public List<Cliente> ClientesPorCiudad(String ciudad) {
		
		//TODO Verificar que la ciudad pasada por parámetro existe
		
		return cliRepo.ClientesPorCiudad(ciudad);
	}

	

}
