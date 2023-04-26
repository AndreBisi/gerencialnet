package br.com.gerencialnet.domain.logradouro;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoLogradouroDTO(
        @NotNull
        Long id,
        String nome,
        String abreviacao) {
}
