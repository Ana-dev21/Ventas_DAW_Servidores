package com.edix.ventas.service;

import com.edix.ventas.beans.Pedido;

import java.util.Date;
import java.util.List;

public interface PedidoService {
    List<Pedido> verTodos();

    Pedido buscarPorId(int idPedido);

    List<Pedido> buscarPorCliente(int idCliente);

    List<Pedido> buscarPorNombreCliente(String nombre);


    List<Pedido> pedidosPorFecha(String fecha);

    List<Pedido> pedidosPorComercial(int idComercial);

    int hacerPedido(Pedido pedido);
    List<Pedido> buscarPorFechaEntre(String fechaInicio, String fechaFinal);
}
