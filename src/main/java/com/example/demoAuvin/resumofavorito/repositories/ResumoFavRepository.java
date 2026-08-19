package com.example.demoAuvin.resumofavorito.repositories;

import com.example.demoAuvin.resumofavorito.entities.Resumo_Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResumoFavRepository extends JpaRepository<Resumo_Favorito, UUID> {

    Resumo_Favorito findByResumo_id(UUID id);
    boolean existsByResumo_IdAndStatusTrue(UUID resumoId);

    @Modifying
    @Query("delete from Resumo_Favorito rf where rf.resumo.id = :resumoId")
    void deleteByResumoId(@Param("resumoId") UUID resumoId);
}
