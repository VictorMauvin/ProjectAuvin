package com.example.demoAuvin.resumo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumo")
public class Resumo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name="titulo")
    private String titulo;

    @Column(nullable = false, name="conteudo", columnDefinition = "TEXT")
    private String conteudo;

    @CreationTimestamp
    @Column(nullable = false, name = "dt_criacao")
    private LocalDateTime dt_criacao;
}
