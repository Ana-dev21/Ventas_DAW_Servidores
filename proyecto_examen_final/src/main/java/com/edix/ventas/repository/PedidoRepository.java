package com.edix.ventas.repository;

import com.edix.ventas.beans.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente.idCliente =?1")
    List<Pedido> buscarPorCliente(int idCliente);
    @Query("SELECT p FROM Pedido p WHERE p.comercial.idComercial =?1")
    List<Pedido> buscarPorComercial(int idComercial);

}
