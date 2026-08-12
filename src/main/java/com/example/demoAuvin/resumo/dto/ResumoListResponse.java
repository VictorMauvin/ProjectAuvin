package com.example.demoAuvin.resumo.dto;

import java.time.LocalDateTime;

public record ResumoListResponse(
        String titulo,
        String conteudo,
        LocalDateTime dt_criacao
) {
}
