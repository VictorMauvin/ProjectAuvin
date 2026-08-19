package com.example.demoAuvin.anotacao.dto;

import java.time.LocalDateTime;
import java.util.UUID;


//DTO para retornar o vincula da Anotacao com Resumo, por isso titulo e conteudo presentes
public record AnotacaoCreateResponse(
        String titulo,
        String conteudo,
        UUID id,
        String texto,
        LocalDateTime dataCriacao,
        boolean favorita
) {
}