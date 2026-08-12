package com.example.demoAuvin.anotacaofavorito.repositories;

import com.example.demoAuvin.anotacaofavorito.entities.AnotacaoFavorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnotacaoFavRepository extends JpaRepository<UUID, AnotacaoFavorito> {


    @Query(value = "SELECT")
    public saveOrUpdate(UUID id);

}
