package br.com.gerencialnet.domain.tecnico;

import jakarta.validation.constraints.NotBlank;

public record CadastroTecnicoDTO(
		
		@NotBlank
		String nome,
		
		Boolean ativo
		) {

}
