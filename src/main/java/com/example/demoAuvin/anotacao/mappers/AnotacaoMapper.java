package com.example.demoAuvin.anotacao.mappers;

import com.example.demoAuvin.anotacao.dto.AnotacaoCreateResponse;
import com.example.demoAuvin.anotacao.entities.Anotacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnotacaoMapper {

    @Mapping(source = "anotacao.id", target = "id")
    @Mapping(source = "anotacao.resumo.titulo", target = "titulo")
    @Mapping(source = "anotacao.resumo.conteudo", target = "conteudo")
    @Mapping(source = "anotacao.dt_criacao", target = "dataCriacao")
    @Mapping(source = "favorito", target = "favorita")
    AnotacaoCreateResponse toAnotacaoCreateResponse(Anotacao anotacao, boolean favorito);
}
