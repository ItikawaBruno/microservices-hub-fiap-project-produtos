package com.itikawabruno.ms.pedidos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PedidoDTO (String nome, String cpf, LocalDate data, BigDecimal valorTotal){
}
