package com.edix.ventas.repository;

import com.edix.ventas.beans.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente.idCliente = :idCliente")
    List<Pedido> findByCliente(int idCliente);

    @Query("SELECT p FROM Pedido p WHERE p.fecha = :fecha")
    List<Pedido> findByFecha(String fecha);

    @Query("SELECT p FROM Pedido p WHERE p.comercial.idComercial = :idComercial")
    List<Pedido> findByComercial(int idComercial);
}
