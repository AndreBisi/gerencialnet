package br.com.gerencialnet.domain.rua;

import br.com.gerencialnet.domain.logradouro.DetalhamentoLogradouroDTO;
import br.com.gerencialnet.domain.logradouro.Logradouro;

public record ListagemRuaDTO(Long id, String nome, String cep, DetalhamentoLogradouroDTO logradouroDTO ) {
	
    public ListagemRuaDTO(Rua rua){
        this(
        		rua.getId(), 
				rua.getNome(), 
				rua.getCep(), 
				rua.getLogradouro() != null ? new DetalhamentoLogradouroDTO(rua.getLogradouro()) : null 
			);
    }

}
