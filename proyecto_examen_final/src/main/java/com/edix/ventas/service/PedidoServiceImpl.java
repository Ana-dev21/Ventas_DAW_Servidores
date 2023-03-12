package com.edix.ventas.service;

import com.edix.ventas.beans.Pedido;
import com.edix.ventas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pRepo;

    /**
     * Función que devuelve todos los pedidos
     * @return List<Pedido>
     */
    @Override
    public List<Pedido> verTodos() {
        return pRepo.findAll();
    }

    /**
     * Función que devuelve un pedido por su id
     * @param idPedido
     * @return Pedido
     */
    @Override
    public Pedido buscarPorId(int idPedido) {
        return pRepo.findById(idPedido).get();
    }

    /**
     * Función que devuelve todos los pedidos realizados por un cliente específico
     * @param idCliente
     * @return List<Pedido>
     */
    @Override
    public List<Pedido> buscarPorCliente(int idCliente) {
        return pRepo.findByCliente(idCliente);
    }

    /**
     * Función que devuelve todos los pedidos realizados en una fecha específica
     * @param fecha
     * @return List<Pedido>
     */
    @Override
    public List<Pedido> pedidosPorFecha(String fecha) {
        return pRepo.findByFecha(fecha);
    }

    /**
     * Función que devuelve todos los pedidos realizados por un comercial
     * @param idComercial
     * @return List<Pedido>
     */
    @Override
    public List<Pedido> pedidosPorComercial(int idComercial) {
        return pRepo.findByComercial(idComercial);
    }

}
