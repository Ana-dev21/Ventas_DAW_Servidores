package com.edix.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.ventas.beans.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	//Busqueda de clientes pertenecientes a una ciudad
	@Query("SELECT c FROM Cliente c WHERE c.ciudad = ?1")
	List<Cliente> ClientesPorCiudad(String ciudad);

	//Búsqueda de los clientes que tienen pedidos
	@Query("SELECT c FROM Cliente c JOIN c.pedidos p WHERE c.idCliente = ?1")
	List<Cliente> clienteConPedidos(int idCliente);

	//Que clientes pertenecen a cierta categoria.
	@Query("SELECT c FROM Cliente c WHERE c.categoria= ?1")
	List<Cliente> buscarPorCategoria(int categoria);

	//Clientes que han sido asignados a un comercial
	@Query("SELECT c FROM Cliente c JOIN c.pedidos p WHERE p.comercial.idComercial = ?1")
	List<Cliente> clientesGestionadosPorComercial(int idComercial);
}