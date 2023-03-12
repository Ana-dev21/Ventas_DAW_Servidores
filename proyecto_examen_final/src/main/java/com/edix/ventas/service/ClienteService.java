package com.edix.ventas.service;

import java.util.List;

import com.edix.ventas.beans.Cliente;


public interface ClienteService {

	List<Cliente> ClientesPorCiudad(String ciudad);
	List<Cliente> verTodos();

}
