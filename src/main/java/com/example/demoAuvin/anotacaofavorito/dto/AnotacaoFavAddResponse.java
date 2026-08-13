package com.example.demoAuvin.anotacaofavorito.dto;

import java.util.UUID;

public record AnotacaoFavAddResponse(
        UUID id_anotacao,
        boolean favorito
) {
}
