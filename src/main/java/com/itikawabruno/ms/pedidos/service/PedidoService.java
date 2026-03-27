package com.itikawabruno.ms.pedidos.service;

import com.itikawabruno.ms.pedidos.dto.PedidoDTO;
import com.itikawabruno.ms.pedidos.entities.Pedido;
import com.itikawabruno.ms.pedidos.repository.PedidoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositoy pedidoRepositoy;

    @Transactional(readOnly = true)
    public List<PedidoDTO> findAllPedidos(){
        return pedidoRepositoy.findAll().stream().map(PedidoDTO::new).toList();
    }



}
