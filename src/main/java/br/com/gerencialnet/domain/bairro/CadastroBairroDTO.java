package br.com.gerencialnet.domain.bairro;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record CadastroBairroDTO(		
		
		@NotBlank(message ="Nome é obrigatório")
		String nome,

		@Nullable
		Long idTipoBairro
		) {

}
