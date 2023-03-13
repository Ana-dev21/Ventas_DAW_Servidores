package com.edix.ventas.service;

import com.edix.ventas.beans.Comercial;
import com.edix.ventas.repository.ComercialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComercialServiceImpl implements ComercialService {

    @Autowired
    ComercialRepository coRepo;

    @Override
    public List<Comercial> buscarTodos() {
        return coRepo.findAll();
    }

    @Override
    public Comercial buscarUno(int idComercial) {
        return coRepo.findById(idComercial).orElse(null);
    }

    @Override
    public List<Comercial> conComision(double comision) {
        return coRepo.conComision(comision);
    }

    @Override
    public List<Comercial> atiendeCliente(int idCliente) {
        return coRepo.comercialesAtiendenClientes(idCliente);
    }

    @Override
    public List<Comercial> comercialConPedido(int idPedido) {
        return coRepo.comercialesConPedidos(idPedido);
    }

    @Override
    public Comercial addComercial(Comercial comercial) {

        Comercial com = buscarUno(comercial.getIdComercial());
        if(com == null)
            return coRepo.save(comercial);
        else
            return null;
    }
    @Override
    public Boolean eliminarComercial(int idComercial) {
        boolean eliminado = false;
        Comercial comercial = buscarUno(idComercial);

        if(comercial != null) {
            coRepo.deleteById(idComercial);
            eliminado = true;
        }
        return eliminado;
    }

    @Override
    public Comercial modificarComercial(Comercial comercial) {
        Comercial com = buscarUno(comercial.getIdComercial());
        try{
            if (com != null)
                coRepo.save(comercial);
            return com;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
