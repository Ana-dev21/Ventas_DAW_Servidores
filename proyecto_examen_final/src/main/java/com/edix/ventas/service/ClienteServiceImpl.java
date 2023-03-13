package com.edix.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.ventas.beans.Cliente;
import com.edix.ventas.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository cRep;
	/**
	 * Función que busca un cliente por su id
	 * @param idCliente
	 * @return Cliente
	 */
	@Override
	public Cliente buscarPorId(int idCliente) {

		return cRep.findById(idCliente).orElse(null);
	}

	/**
	 * Ver todos los clientes
	 */
	@Override
	public List<Cliente> verTodos() {
		
		return cRep.findAll();
	}
	
	/**
	 * Ver los clientes de la ciudad pasada por parámetro
	 */
	@Override
	public List<Cliente> buscarPorCiudad(String ciudad) {
		
		//TODO Verificar que la ciudad pasada por parámetro existe
		
		return cRep.findByCiudad(ciudad);
	}

	@Override
	public List<Cliente> buscarPorCategoria(Integer categoria) {
		return cRep.findByCategoria(categoria);
	}


	

}
