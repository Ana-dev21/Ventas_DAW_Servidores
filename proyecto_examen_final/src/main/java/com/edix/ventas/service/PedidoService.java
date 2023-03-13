package com.edix.ventas.service;

import com.edix.ventas.beans.Pedido;

import java.util.List;

public interface PedidoService {

    List<Pedido> buscarTodos();
    Pedido buscarUno(int idPedido);
    List<Pedido> buscarPorCliente(int idCliente);
    List<Pedido> buscarPorComercial(int idComercial);
    Pedido darAlta(Pedido pedido);
    boolean eliminarPedido(int idPedido);


}
