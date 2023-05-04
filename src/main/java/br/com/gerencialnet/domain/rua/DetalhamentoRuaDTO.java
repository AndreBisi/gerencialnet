package br.com.gerencialnet.domain.rua;

import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.Logradouro;

public record DetalhamentoRuaDTO(Long id, String nome, String cep, Logradouro logradouro ) {
	
	public DetalhamentoRuaDTO(Rua rua) {
		
		this(
				rua.getId(), 
				rua.getNome(), 
				rua.getCep(), 
				rua.getLogradouro()
				//new DetalhamentoLogradouroDTO(rua.getLogradouro().getId(), rua.getLogradouro().getNome(), rua.getLogradouro().getAbreviacao())
			);
	
	}
	
}
