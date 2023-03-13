package com.edix.ventas.repository;

import com.edix.ventas.beans.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente.idCliente = :idCliente")
    List<Pedido> findByCliente(int idCliente);

    @Query("SELECT p FROM Pedido p WHERE p.cliente.nombre LIKE %:nombre% " +
            "or p.cliente.apellido1 LIKE %:nombre% " +
            "or p.cliente.apellido2 LIKE %:nombre% ")
    List<Pedido> findByNombreCliente(String nombre);


    @Query("SELECT p FROM Pedido p WHERE p.fecha = :fecha")
    List<Pedido> findByFecha(Date fecha);

    @Query("SELECT p FROM Pedido p WHERE p.comercial.idComercial = :idComercial")
    List<Pedido> findByComercial(int idComercial);

    @Query("SELECT p FROM Pedido p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Pedido> findPedidoByFechaBetween(Date fechaInicio, Date fechaFin);

}
