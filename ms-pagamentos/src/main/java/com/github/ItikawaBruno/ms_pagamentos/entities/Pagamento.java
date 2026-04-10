package com.github.ItikawaBruno.ms_pagamentos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String numeroCartao;

    @Column(nullable = false)
    private String validade;

    @Column(nullable = false)
    private String codigoSeguranca;


    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private Long pedidoId;

}
