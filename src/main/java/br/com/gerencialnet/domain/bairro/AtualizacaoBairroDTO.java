package br.com.gerencialnet.domain.bairro;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoBairroDTO(
		
		@NotNull
		Long id,
		
		String nome,
				
		@Nullable
		Long idTipoBairro
		) {

}
