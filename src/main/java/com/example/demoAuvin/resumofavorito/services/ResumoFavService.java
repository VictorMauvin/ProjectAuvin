package com.example.demoAuvin.resumofavorito.services;


import com.example.demoAuvin.resumo.entities.Resumo;

import com.example.demoAuvin.resumo.repositories.ResumoRepository;
import com.example.demoAuvin.resumofavorito.dto.ResumoFavCreateResponse;
import com.example.demoAuvin.resumofavorito.entities.Resumo_Favorito;
import com.example.demoAuvin.resumofavorito.repositories.ResumoFavRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ResumoFavService {

    ResumoFavRepository resumoFavRepository;
    ResumoRepository resumoRepository;
    public ResumoFavService(ResumoFavRepository resumoFavRepository,  ResumoRepository resumoRepository){
        this.resumoFavRepository = resumoFavRepository;
        this.resumoRepository = resumoRepository;
    }


    public ResumoFavCreateResponse addFavorito(UUID id){
        Resumo resumo = resumoRepository.findById(id).orElseThrow();

        if(resumo != null){
            Resumo_Favorito resumoFav = resumoFavRepository.findByResumo_id(id);
            if(resumoFav != null){
                resumoFav.setStatus(!resumoFav.isStatus());
            }
            else{
                resumoFav = new Resumo_Favorito();
                resumoFav.setResumo(resumo);
                resumoFav.setUsuarioId(1);
                resumoFav.setStatus(true);
            }

            resumoFav = resumoFavRepository.save(resumoFav);

            return new ResumoFavCreateResponse(resumo,resumoFav.isStatus());


        }

        return null;
    }



}
