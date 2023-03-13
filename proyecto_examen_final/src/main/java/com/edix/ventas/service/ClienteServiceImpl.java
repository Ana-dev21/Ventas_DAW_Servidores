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
	 * @param idCliente ID del cliente a buscar
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

	/**
	 * Ver los clientes de la provincia pasada por parámetro
	 * @param categoria 100, 200, 300
	 * @return List<Cliente>
	 */
	@Override
	public List<Cliente> buscarPorCategoria(Integer categoria) {
		return cRep.findByCategoria(categoria);
	}

	/**
	 * Funcion que devuelve los nombres de los clientes que tienen un pedido con un importe mayor al pasado por parámetro
	 * @param importe Importe mínimo a buscar
	 * @return List<String>
	 */
	@Override
	public List<String> buscarPorImportePedido(double importe) {
		return cRep.findByImporte(importe);
	}

	

}
