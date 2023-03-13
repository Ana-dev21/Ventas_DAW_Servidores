package com.edix.ventas.service;

import com.edix.ventas.beans.Pedido;
import com.edix.ventas.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
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
     * Función que devuelve todos los pedidos de un cliente, buscando por su nombre o apellidos
     * @param nombre
     * @return List<Pedido>
     */
    @Override
    public List<Pedido> buscarPorNombreCliente(String nombre) {
        return pRepo.findByNombreCliente(nombre);
    }

    /**
     * Función que devuelve todos los pedidos realizados en una fecha específica
     * @param fecha
     * @return List<Pedido>
     */
    @Override
    public List<Pedido> pedidosPorFecha(String fecha) {

        Date out = Date.valueOf(fecha);
        return pRepo.findByFecha(out);
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

    @Override
    /**
     * Inserta un pedido en la base de datos
     * @param pedido Pedido a insertar
     * @return 1 si se inserta correctamente, 0 si no se inserta
     */
    public int hacerPedido(Pedido pedido) {
        int filas = 0;
        try {
            pRepo.save(pedido); filas = 1;
        }catch(Exception e) { e.printStackTrace();
        }
        return filas;
    }

    @Override
    /**
     * Busca los pedidos de un intervalo de fecha en la base de datos
     * @param fechaInicio Fecha de inicio del intervalo.
     * @param fechaFinal Fecha final del intervalo.
     * @return Lista de pedidos realizados entre esa fecha, null si no lo encuentra
     */
    public List<Pedido> buscarPorFechaEntre(String fechaInicio, String fechaFinal) {
        Date out = Date.valueOf(fechaInicio);
        Date out2 = Date.valueOf(fechaFinal);
        return pRepo.findPedidoByFechaBetween(out, out2);
    }


}
