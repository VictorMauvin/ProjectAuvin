package com.example.demoAuvin.resumofavorito.controller;


import com.example.demoAuvin.resumofavorito.dto.ResumoFavCreateResponse;
import com.example.demoAuvin.resumofavorito.services.ResumoFavService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/resumos")
public class ResumoFavController {

    ResumoFavService resumoFavService;

    public ResumoFavController(ResumoFavService resumoFavService){
        this.resumoFavService = resumoFavService;
    }

    @PostMapping("/{id}/favoritos")
    public ResponseEntity<?> addFavorito(@PathVariable("id") UUID id){

        return ResponseEntity.ok(resumoFavService.addFavorito(id));


    }




}
