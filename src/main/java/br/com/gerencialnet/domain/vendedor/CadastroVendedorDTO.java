package br.com.gerencialnet.domain.vendedor;

import jakarta.validation.constraints.NotBlank;

public record CadastroVendedorDTO(
		
		@NotBlank
		String nome,
		
		Boolean ativo
		
		) {

}
