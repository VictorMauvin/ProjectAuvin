package com.example.demoAuvin.anotacaofavorito.services;

import com.example.demoAuvin.anotacao.entities.Anotacao;
import com.example.demoAuvin.anotacao.services.AnotacaoService;
import com.example.demoAuvin.anotacaofavorito.dto.AnotacaoFavAddResponse;
import com.example.demoAuvin.anotacaofavorito.repositories.AnotacaoFavRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnotacaoFavService {

    AnotacaoService anotacaoService;
    AnotacaoFavRepository anotacaoFavRepository;

    public AnotacaoFavService(AnotacaoService anotacaoService, AnotacaoFavRepository anotacaoFavRepository) {
        this.anotacaoService = anotacaoService;
        this.anotacaoFavRepository = anotacaoFavRepository;
    }

    public AnotacaoFavAddResponse addFavorito(UUID id){
        Anotacao anotacao = anotacaoService.findAnotacao(id);

        if(anotacao != null){
            anotacaoFavRepository.saveOrUpdate(id);
        }
    }
}
