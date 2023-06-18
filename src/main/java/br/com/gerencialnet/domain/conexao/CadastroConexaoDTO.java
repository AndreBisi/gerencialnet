package br.com.gerencialnet.domain.conexao;

import jakarta.validation.constraints.NotBlank;

public record CadastroConexaoDTO(
		
		@NotBlank(message = "A descrição é obrigatória")
        String descricao
        
		) {

}
