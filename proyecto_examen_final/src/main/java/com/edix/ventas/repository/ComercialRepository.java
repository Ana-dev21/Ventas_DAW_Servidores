package com.edix.ventas.repository;

import com.edix.ventas.beans.Comercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComercialRepository extends JpaRepository <Comercial, Integer> {
    @Query("SELECT c FROM Comercial c WHERE c.comision = ?1")
    List<Comercial> conComision(double comision);
    @Query("SELECT c FROM Comercial c JOIN c.pedidos p WHERE p.cliente.idCliente = ?1")
    List<Comercial> comercialesAtiendenClientes(int idCliente);
    @Query("SELECT c FROM Comercial c JOIN c.pedidos p WHERE p.idPedido = ?1")
    List<Comercial> comercialesConPedidos(int idPedido);
}
