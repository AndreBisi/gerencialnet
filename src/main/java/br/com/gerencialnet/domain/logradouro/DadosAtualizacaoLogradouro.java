package br.com.gerencialnet.domain.logradouro;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoLogradouro(
        @NotNull
        Long id,
        String nome,
        String abreviacao) {
}
