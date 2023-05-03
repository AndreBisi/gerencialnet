package br.com.gerencialnet.domain.rua;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import br.com.gerencialnet.domain.logradouro.Logradouro;

public record CadastroRuaDTO(
		
		@NotBlank(message ="Nome da rua é obrigatório")
		String nome,
		
		String cep,
		
		@Nullable
		Logradouro logradouro
		) {

}
