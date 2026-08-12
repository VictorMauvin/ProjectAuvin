package com.example.demoAuvin.anotacao.controller;

import com.example.demoAuvin.anotacao.dto.AnotacaoCreateRequest;
import com.example.demoAuvin.anotacao.repositories.AnotacaoRepository;
import com.example.demoAuvin.anotacao.services.AnotacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/resumos")
public class AnotacaoController {


    private AnotacaoService anotacaoService;

    public AnotacaoController(AnotacaoService anotacaoService){
        this.anotacaoService = anotacaoService;
    }

    @PostMapping("/{id}/anotacoes")
    public ResponseEntity<?> create(@PathVariable("id") UUID id, @RequestBody AnotacaoCreateRequest body){
        return ResponseEntity.status(HttpStatus.CREATED).body(anotacaoService.create(id,body));
    }

}
