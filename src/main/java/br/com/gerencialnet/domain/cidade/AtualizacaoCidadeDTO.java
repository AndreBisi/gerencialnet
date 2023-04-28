package br.com.gerencialnet.domain.cidade;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoCidadeDTO(
		@NotNull
		Long id,
		
		@NotNull
		String nome,
		
		@NotNull
		String uf,
		
		String ibge	) {
}
