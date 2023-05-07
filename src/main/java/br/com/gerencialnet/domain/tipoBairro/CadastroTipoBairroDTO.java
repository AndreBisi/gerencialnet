package br.com.gerencialnet.domain.tipoBairro;

import jakarta.validation.constraints.NotBlank;

public record CadastroTipoBairroDTO(
		
		@NotBlank(message="O nome é obrigatório")
		String nome,
		
		String abreviacao
		
		) {

}
