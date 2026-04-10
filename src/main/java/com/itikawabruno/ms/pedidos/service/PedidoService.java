package com.itikawabruno.ms.pedidos.service;

import com.itikawabruno.ms.pedidos.dto.ItemDoPedidoDTO;
import com.itikawabruno.ms.pedidos.dto.PedidoDTO;
import com.itikawabruno.ms.pedidos.entities.ItemPedido;
import com.itikawabruno.ms.pedidos.entities.Pedido;
import com.itikawabruno.ms.pedidos.entities.Status;
import com.itikawabruno.ms.pedidos.exceptions.ResourceNotFoundException;
import com.itikawabruno.ms.pedidos.repository.PedidoRepositoy;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepositoy pedidoRepositoy;

    @Transactional(readOnly = true)
    public List<PedidoDTO> findAllPedidos(){
        return pedidoRepositoy.findAll().stream().map(PedidoDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PedidoDTO findPedidoById(Long id){
        Pedido pedido = pedidoRepositoy.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com ID: "+id));
        return new PedidoDTO(pedido);
    }

    @Transactional
    public PedidoDTO createPedido(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setData(LocalDate.now());
        pedido.setStatus(Status.CRIADO);
        mepDTOtoPedido(dto, pedido);
        pedido.calcularValorTotalDoPedido();
        pedido = pedidoRepositoy.save(pedido);
        return new PedidoDTO(pedido);
    }

    @Transactional
    public PedidoDTO updatePedido(PedidoDTO dto, Long id){
        try{
            Pedido pedido = pedidoRepositoy.getReferenceById(id);
            pedido.setData(LocalDate.now());
            pedido.setStatus(Status.CRIADO);
            mepDTOtoPedido(dto, pedido);
            pedido.calcularValorTotalDoPedido();
            pedido = pedidoRepositoy.save(pedido);
            return new PedidoDTO(pedido);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado com ID: "+id);
        }

    }

    @Transactional
    public void deletePedidoById(Long id){
        if (!pedidoRepositoy.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado. ID: "+id);
        }

        pedidoRepositoy.deleteById(id);
    }

    private void mepDTOtoPedido(PedidoDTO dto, Pedido pedido) {
        pedido.setNome(dto.getNome());
        pedido.setCpf(dto.getCpf());
        for (ItemDoPedidoDTO itemPedido : dto.getItens()){
            ItemPedido item = new ItemPedido();
            item.setDescricao(itemPedido.getDescricao());
            item.setQuantidade(itemPedido.getQuantidade());
            item.setPedido(pedido);
            item.setPrecoUnitario(itemPedido.getPrecoUnitario());
            pedido.getItens().add(item);
        }
    }
}
