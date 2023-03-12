package com.edix.ventas.repository;

import com.edix.ventas.beans.Comercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComercialRepository extends JpaRepository<Comercial, Integer> {

    Comercial findByNombre(String nombre);

    @Query("SELECT SUM(p.total) FROM Pedido p WHERE p.comercial.idComercial = :idComercial")
    double totalVentasPorComercial(int idComercial);
}
