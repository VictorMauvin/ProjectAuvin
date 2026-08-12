package com.example.demoAuvin.anotacao.repositories;

import com.example.demoAuvin.anotacao.entities.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnotacaoRepository extends JpaRepository<Anotacao, UUID> {
}
