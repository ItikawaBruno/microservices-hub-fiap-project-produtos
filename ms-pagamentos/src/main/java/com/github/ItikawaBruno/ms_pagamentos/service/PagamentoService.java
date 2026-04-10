package com.github.ItikawaBruno.ms_pagamentos.service;

import com.github.ItikawaBruno.ms_pagamentos.dto.PagamentoDTO;
import com.github.ItikawaBruno.ms_pagamentos.entities.Pagamento;
import com.github.ItikawaBruno.ms_pagamentos.exceptions.ResourceNotFoundException;
import com.github.ItikawaBruno.ms_pagamentos.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Transactional(readOnly = true)
    public PagamentoDTO createPagamento(PagamentoDTO dto){
        Pagamento pagamento = new Pagamento();
        pagamento.setNome(dto.getNome());
        pagamento.setValor(dto.getValor());
        pagamento.setValidade(dto.getValidade());
        pagamento.setPedidoId(dto.getPedidoId());
        pagamento.setCodigoSeguranca(dto.getCodigoSeguranca());
        pagamento.setNumeroCartao(dto.getNumeroCartao());

        repository.save(pagamento);

        return dto;

    }

    @Transactional
    public PagamentoDTO findPagamentoById(Long id){

        Pagamento pagamento = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado com ID: "+id));

        return new PagamentoDTO(pagamento);
    }


    @Transactional
    public List<PagamentoDTO> listPagamentos(){
        return repository.findAll().stream().map(PagamentoDTO::new).toList();
    }


    @Transactional
    public PagamentoDTO updatePagamento(PagamentoDTO dto, Long id) {
        Pagamento pagamento = repository.getReferenceById(id);

        if(pagamento == null){
            throw new ResourceNotFoundException("Recurso não encontrdo com ID: "+id);
        }

        pagamento.setNome(dto.getNome());
        pagamento.setValor(dto.getValor());
        pagamento.setValidade(dto.getValidade());
        pagamento.setPedidoId(dto.getPedidoId());
        pagamento.setCodigoSeguranca(dto.getCodigoSeguranca());
        pagamento.setNumeroCartao(dto.getNumeroCartao());

        pagamento = repository.save(pagamento);

        return new PagamentoDTO(pagamento);
    }
}
