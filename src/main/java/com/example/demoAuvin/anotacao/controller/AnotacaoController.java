package com.example.demoAuvin.anotacao.controller;

import com.example.demoAuvin.anotacao.dto.AnotacaoCreateRequest;
import com.example.demoAuvin.anotacao.services.AnotacaoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/resumos")
@CrossOrigin("*")
public class AnotacaoController {


    private AnotacaoService anotacaoService;

    public AnotacaoController(AnotacaoService anotacaoService){
        this.anotacaoService = anotacaoService;
    }

    @PostMapping("/{id}/anotacoes")
    public ResponseEntity<?> create(@PathVariable("id") UUID id, @RequestBody AnotacaoCreateRequest body){
        return ResponseEntity.status(HttpStatus.CREATED).body(anotacaoService.create(id,body));
    }

    @DeleteMapping("/{id}/anotacoes")
    public ResponseEntity<?> delete(@PathVariable("id") UUID id){
        return ResponseEntity.ok(anotacaoService.delete(id));
    }

    @PutMapping("/{id}/anotacoes")
    public ResponseEntity<?>update(@PathVariable("id") UUID id, @RequestParam("texto") String texto){
        return ResponseEntity.ok(anotacaoService.update(id,texto));
    }

}
