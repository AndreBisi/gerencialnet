package br.com.gerencialnet.domain.vendedor;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder.Default;

public record CadastroVendedorDTO(
		
		@NotBlank
		String nome,
		
		Boolean ativo
		
		) {

}
