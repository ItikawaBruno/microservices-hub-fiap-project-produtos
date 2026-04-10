package com.github.ItikawaBruno.ms_pagamentos.controller;

import com.github.ItikawaBruno.ms_pagamentos.dto.PagamentoDTO;
import com.github.ItikawaBruno.ms_pagamentos.service.PagamentoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> getProduto(@PathVariable Long id){
        PagamentoDTO dto = service.findPagamentoById(id);

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> getAll(){
        List<PagamentoDTO> pagamentos = service.listPagamentos();
        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> create(@RequestBody PagamentoDTO dto){
        PagamentoDTO pagamentoDTO = service.createPagamento(dto);

        return ResponseEntity.ok(pagamentoDTO);
    }

}
