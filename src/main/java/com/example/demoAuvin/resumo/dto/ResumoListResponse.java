package com.example.demoAuvin.resumo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResumoListResponse(
        UUID id,
        String titulo,
        String conteudo,
        LocalDateTime dataCriacao,
        boolean favorito
) {
}
