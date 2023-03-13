package com.edix.ventas.service;

import java.util.List;

import com.edix.ventas.beans.Cliente;


public interface ClienteService {

	Cliente buscarUno(int idCliente);
	List<Cliente> ClientesPorCiudad(String ciudad);
	List<Cliente> verTodos();
	List<Cliente> conPedidos(int idCliente);
	List<Cliente> buscarCategoria(int categoria);
	List<Cliente> conComerciales(int idComercial);
	Cliente addCliente(Cliente cliente);
	Boolean deleteCliente(int idCliente);
	Cliente modificarCliente(Cliente cliente);

}
