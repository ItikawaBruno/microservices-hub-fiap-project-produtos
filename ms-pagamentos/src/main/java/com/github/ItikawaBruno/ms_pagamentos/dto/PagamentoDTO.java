package com.github.ItikawaBruno.ms_pagamentos.dto;

import com.github.ItikawaBruno.ms_pagamentos.entities.Pagamento;
import com.github.ItikawaBruno.ms_pagamentos.entities.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PagamentoDTO {

    private Long id;

    @NotNull(message = "O campo valor é requerido")
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valor;

    @NotBlank(message = "O campo nome é obrigatorio")
    @Size(min = 3, max = 50, message = "O nome deve ter de 3 a 50 caracteres")
    private String nome;

    @NotBlank(message = "O campo nome é obrigatorio")
    @Size(min = 16, max = 16, message = "O nome deve ter 16 caracteres")
    private String numeroCartao;

    @NotBlank(message = "O campo validade é obrigatorio")
    @Size(min = 5, max = 5, message = "O nome deve ter 5 caracteres")
    private String validade;

    @NotBlank(message = "O campo codigo de segurança é obrigatorio")
    @Size(min = 3, max = 3, message = "O nome deve ter 3 caracteres")
    private String codigoSeguranca;

    private Status status;

    @NotNull(message = "O campo ID do pedido é obrigatório")
    private Long pedidoId;

    public PagamentoDTO(Pagamento pagamento) {
        id = pagamento.getId();
        valor = pagamento.getValor();
        nome = pagamento.getNome();
        numeroCartao = pagamento.getNumeroCartao();
        validade = pagamento.getValidade();
        codigoSeguranca = pagamento.getCodigoSeguranca();
        status = Status.CRIADO;
        pedidoId = pagamento.getPedidoId();
    }
}
