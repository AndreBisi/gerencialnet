package br.com.gerencialnet.domain.logradouro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoLogradouroDTO(
        @NotNull
        Long id,
        
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        
        String abreviacao) {
}
