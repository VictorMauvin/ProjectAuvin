package com.example.demoAuvin.resumo.mappers;

import com.example.demoAuvin.resumo.dto.ResumoSaveResponse;
import com.example.demoAuvin.resumo.entities.Resumo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResumoMapper {
    ResumoSaveResponse toResumoSaveResponse(Resumo resumo);
}