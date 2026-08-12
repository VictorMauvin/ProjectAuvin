package com.example.demoAuvin.anotacaofavorito.entities;

import com.example.demoAuvin.anotacao.entities.Anotacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anotacao_fav")
public class AnotacaoFavorito {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "status")
    private boolean status;

    @Column(name = "usuario_id")
    private int usuario_id;

    @ManyToOne
    @JoinColumn(name = "anotacao_id")
    private Anotacao anotacao;


}
