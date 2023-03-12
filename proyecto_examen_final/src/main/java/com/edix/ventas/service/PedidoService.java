package com.edix.ventas.service;

import com.edix.ventas.beans.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> verTodos();

    Pedido buscarPorId(int idPedido);

    List<Pedido> buscarPorCliente(int idCliente);

    List<Pedido> pedidosPorFecha(String fecha);

    abstract List<Pedido> pedidosPorComercial(int idComercial);
}
