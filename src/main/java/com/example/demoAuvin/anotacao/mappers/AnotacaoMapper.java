package com.example.demoAuvin.anotacao.mappers;

import com.example.demoAuvin.anotacao.dto.AnotacaoCreateResponse;
import com.example.demoAuvin.anotacao.entities.Anotacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnotacaoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "resumo.titulo", target = "titulo")
    @Mapping(source = "resumo.conteudo", target = "conteudo")
    @Mapping(source = "dt_criacao", target = "dataCriacao")
    @Mapping(target = "favorita", constant = "false")
    AnotacaoCreateResponse toAnotacaoCreateResponse(Anotacao anotacao);
}