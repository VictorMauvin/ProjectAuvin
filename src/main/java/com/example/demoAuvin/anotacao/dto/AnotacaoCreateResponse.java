package com.example.demoAuvin.anotacao.dto;

import com.example.demoAuvin.resumo.entities.Resumo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


//Pensamos em usar o objeto inteiro de resumo, mas chegamos nessa opcao, idem ambas

public record AnotacaoCreateResponse(
        String titulo,
        String conteudo,
        UUID idAnotacao,
        String texto,
        LocalDateTime dt_criacao
) {}
