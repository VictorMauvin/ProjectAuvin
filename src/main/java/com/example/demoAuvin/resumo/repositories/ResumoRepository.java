package com.example.demoAuvin.resumo.repositories;

import com.example.demoAuvin.resumo.entities.Resumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResumoRepository extends JpaRepository<Resumo, UUID> {

}
