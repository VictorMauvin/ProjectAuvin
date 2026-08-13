package com.example.demoAuvin.resumofavorito.entities;

import com.example.demoAuvin.resumo.entities.Resumo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resumo_fav")
public class Resumo_Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "status")
    private boolean status;


    @Column(name = "usuario_id")
    private int usuarioId;

    @OneToOne
    @JoinColumn(name = "resumo_id")
    private Resumo resumo;
}
