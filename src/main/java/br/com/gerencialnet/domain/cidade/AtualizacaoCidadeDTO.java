package br.com.gerencialnet.domain.cidade;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoCidadeDTO(
		@NotNull
		Long id,
		String nome,
		String uf,
		String ibge	) {
}
