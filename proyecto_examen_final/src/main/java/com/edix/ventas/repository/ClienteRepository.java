package com.edix.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.ventas.beans.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	/**
	 * Obtener todos los clientes de una ciudad especifica
	 */
	@Query("SELECT c FROM Cliente c WHERE c.ciudad = :ciudad")
	List<Cliente> ClientesPorCiudad(String ciudad);
}