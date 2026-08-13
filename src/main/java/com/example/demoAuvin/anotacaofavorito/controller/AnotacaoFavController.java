package com.example.demoAuvin.anotacaofavorito.controller;

import com.example.demoAuvin.anotacao.entities.Anotacao;
import com.example.demoAuvin.anotacao.services.AnotacaoService;
import com.example.demoAuvin.anotacaofavorito.dto.AnotacaoFavAddResponse;
import com.example.demoAuvin.anotacaofavorito.services.AnotacaoFavService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/anotacoes")
public class AnotacaoFavController {

    AnotacaoFavService anotacaoFavService;
    AnotacaoService anotacaoService;

    public AnotacaoFavController(AnotacaoService anotacaoService, AnotacaoFavService anotacaoFavService) {
        this.anotacaoService = anotacaoService;
        this.anotacaoFavService = anotacaoFavService;
    }

    @PostMapping("/{id}/favoritos")
    public ResponseEntity<?> addFavorito(@PathVariable("id") UUID id){
        return ResponseEntity.ok(anotacaoFavService.addFavorito(id));
    }
}
