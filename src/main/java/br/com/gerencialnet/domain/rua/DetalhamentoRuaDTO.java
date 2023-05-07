package br.com.gerencialnet.domain.rua;

import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.Logradouro;

public record DetalhamentoRuaDTO(Long id, String nome, String cep, DetalhamentoLogradouroDTO logradouroDTO ) {
	
	public DetalhamentoRuaDTO(Rua rua) {
		
		this(
				rua.getId(), 
				rua.getNome(), 
				rua.getCep(), 
				rua.getLogradouro() != null ? new DetalhamentoLogradouroDTO(rua.getLogradouro()) : null 
			);	
	
	}
	
}
