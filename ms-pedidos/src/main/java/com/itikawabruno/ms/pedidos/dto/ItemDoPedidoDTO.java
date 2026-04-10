package com.itikawabruno.ms.pedidos.dto;


import com.itikawabruno.ms.pedidos.entities.ItemPedido;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemDoPedidoDTO {

    private Long id;

    @NotNull(message = "Quantidade requerido")
    @Positive(message = "Quantidade não pode ser negativa")
    private Integer quantidade;

    @NotNull(message = "Descrição requerido")
    private String descricao;

    @NotNull(message = "Preço Unitário requerido")
    @Positive(message = "O preço unitário deve ser um valor positivo e maior que zero")
    private BigDecimal precoUnitario;

    public ItemDoPedidoDTO(ItemPedido itemPedido){
        id = itemPedido.getId();
        quantidade = itemPedido.getQuantidade();
        descricao = itemPedido.getDescricao();
        precoUnitario = itemPedido.getPrecoUnitario();
    }
}
