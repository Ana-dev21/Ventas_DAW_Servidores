package com.edix.ventas.service;

import java.util.List;

import com.edix.ventas.beans.Cliente;


public interface ClienteService {

	List<Cliente> verTodos();

    List<Cliente> buscarPorCiudad(String ciudad);
}
