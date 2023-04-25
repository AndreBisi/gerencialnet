package br.com.gerencialnet.domain.logradouro;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroLogradouro(

        @NotBlank(message = "O nome é obrigatório")
        String nome,

        String abreviacao) {
}
