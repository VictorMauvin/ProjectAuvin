package com.example.demoAuvin.anotacao.mappers;

import com.example.demoAuvin.anotacao.dto.AnotacaoCreateResponse;
import com.example.demoAuvin.anotacao.entities.Anotacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnotacaoMapper {


    //Pensamos em usar o objeto inteiro de resumo, mas chegamos nessa opcao, idem ambas

    @Mapping(source = "id", target = "idAnotacao")
    @Mapping(source = "resumo.titulo", target = "titulo")
    @Mapping(source = "resumo.conteudo", target = "conteudo")
    AnotacaoCreateResponse toAnotacaoCreateResponse(Anotacao anotacao);
}
