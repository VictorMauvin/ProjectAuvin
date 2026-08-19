package com.example.demoAuvin.resumo.services;

import com.example.demoAuvin.resumo.dto.*;
import com.example.demoAuvin.resumo.entities.Resumo;
import com.example.demoAuvin.resumo.mappers.ResumoMapper;
import com.example.demoAuvin.resumo.repositories.ResumoRepository;
import com.example.demoAuvin.resumofavorito.entities.Resumo_Favorito;
import com.example.demoAuvin.resumofavorito.repositories.ResumoFavRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service

public class ResumoService {
    private ResumoRepository resumoRepository;
    private ResumoMapper resumoMapper;
    private ResumoFavRepository resumoFavRepository;

    public ResumoService(ResumoRepository resumoRepository,ResumoMapper resumoMapper, ResumoFavRepository resumoFavRepository){
        this.resumoFavRepository = resumoFavRepository;
        this.resumoRepository = resumoRepository;
        this.resumoMapper = resumoMapper;
    }

    @Transactional
    public ResumoSaveResponse create(ResumoCreateRequest request){
        Resumo resumo = new Resumo();

        if(request.titulo() != null && request.conteudo() != null){
            resumo.setConteudo(request.conteudo());
            resumo.setTitulo(request.titulo());
            resumo.setDt_criacao(LocalDateTime.now());
            resumo = resumoRepository.save(resumo);

            return resumoMapper.toResumoSaveResponse(resumo);
        }

        return null;
    }

    public ResumoListResponse findById(UUID id) {
        Resumo resumo = resumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resumo não encontrado"));

        Resumo_Favorito res = resumoFavRepository.findByResumo_id(resumo.getId());
        boolean favorito = false;
        if (res != null) {
            favorito = res.isStatus();
        }

        return resumoMapper.toResumoListResponse(resumo,favorito);
//        return resumoMapper.toResumoFindFavResonse(resumo, favorito);
    }

    @Transactional
    public ResumoSaveResponse update(UUID id, ResumoCreateRequest body) {
        Resumo resumo = resumoRepository.findById(id).orElse(null);

        if (resumo != null) {
            if (body.titulo() != null) {
                resumo.setTitulo(body.titulo());

            }

            if (body.conteudo() != null) {
                resumo.setConteudo(body.conteudo());
            }

            resumo = resumoRepository.save(resumo);

            return resumoMapper.toResumoSaveResponse(resumo);
        }

        return null;
    }

    public Page<ResumoListResponse> findAll(Pageable pageable) {
        return resumoRepository.findAll(pageable)
                .map(resumo -> new ResumoListResponse(
                        resumo.getId(),
                        resumo.getTitulo(),
                        resumo.getConteudo(),
                        resumo.getDt_criacao(),
                        resumoFavRepository.existsByResumo_IdAndStatusTrue(resumo.getId())
                ));
    }

    public List<ResumoAnotacaoResponse> findAllAnotacoesResumo(UUID id) {
        return resumoRepository.findAllAnotacoesResumo(id);
    }
}
