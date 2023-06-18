package br.com.gerencialnet.domain.conexao;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoConexaoDTO(
		@NotNull
		Long id,
		
		@NotNull
		String descricao
		) {

}
