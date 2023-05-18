package br.com.gerencialnet.domain.rua;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record CadastroRuaDTO(
		
		@NotBlank(message ="Nome da rua é obrigatório")
		String nome,
		
		String cep,
		
		@Nullable
		Long idLogradouro
		) {

}
