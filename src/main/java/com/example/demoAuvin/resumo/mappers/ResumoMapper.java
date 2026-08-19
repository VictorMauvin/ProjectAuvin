package com.example.demoAuvin.resumo.mappers;

import com.example.demoAuvin.resumo.dto.ResumoFindFavResponse;
import com.example.demoAuvin.resumo.dto.ResumoListResponse;
import com.example.demoAuvin.resumo.dto.ResumoSaveResponse;
import com.example.demoAuvin.resumo.entities.Resumo;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ResumoMapper {
    ResumoSaveResponse toResumoSaveResponse(Resumo resumo);
    ResumoListResponse toResumoListResponse(Resumo resumo,boolean favorito);
}