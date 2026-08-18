package com.example.demoAuvin.anotacao.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AnotacaoCreateResponse(
        String titulo,
        String conteudo,
        UUID id,
        String texto,
        LocalDateTime dataCriacao,
        boolean favorita
) {
}