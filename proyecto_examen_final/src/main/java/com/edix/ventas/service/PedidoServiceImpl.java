package com.edix.ventas.service;

import com.edix.ventas.beans.Pedido;
import com.edix.ventas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository peRepo;

    @Override
    public List<Pedido> buscarTodos() {
        return peRepo.findAll();
    }
    @Override
    public Pedido buscarUno(int idPedido) {
        return peRepo.findById(idPedido).orElse(null);
    }
    @Override
    public List<Pedido> buscarPorCliente(int idCliente) {
        return peRepo.buscarPorCliente(idCliente);
    }
    @Override
    public List<Pedido> buscarPorComercial(int idComercial) {
        return peRepo.buscarPorComercial(idComercial);
    }
    @Override
    public Pedido darAlta(Pedido pedido) {
            peRepo.save(pedido);
            return pedido;
    }
    @Override
    public boolean eliminarPedido(int idPedido) {
        Pedido p = peRepo.findById(idPedido).orElse(null);
        if(p != null) {
            peRepo.deleteById(p.getIdPedido());
            return true;
        }
        return false;
    }
}
