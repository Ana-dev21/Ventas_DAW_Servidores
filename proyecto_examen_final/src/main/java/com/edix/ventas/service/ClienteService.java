package com.edix.ventas.service;

import java.util.List;

import com.edix.ventas.beans.Cliente;


public interface ClienteService {

    Cliente buscarPorId(int idCliente);

    List<Cliente> verTodos();

    List<Cliente> buscarPorCiudad(String ciudad);

    List<Cliente> buscarPorCategoria(Integer categoria);
}
