package com.example.demoAuvin.anotacao.entities;


import com.example.demoAuvin.resumo.entities.Resumo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.mapping.Join;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "anotacao")
public class Anotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name = "texto")
    private String texto;

    @Column(nullable = false, name = "dt_criacao")
    @CreationTimestamp
    private LocalDateTime dt_criacao;

    @ManyToOne
    @JoinColumn(name = "resumo_id")
    private Resumo resumo;


}
