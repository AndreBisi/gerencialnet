package br.com.gerencialnet.domain.rua;

import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import jakarta.annotation.Nullable;

public record DetalhamentoRuaDTO(Long id, String nome, String cep, @Nullable DetalhamentoLogradouroDTO logradouro ) {
	
	public DetalhamentoRuaDTO(Rua rua) {
		
		this(
				rua.getId(), 
				rua.getNome(), 
				rua.getCep(), 				
				new DetalhamentoLogradouroDTO(rua.getLogradouro())
			);
	
	}
}
