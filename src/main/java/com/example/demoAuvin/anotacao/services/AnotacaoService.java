package com.example.demoAuvin.anotacao.services;

import com.example.demoAuvin.anotacao.dto.AnotacaoCreateRequest;
import com.example.demoAuvin.anotacao.dto.AnotacaoCreateResponse;
import com.example.demoAuvin.anotacao.entities.Anotacao;
import com.example.demoAuvin.anotacao.mappers.AnotacaoMapper;
import com.example.demoAuvin.anotacao.repositories.AnotacaoRepository;
import com.example.demoAuvin.anotacaofavorito.repositories.AnotacaoFavRepository;
import com.example.demoAuvin.resumo.entities.Resumo;
import com.example.demoAuvin.resumo.repositories.ResumoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AnotacaoService {

    private AnotacaoRepository anotacaoRepository;
    private AnotacaoFavRepository anotacaoFavRepository;
    private ResumoRepository resumoRepository;
    private AnotacaoMapper anotacaoMapper;

    public AnotacaoService(AnotacaoRepository anotacaoRepository, AnotacaoFavRepository anotacaoFavRepository, ResumoRepository resumoRepository, AnotacaoMapper anotacaoMapper) {
        this.anotacaoRepository = anotacaoRepository;
        this.anotacaoFavRepository = anotacaoFavRepository;
        this.resumoRepository = resumoRepository;
        this.anotacaoMapper = anotacaoMapper;
    }

    public AnotacaoCreateResponse create(UUID id, AnotacaoCreateRequest body){

        Anotacao anotacao = new Anotacao();
        Resumo resumo = resumoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resumo não encontrado"));
        if(resumo != null){
            anotacao.setTexto(body.texto());
            anotacao.setDt_criacao(LocalDateTime.now());
            anotacao.setResumo(resumo);
            anotacao = anotacaoRepository.save(anotacao);

            return anotacaoMapper.toAnotacaoCreateResponse(anotacao);
        }else{
            return null;
        }
    }

    public Anotacao findAnotacao(UUID id){
        Anotacao anotacao =  anotacaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Anotação não encontrada"));

        return anotacao;

    }

}
