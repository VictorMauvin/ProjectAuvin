package com.example.demoAuvin.anotacaofavorito.repositories;

import com.example.demoAuvin.anotacaofavorito.entities.AnotacaoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnotacaoFavRepository extends JpaRepository<AnotacaoFavorito, UUID> {
    AnotacaoFavorito findByAnotacao_Id(UUID anotacaoId);

    // Esta query remove todos os registros de anotação favorita que pertecem a um resumo
    @Modifying
    @Query("delete from AnotacaoFavorito af where af.anotacao.resumo.id = :resumoId")
    void deleteByResumoId(@Param("resumoId") UUID resumoId);
}
