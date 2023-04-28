package br.com.gerencialnet.domain.movimento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoMovimentoDTO(
		
		@NotNull
		Long id,
		
		@NotBlank
		String nome,
		
		@NotNull
		Boolean ativo,
		
		@NotNull
		String sinal,
		
		@NotNull
		Boolean recebimento,
		
		@NotNull
		Boolean pagamento) {

}
