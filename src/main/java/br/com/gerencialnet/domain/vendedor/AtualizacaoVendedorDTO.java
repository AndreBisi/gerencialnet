package br.com.gerencialnet.domain.vendedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoVendedorDTO(
		
		@NotNull
		Long id,
		
		@NotBlank
		String nome,
		
		Boolean ativo
		) {

}
