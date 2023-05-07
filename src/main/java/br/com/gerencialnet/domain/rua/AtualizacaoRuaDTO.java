package br.com.gerencialnet.domain.rua;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoRuaDTO(
		
		@NotNull
		Long id,
		
		String nome,
		
		String cep,
		
		@Nullable
		Long idlogradouro
		) {

}
