package com.v8tech.desafio_loja_moveis.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientDTO(
        @NotBlank
        String cpf,
        @NotBlank
        String name,
        @NotNull
        @Valid
        String contact
) {
}
