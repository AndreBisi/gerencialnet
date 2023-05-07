package br.com.gerencialnet.domain.tipoBairro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizacaoTipoBairroDTO(

		@NotNull 
		Long id,

		@NotBlank(message = "O nome é obrigatório") 
		String nome,

		String abreviacao) {

}
