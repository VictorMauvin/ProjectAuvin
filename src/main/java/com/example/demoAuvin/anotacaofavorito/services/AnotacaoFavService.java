package com.example.demoAuvin.anotacaofavorito.services;

import com.example.demoAuvin.anotacao.entities.Anotacao;
import com.example.demoAuvin.anotacao.services.AnotacaoService;
import com.example.demoAuvin.anotacaofavorito.dto.AnotacaoFavAddResponse;
import com.example.demoAuvin.anotacaofavorito.entities.AnotacaoFavorito;
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
        if (anotacao != null) {
            AnotacaoFavorito favorita = anotacaoFavRepository.findByAnotacao_Id(id);
            if (favorita != null) {
                favorita.setStatus(!favorita.isStatus());
            } else {
                favorita = new AnotacaoFavorito();
                favorita.setAnotacao(anotacao);
                favorita.setUsuarioId(1);
                favorita.setStatus(true);
            }

            favorita = anotacaoFavRepository.save(favorita);
            return new AnotacaoFavAddResponse(
                    id,
                    favorita.isStatus()
            );
        }

        return null;
    }
}
