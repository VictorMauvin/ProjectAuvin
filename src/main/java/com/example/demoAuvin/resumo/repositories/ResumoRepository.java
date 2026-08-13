package com.example.demoAuvin.resumo.repositories;

import com.example.demoAuvin.anotacao.entities.Anotacao;
import com.example.demoAuvin.resumo.dto.ResumoAnotacaoResponse;
import com.example.demoAuvin.resumo.entities.Resumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResumoRepository extends JpaRepository<Resumo, UUID> {

    @Query("""
    SELECT
        a.id,
        a.texto,
        a.dt_criacao,
        COALESCE(af.status, false)
    FROM Anotacao a
    LEFT JOIN AnotacaoFavorito af ON af.anotacao = a
    WHERE a.resumo.id = :id
    ORDER BY
        COALESCE(af.status, false) DESC,
        a.dt_criacao DESC
""")
    List<ResumoAnotacaoResponse> findAllAnotacoesResumo(UUID id);
}

