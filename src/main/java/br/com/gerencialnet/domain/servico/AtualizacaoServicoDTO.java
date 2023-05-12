package br.com.gerencialnet.domain.servico;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoServicoDTO(
		
		@NotNull
        Long id,
        
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        
        Boolean cobrar,
        
		BigDecimal valor,
		
		Boolean adesao) {

}
