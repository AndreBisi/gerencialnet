package br.com.gerencialnet.domain.tecnico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoTecnicoDTO(
		
		@NotNull
		Long id,
		
		@NotBlank
		String nome,
		
		Boolean ativo		
		) {

}
