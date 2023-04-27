package br.com.gerencialnet.domain.movimento;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoMovimentoDTO(
		
		@NotNull
		Long id,
		
		String nome,
		Boolean ativo,
		String sinal,
		Boolean recebimento,
		Boolean pagamento) {

}
