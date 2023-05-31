package br.com.gerencialnet.domain.servico;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record CadastroServicoDTO(
		
        @NotBlank(message = "O nome e obrigatorio")
        String nome,

        Boolean cobrar,
        
		BigDecimal valor,
		
		Boolean adesao) {
	

}
