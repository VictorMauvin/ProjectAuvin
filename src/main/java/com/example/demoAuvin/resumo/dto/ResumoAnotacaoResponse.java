package com.example.demoAuvin.resumo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResumoAnotacaoResponse(
        UUID id,
        String texto,
        LocalDateTime dataCriacao,
        boolean favorita
) {
}