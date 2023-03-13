package com.edix.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.stereotype.Service;

import com.edix.ventas.beans.Cliente;
import com.edix.ventas.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired ClienteRepository cliRepo;

	@Override
	public List<Cliente> verTodos() {
		return cliRepo.findAll();
	}
	@Override
	public Cliente buscarUno(int idCliente) {
		return cliRepo.findById(idCliente).orElse(null);
	}
	@Override
	public List<Cliente> ClientesPorCiudad(String ciudad) {
			return cliRepo.ClientesPorCiudad(ciudad);
	}
	@Override
	public List<Cliente> conPedidos(int idCliente) {
		return cliRepo.clienteConPedidos(idCliente);
	}

	@Override
	public List<Cliente> buscarCategoria(int categoria) {
		return cliRepo.buscarPorCategoria(categoria);
	}

	@Override
	public List<Cliente> conComerciales(int idComercial) {
		return cliRepo.clientesGestionadosPorComercial(idComercial);
	}

	@Override
	public Cliente addCliente(Cliente cliente) {
		Cliente cli = buscarUno(cliente.getIdCliente());
		if(cli.getIdCliente() == cliente.getIdCliente())
			return cliRepo.save(cliente);
		else
			return null;
	}

	@Override
	public Boolean deleteCliente(int idCliente) {
		Cliente cli = buscarUno(idCliente);
		if(cli != null) {
			cliRepo.deleteById(idCliente);
			return true;
		}else
			return false;
	}

	@Override
	public Cliente modificarCliente(Cliente cliente) {
		Cliente cli = buscarUno(cliente.getIdCliente());
		try{
			if(cli != null)
				return cliRepo.save(cliente);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
