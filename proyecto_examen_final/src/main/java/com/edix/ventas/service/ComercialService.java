package com.edix.ventas.service;

import com.edix.ventas.beans.Comercial;

import java.util.List;

public interface ComercialService {

    List<Comercial> verTodos();

    Comercial buscarPorId(int idComercial);

    Comercial buscarPorNombre(String nombre);

    double totalVentasPorComercial(int idComercial);

    List<Comercial> buscarPorComisionMayor(double comision);
}
