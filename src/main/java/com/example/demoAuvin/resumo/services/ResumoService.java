package com.example.demoAuvin.resumo.services;

import com.example.demoAuvin.resumo.dto.ResumoCreateRequest;
import com.example.demoAuvin.resumo.dto.ResumoSaveResponse;
import com.example.demoAuvin.resumo.entities.Resumo;
import com.example.demoAuvin.resumo.mappers.ResumoMapper;
import com.example.demoAuvin.resumo.repositories.ResumoRepository;
import com.example.demoAuvin.resumo.repositories.ResumoRepository;
import jakarta.transaction.Transactional;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service

public class ResumoService {

    private ResumoRepository rRepository;
    private ResumoMapper rMapper;

    public ResumoService(ResumoRepository resumoRepository,ResumoMapper resumoMapper){
        this.rRepository = resumoRepository;
        this.rMapper = resumoMapper;
    }

    @Transactional
    public ResumoSaveResponse create(ResumoCreateRequest request){
        Resumo resumo = new Resumo();

        if(request.titulo() != null && request.conteudo() != null){
            resumo.setConteudo(request.conteudo());
            resumo.setTitulo(request.titulo());
            resumo.setDt_criacao(LocalDateTime.now());
            resumo = rRepository.save(resumo);

            return rMapper.toResumoSaveResponse(resumo);
        }

        return null;
    }

    @Transactional
    public ResumoSaveResponse findById(UUID id) {
        Resumo resumo = rRepository.findById(id)
                .orElseThrow(null);
        return rMapper.toResumoSaveResponse(resumo);
    }

    public ResumoSaveResponse update(UUID id, ResumoCreateRequest body) {
        Resumo resumo = rRepository.findById(id).orElse(null);

        if (resumo != null) {
            if (body.titulo() != null) {
                resumo.setTitulo(body.titulo());
            }

            if (body.conteudo() != null) {
                resumo.setConteudo(body.conteudo());
            }

            resumo = rRepository.save(resumo);

            return rMapper.toResumoSaveResponse(resumo);
        }

        return null;
    }
}
