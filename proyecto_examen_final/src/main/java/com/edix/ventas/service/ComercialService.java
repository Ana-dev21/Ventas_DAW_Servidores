package com.edix.ventas.service;

import com.edix.ventas.beans.Comercial;

import java.util.List;

public interface ComercialService {
    List<Comercial> buscarTodos();
    Comercial buscarUno(int idComercial);
    List<Comercial> conComision(double comision);
    List<Comercial> atiendeCliente(int idCliente);
    List<Comercial> comercialConPedido(int idPedido);
    Comercial addComercial(Comercial comercial);
    Boolean eliminarComercial(int idComercial);
    Comercial modificarComercial(Comercial comercial);
}
