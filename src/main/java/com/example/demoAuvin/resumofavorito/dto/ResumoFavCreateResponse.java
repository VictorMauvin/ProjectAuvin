package com.example.demoAuvin.resumofavorito.dto;

import com.example.demoAuvin.resumo.entities.Resumo;

import java.util.UUID;

public record ResumoFavCreateResponse(
        Resumo resumo,
        boolean favorito

) {
}
