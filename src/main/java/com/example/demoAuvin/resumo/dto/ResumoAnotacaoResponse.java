package com.example.demoAuvin.resumo.dto;

import java.time.LocalDateTime;
import java.util.UUID;


//DTO para retornar uma LISTA de anotaões vinculado a UM resumo
public record ResumoAnotacaoResponse(
        UUID id,
        String texto,
        LocalDateTime dataCriacao,
        boolean favorita
) {
}