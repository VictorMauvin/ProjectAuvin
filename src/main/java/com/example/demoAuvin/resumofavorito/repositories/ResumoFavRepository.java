package com.example.demoAuvin.resumofavorito.repositories;

import com.example.demoAuvin.resumofavorito.entities.Resumo_Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResumoFavRepository extends JpaRepository<Resumo_Favorito, UUID> {

    Resumo_Favorito findByResumo_id(UUID id);

}
