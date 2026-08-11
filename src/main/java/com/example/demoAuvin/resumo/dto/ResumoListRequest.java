package com.example.demoAuvin.resumo.dto;

import java.util.List;

public record ResumoListRequest(
        List<ResumoSaveResponse> listarAll
) {
}
