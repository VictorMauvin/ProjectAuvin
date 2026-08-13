package com.example.demoAuvin.resumo.controllers;
import com.example.demoAuvin.resumo.dto.ResumoCreateRequest;
import com.example.demoAuvin.resumo.services.ResumoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.UUID;

@RestController
@RequestMapping("/api/resumos")
public class ResumoController {
    private ResumoService resumoService;

    public ResumoController(ResumoService rService){
        this.resumoService = rService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ResumoCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(resumoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok(resumoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") UUID id, @RequestBody ResumoCreateRequest body) {
        return ResponseEntity.ok(resumoService.update(id, body));
    }

    @GetMapping
    public ResponseEntity<?> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(resumoService.findAll(pageable));
    }

    @GetMapping("/{id}/anotacoes")
    public ResponseEntity<?> listOrdenada(@PathVariable("id") UUID id){

        return ResponseEntity.ok(resumoService.findAllAnotacoesResumo(id));
    }
}
