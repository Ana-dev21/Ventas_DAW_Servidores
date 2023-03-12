package com.edix.ventas.service;

import com.edix.ventas.beans.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> verTodos();

    Pedido buscarPorId(int idPedido);

    List<Pedido> pedidosPorCliente(int idCliente);
}
