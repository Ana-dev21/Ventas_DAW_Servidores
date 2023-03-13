package com.edix.ventas.repository;

import com.edix.ventas.beans.Comercial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ComercialRepository extends JpaRepository<Comercial, Integer> {

    Comercial findByNombre(String nombre);

    @Query("SELECT SUM(p.total) FROM Pedido p WHERE p.comercial.idComercial = :idComercial")
    double totalVentasPorComercial(int idComercial);

    @Query("SELECT c FROM Comercial c WHERE c.comision > :comision")
    List<Comercial> findByComisionGreaterThan(Double comision);
}
