package com.example.demoAuvin.resumo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResumoFindFavResponse(

        UUID id,
        String titulo,
        String conteudo,
        LocalDateTime dt_criacao,
        boolean favorito
) {


}