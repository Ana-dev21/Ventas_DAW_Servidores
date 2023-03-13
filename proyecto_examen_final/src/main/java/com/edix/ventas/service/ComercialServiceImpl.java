package com.edix.ventas.service;

import com.edix.ventas.beans.Comercial;
import com.edix.ventas.repository.ComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ComercialServiceImpl implements ComercialService{

    @Autowired
    private ComercialRepository cRepo;

    /**
     * Función que devuelve todos los comerciales
     * @return List<Comercial>
     */
    @Override
    public List<Comercial> verTodos() {
        return cRepo.findAll();
    }

    /**
     * Función que devuelve un comercial por su id
     * @param idComercial ID del comercial a buscar
     * @return Comercial
     */
    @Override
    public Comercial buscarPorId(int idComercial) {
        return cRepo.findById(idComercial).orElse(null);
    }

    /**
     * Función que devuelve un comercial por su nombre
     * @param nombre Nombre del comercial a buscar
     * @return Comercial
     */
    @Override
    public Comercial buscarPorNombre(String nombre) {
        return cRepo.findByNombre(nombre);
    }

    /**
     * Función que devuelve el total de las ventas por comercial
     * @param idComercial ID del comercial a buscar
     * @return double
     */
    @Override
    public double totalVentasPorComercial(int idComercial) {
        return cRepo.totalVentasPorComercial(idComercial);
    }


    /**
     * Función que devuelve todos los comerciales que tienen una comisión mayor a la pasada por parámetro
     * @param comision Comisión mínima a buscar
     * @return List<Comercial>
     */
    @Override
    public List<Comercial> buscarPorComisionMayor(double comision) {

        return cRepo.findByComisionGreaterThan(comision);
    }

}
