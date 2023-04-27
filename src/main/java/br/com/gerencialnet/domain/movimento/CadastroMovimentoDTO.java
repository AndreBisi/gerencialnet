package br.com.gerencialnet.domain.movimento;

import jakarta.validation.constraints.NotBlank;

public record CadastroMovimentoDTO(
		
		@NotBlank(message = "O nome é obrigatório")
		String nome,
		
		Boolean ativo,
		
		String sinal,
		
		Boolean recebimento,
		
		Boolean pagamento
		) {

}
